package gmail;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

/**
 * Created by Pawan on 18-03-2019.
 */
public class CheckingMailsIMAP {

    int rownum = 0;
    HSSFSheet firstSheet;
    Collection<File> files;
    HSSFWorkbook workbook;
    File exactFile;

    {
        workbook = new HSSFWorkbook();
        firstSheet = workbook.createSheet("ROHAN E TRANSACTIONS");
        Row headerRow = firstSheet.createRow(rownum);
        headerRow.setHeightInPoints(40);
    }


    public static void check(String host, String storeType, String user,
                             String password) {
        try {

            Session emailSession = Session.getDefaultInstance(new Properties());

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("imaps");

            store.connect(host, 993, user, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("TEST");
            emailFolder.open(Folder.READ_ONLY);
            emailFolder.getUnreadMessageCount();

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);
            List<String> headerRow = getHeader();
            List<List> recordToAdd = new ArrayList<List>();
            recordToAdd.add(headerRow);
            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                String contentType = message.getContentType();
                String messageContent = "";

                if (contentType.contains("multipart")) {

                    Multipart multiPart = (Multipart) message.getContent();
                    int numberOfParts = multiPart.getCount();
                    for (int partCount = 0; partCount < numberOfParts; partCount++) {
                        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                        if (StringUtils.equalsIgnoreCase(part.getContentType(), "TEXT/HTML; charset=UTF-8")) {
                            messageContent = part.getContent().toString();
                            InputStream inputstream = new ByteArrayInputStream(messageContent.getBytes());
                            ParseContext pcontext = new ParseContext();
                            //detecting the file type
                            BodyContentHandler handler = new BodyContentHandler();

                            Metadata metadata = new Metadata();
                            //Html parser
                            HtmlParser htmlparser = new HtmlParser();

                            htmlparser.parse(inputstream, handler, metadata, pcontext);
                            messageContent = handler.toString();
                            List<String> rowsList=getRow(message.getSubject(),message.getFrom()[0].toString(),messageContent);
                            if(rowsList.size() > 2){
                                recordToAdd.add(rowsList);
                            }

                        }/* else if (part.getContentType().contains("text/plain")
                                || part.getContentType().contains("text/html")
                                || part.getContentType().contains("TEXT/HTML")
                                || part.getContentType().contains("TEXT/PLAIN")
                                ) {
                            Object content = part.getContent();
                            if (content != null) {
                                messageContent =  part.getContent().toString();
                                List<String> rowsList=getRow(message.getFrom()[0].toString(),messageContent);
                                if(rowsList.size() > 1){
                                    recordToAdd.add(rowsList);
                                }
                            }
                        }*/
                    }
                } else if (contentType.contains("text/plain")
                        || contentType.contains("text/html")
                        || contentType.contains("TEXT/HTML")
                        || contentType.contains("TEXT/PLAIN")) {
                    Object content = message.getContent();
                    if (content != null) {
                        messageContent = content.toString();
                        List<String> rowsList=getRow(message.getSubject(), message.getFrom()[0].toString(),messageContent);
                        if(rowsList.size() > 2){
                            recordToAdd.add(rowsList);
                        }
                    }
                }
                System.out.println(" Message: " + messageContent);
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());

            }


            CheckingMailsIMAP cls = new CheckingMailsIMAP(recordToAdd);
            cls.createExcelFile();
            //close the store and folder objects
            emailFolder.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }

    public static void main(String[] args) throws TikaException, SAXException, IOException {

        String host = "imap.googlemail.com";// change accordingly
        String mailStoreType = "pop3";
        String username = "rohan.abhilasha.e.finance@gmail.com";// change accordingly
        String password = "Pass$word@19";// change accordingly

        check(host, mailStoreType, username, password);
/*        String input="<div dir=\"ltr\"><br>Hello,<br><br>Please find the below details of the Maintenance Paid.<br><table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse:collapse;color:rgb(117,117,117);font-family:Helvetica;font-size:16px\"><tbody><tr><td style=\"width:312px\">Name</td><td style=\"width:312px\"> Saswati Chakraborty &amp; Arunodaya Das</td></tr><tr><td style=\"width:312px\">Flat Number</td><td style=\"width:312px\"> E1 - 1003</td></tr><tr><td style=\"width:312px\">Transaction Reference No.</td><td style=\"width:312px\"> 1666501893</td></tr><tr><td style=\"width:312px\">Transaction Date</td><td style=\"width:312px\"> 19/03/2019 11:38:21</td></tr><tr><td style=\"width:312px\">Amount</td><td style=\"width:312px\"> Rs 10000/-</td></tr></tbody></table><br><div>Please let me know, if anything else is required.</div><div><br></div><div>Thanks and Regards</div><div>Aruno</div></div>";

        InputStream inputstream = new ByteArrayInputStream(input.getBytes());
        ParseContext pcontext = new ParseContext();
        //detecting the file type
        BodyContentHandler handler = new BodyContentHandler();

        Metadata metadata = new Metadata();
        //Html parser
        HtmlParser htmlparser = new HtmlParser();

        htmlparser.parse(inputstream, handler, metadata,pcontext);
        System.out.println("Contents of the document:" + handler.toString());
        System.out.println("Metadata of the document:");
        String[] metadataNames = metadata.names();

        for(String name : metadataNames) {
            System.out.println(name + ":   " + metadata.get(name));
        }*/
    }

    private static List<String> getRow(String subject, String from, String messageContent) throws Exception {
        List<String> rows = new ArrayList<String>();
        //Getting String Array for Required Attributes Only
        String[] lines = messageContent.split("\\r?\\n");
        List<String> words= new ArrayList<>();
        words.add("Name");
        words.add("Flat Number");
        words.add("Transaction Reference No.");
        words.add("Transaction Date");
        words.add("Amount");
        rows.add(subject);
        rows.add(from);
        for (String line : lines) {
            line=StringUtils.trim(line);
            if(StringUtils.startsWithIgnoreCase(line,words.get(0))){
                String name=StringUtils.trim(StringUtils.removeStartIgnoreCase(line,words.get(0)));
                name=StringUtils.replaceFirst(name,"/^,:;-.+/","");

            }
            if(StringUtils.startsWithIgnoreCase(line,words.get(1))){
                rows.add(StringUtils.trim(StringUtils.removeStartIgnoreCase(line,words.get(1))));
            }
            if(StringUtils.startsWithIgnoreCase(line,words.get(2))){
                rows.add(StringUtils.trim(StringUtils.removeStartIgnoreCase(line,words.get(2))));
            }
            if(StringUtils.startsWithIgnoreCase(line,words.get(3))){
                rows.add(StringUtils.trim(StringUtils.removeStartIgnoreCase(line,words.get(3))));
            }
            if(StringUtils.startsWithIgnoreCase(line,words.get(4))){
                rows.add(StringUtils.trim(StringUtils.removeStartIgnoreCase(line,words.get(4))));
            }

        }
return rows;
    }

    private static List<String> getHeader() {
        List<String> headerRow = new ArrayList<String>();
        headerRow.add("Subject");
        headerRow.add("Email");
        headerRow.add("Name");
        headerRow.add("Flat Number");
        headerRow.add("Transaction Reference No.");
        headerRow.add("Transaction Date");
        headerRow.add("Amount");
        return headerRow;
    }


    void createExcelFile(){
        FileOutputStream fos = null;
        try {
            fos=new FileOutputStream(new File("RohanAbhilashaE.xls"));
            HSSFCellStyle hsfstyle=workbook.createCellStyle();
            hsfstyle.setFillBackgroundColor((short)245);
            workbook.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    CheckingMailsIMAP(List<List> l1) throws Exception {
        try {
            for (int j = 0; j < l1.size(); j++) {
                Row row = firstSheet.createRow(rownum);
                List<String> l2= l1.get(j);
                for(int k=0; k<l2.size(); k++)
                {
                    Cell cell = row.createCell(k);
                    cell.setCellValue(l2.get(k));
                }
                rownum++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
