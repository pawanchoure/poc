package com.pawanchoure.implementor;

import com.pawanchoure.template.MessageConverter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang3.StringUtils;
import org.supercsv.cellprocessor.FmtBool;
import org.supercsv.cellprocessor.FmtDate;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.constraint.LMinMax;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvMapWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Pawan on 2/7/2016.
 */
public class VMessagetoCSV implements MessageConverter {


    public void convert(String inputFileFormat, String outputFileFormat) {

        if (validatePath(inputFileFormat) && validatePath(outputFileFormat)) {
            File inputFile = FileUtils.getFile(inputFileFormat);
            Integer counter=0;
            Queue<String> messageQueue = null;
            HashMap<String,Integer> threadMap= new HashMap<String, Integer>();
            Map<Integer, Map<String,String[]>> objectMap= new HashMap<Integer, Map<String, String[]>>();
            boolean isMessage = false,isSubject=false;
            String message = null;
            // Line Iterator
            LineIterator iter = null;
            try {
                iter = FileUtils.lineIterator(inputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (iter.hasNext()) {
                //Getting the first Character of VMessage BEGIN:VMSG
                String line = iter.next();
                if (StringUtils.equalsIgnoreCase("BEGIN:VMSG", line)) {
                    messageQueue = new LinkedList<String>();
                    messageQueue.add(line);

                } else if (StringUtils.equalsIgnoreCase("END:VMSG", line)) {
                    Map<String, String[]> messageLocalMap= new HashMap<String, String[]>();
                    String[] messageAttArray = new String[23];
                    int messageQueueSize = messageQueue.size();
                    counter++;
                    messageQueue.add(line);
                    for (int i = 0; i < messageQueueSize; i++) {
                        String queueObj = messageQueue.remove();
                        System.out.println(queueObj);

                        if(StringUtils.isNotEmpty(queueObj)){
                            if(queueObj.contains("TEL:")){
                                String number=queueObj.split(":")[1];
                                //String concatenateNumber=StringUtils.deleteWhitespace(number);
                                String concatenateNumber=number.replaceAll("\\s+","");
                                messageAttArray[1]=concatenateNumber; //Number
                                messageAttArray[2]=concatenateNumber; //Name

                            }
                            if(queueObj.contains("X-BOX:")){
                                String sendReceive=queueObj.split(":")[1];
                                if(StringUtils.equalsIgnoreCase("SENDBOX",sendReceive)){
                                    messageAttArray[3]="Sent"; //Type
                                    messageAttArray[12]="2";   //type
                                }
                                else
                                {
                                    messageAttArray[3]="Received"; //Type
                                    messageAttArray[12]="1";   //type
                                }
                            }
                            if(StringUtils.startsWith(queueObj,"Date:") && queueObj.contains("Date:")){
                                String messageDateStr=queueObj.split("ate:")[1];

                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
                                SimpleDateFormat sdf2 = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss");
                                Date messageDate = null;
                                try {
                                    messageDate = sdf.parse(messageDateStr);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                messageAttArray[0]=sdf2.format(messageDate);   //Date/Time
                                messageAttArray[7]=String.valueOf(messageDate.getTime());   //date
                              //  messageAttArray[0]=messageDate;   //Date/Time
                               // messageAttArray[7]=messageDate;   //date
                            }
                            if(queueObj.contains("Subject:")){
                                String messageContent=queueObj.split("ubject:")[1];
                                messageAttArray[4]=messageContent;   //Message
                            }
                        }


                    }

                    //Populate other static field
                    messageAttArray[5]="0"; //thread_id  default 0
                    messageAttArray[6]=null;  //Person
                    messageAttArray[8]="0"; //date_sent
                    messageAttArray[9]=null; //protocol
                    messageAttArray[10]="1"; //read
                    messageAttArray[11]="-1"; //status
                    messageAttArray[13]=null; //reply_path_present
                    messageAttArray[14]=null; //subject
                    messageAttArray[15]=null; //service_center
                    messageAttArray[16]="-1"; //failure_cause
                    messageAttArray[17]="0";  //locked
                    messageAttArray[18]="-1"; //sub_id
                    messageAttArray[19]="0"; //stack_type
                    messageAttArray[20]="0"; //error_code;
                    messageAttArray[21]="pawanchoure"; //creator
                    messageAttArray[22]="1"; //seen
                    messageLocalMap.put(messageAttArray[2],messageAttArray);
                    objectMap.put(counter,messageLocalMap);
                    if(threadMap.containsKey(messageAttArray[2])){
                        Integer value=threadMap.get(messageAttArray[2]);
                        value++;
                        threadMap.put(messageAttArray[2],value);
                    }
                    else {
                        threadMap.put(messageAttArray[2],1);
                    }

                } else {
                    if (messageQueue != null) {
                        if (StringUtils.contains(line, "ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8")) {
                            isMessage = true;
                            isSubject =true;
                            String[] splitMessage=line.split("ENCODING=QUOTED-PRINTABLE;CHARSET=UTF-8:");
                            if(splitMessage.length>1){
                                message="Subject:"+splitMessage[1];
                                message=StringUtils.removeEnd(message,"=");
                            }
                        }
                        else{
                            isSubject=false;
                        }
                        if(StringUtils.contains(line,"END:VBODY")){
                            isMessage=false;
                            messageQueue.add(message);
                            message=null;
                        }

                        if(isMessage==true && isSubject!=true){
                            message=message+StringUtils.removeEnd(line,"=");
                        }

                        if (isMessage != true)
                            messageQueue.add(line);


                    }

                }

            }
            writetoCSVFile(objectMap,threadMap);

        }


    }

    private void writetoCSVFile(Map<Integer, Map<String, String[]>> objectMap, HashMap<String, Integer> threadMap) {

        final String[] header = new String[] {"Date/Time","Number","Name","Type","Message","thread_id","person","date","date_sent","protocol","read","status","type","reply_path_present","subject","service_center","failure_cause","locked","sub_id","stack_type","error_code","creator","seen" };

        // create the customer Maps (using the header elements for the column keys)


        ICsvMapWriter mapWriter = null;
        try {
            try {
                mapWriter = new CsvMapWriter(new FileWriter("D:\\SMSBackup.csv"),
                        CsvPreference.STANDARD_PREFERENCE);
            } catch (IOException e) {
                e.printStackTrace();
            }

            final CellProcessor[] processors = getProcessors();

            // write the header
            mapWriter.writeHeader(header);

            for (Map.Entry<Integer, Map<String, String[]>> entry : objectMap.entrySet())
            {
                Map<String, String[]> objectM= entry.getValue();
                for (Map.Entry<String, String[]> entry2 : objectM.entrySet())
                {
                    Map<String, Object> writeMap = createMessageObjectMap(entry2.getKey(),entry2.getValue(),header,threadMap);
                    mapWriter.write(writeMap, header, processors);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if( mapWriter != null ) {
                try {
                    mapWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Map<String, Object> createMessageObjectMap(String key, String[] values, String[] header, HashMap<String, Integer> threadMap) {
        final Map<String, Object> messageMap = new HashMap<String, Object>();
        messageMap.put(header[0], values[0]);
        messageMap.put(header[1], values[1]);
        messageMap.put(header[2], values[2]);
        messageMap.put(header[3], values[3]);
        messageMap.put(header[4], values[4]);
        messageMap.put(header[5], threadMap.get(key));
        messageMap.put(header[6], values[6]);
        messageMap.put(header[7], values[7]);
        messageMap.put(header[8], values[8]);
        messageMap.put(header[9], values[9]);
        messageMap.put(header[10],values[10]);
        messageMap.put(header[11],values[11]);
        messageMap.put(header[12],values[12]);
        messageMap.put(header[13],values[13]);
        messageMap.put(header[14],values[14]);
        messageMap.put(header[15],values[15]);
        messageMap.put(header[16],values[16]);
        messageMap.put(header[17],values[17]);
        messageMap.put(header[18],values[18]);
        messageMap.put(header[19],values[19]);
        messageMap.put(header[20],values[20]);
        messageMap.put(header[21],values[21]);
        messageMap.put(header[22],values[22]);
        return messageMap;

    }

    private boolean validatePath(String inputFileFormat) {
        return StringUtils.isNotEmpty(inputFileFormat);
    }

    /**
     * Sets up the processors used for the examples. There are 10 CSV columns, so 10 processors are defined. All values
     * are converted to Strings before writing (there's no need to convert them), and null values will be written as
     * empty columns (no need to convert them to "").
     *
     * @return the cell processors
     */
    private static CellProcessor[] getProcessors() {


        final CellProcessor[] processors = new CellProcessor[] {
                new NotNull(), // Date/Time
                new NotNull(), // Number
                new NotNull(), // Name
                new NotNull(), // Type Sent(2)/Received (1) Text
                new Optional(), // Message
                new Optional(), // thread_id
                new Optional(), // person null
                new NotNull(), // date
                new Optional(), // date_sent  0
                new Optional(), // protocol null
                new NotNull(), // read  1
                new NotNull(), // status  -1
                new NotNull(), // type Send(2)/Received (1) Code
                new Optional(), // reply_path_present null
                new Optional(), // subject  null
                new Optional(), // service_center  null
                new NotNull(), // failure_cause -1
                new NotNull(), // locked 0
                new NotNull(), // sub_id -1
                new NotNull(), // stack_type 0
                new NotNull(), // error_code 0
                new NotNull(), // creater pawanchoure
                new NotNull(), // seen 1


        };

        return processors;
    }
}
