import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupByTester {
    public static void main(String[] args) {
        TicBDrillDownData ticBDrillDownData= new TicBDrillDownData("DESCO","Equity","America",1,76d,100d,"USD");
        TicBDrillDownData ticBDrillDownData1= new TicBDrillDownData("DESCO","Equity","America",1,76d,100d,"USD");
        TicBDrillDownData ticBDrillDownData2= new TicBDrillDownData("DESCO","Equity","America",1,76d,100d,"USD");
        TicBDrillDownData ticBDrillDownData3= new TicBDrillDownData("DESCO","Bond","Europe",1,76d,100d,"USD");
        TicBDrillDownData ticBDrillDownData4= new TicBDrillDownData("DESCO","Bond","Europe",1,76d,100d,"USD");
        TicBDrillDownData ticBDrillDownData5= new TicBDrillDownData("DESCO","Bond","Asia",1,76d,100d,"USD");
        TicBDrillDownData ticBDrillDownData6= new TicBDrillDownData("DESCO","Bond","Asia",1,76d,100d,"USD");

        TicBDrillDownData ticBDrillDownDataB0= new TicBDrillDownData("BAAM","Equity","America",1,76d,100d,"USD");
        TicBDrillDownData ticBDrillDownDataB1= new TicBDrillDownData("BAAM","Equity","America",1,76d,100d,"USD");
        TicBDrillDownData ticBDrillDownDataB2= new TicBDrillDownData("BAAM","Equity","America",1,76d,100d,"USD");
        TicBDrillDownData ticBDrillDownDataB3= new TicBDrillDownData("BAAM","Bond","Europe",1,76d,100d,"USD");
        TicBDrillDownData ticBDrillDownDataB4= new TicBDrillDownData("BAAM","Bond","Europe",1,76d,100d,"USD");
        TicBDrillDownData ticBDrillDownDataB5= new TicBDrillDownData("BAAM","Bond","Asia",1,76d,100d,"USD");
        TicBDrillDownData ticBDrillDownDataB6= new TicBDrillDownData("BAAM","Bond","Asia",1,76d,100d,"USD");

        List<TicBDrillDownData> ticBDrillDownDataList= new ArrayList<>();
        ticBDrillDownDataList.add(ticBDrillDownData);
        ticBDrillDownDataList.add(ticBDrillDownData1);
        ticBDrillDownDataList.add(ticBDrillDownData2);
        ticBDrillDownDataList.add(ticBDrillDownData3);
        ticBDrillDownDataList.add(ticBDrillDownData4);
        ticBDrillDownDataList.add(ticBDrillDownData5);
        ticBDrillDownDataList.add(ticBDrillDownData6);
        ticBDrillDownDataList.add(ticBDrillDownDataB0);
        ticBDrillDownDataList.add(ticBDrillDownDataB1);
        ticBDrillDownDataList.add(ticBDrillDownDataB2);
        ticBDrillDownDataList.add(ticBDrillDownDataB3);
        ticBDrillDownDataList.add(ticBDrillDownDataB4);
        ticBDrillDownDataList.add(ticBDrillDownDataB5);
        ticBDrillDownDataList.add(ticBDrillDownDataB6);




       /* Function<TicBDrillDownData, List<Object>> compositeKey = personRecord ->
                Arrays.<Object>asList(personRecord.getTicOrgType(), personRecord.getAssetClass(),personRecord.getRegionName());*/


        Function<TicBDrillDownData,String> keyGetter = personRecord ->
                StringUtils.join(personRecord.getTicOrgType(), personRecord.getAssetClass(),personRecord.getRegionName());

        Function<TicBDrillDownData,String> keyGetterString = personRecord ->
                StringUtils.join("ticOrgType", "assetClass","regionName");

        Map<Object, List<TicBDrillDownData>> resultKeyGetter =
                ticBDrillDownDataList.stream().collect(Collectors.groupingBy(keyGetter, Collectors.toList()));

        Map<Object, List<TicBDrillDownData>> resultKeyGetterString =
                ticBDrillDownDataList.stream().collect(Collectors.groupingBy(keyGetterString, Collectors.toList()));

        List<String> doubleList= new ArrayList<>(Arrays.asList("filingValueUsd","filingValueUsdMillion"));

        Map<Object, List<TicBDrillDownData>> resultGroupBy =
                ticBDrillDownDataList.stream().collect(Collectors.groupingBy(keyGetter,Collectors.collectingAndThen(Collectors.toList(),x ->{
                    List<TicBDrillDownData> list= new ArrayList<>();
                    TicBDrillDownData data= x.get(0);
                    for(String name: doubleList){
                        OptionalDouble average = x.stream().mapToDouble(y->y.getValue(name)).average();
                        if(name=="filingValueUsdMillion"){
                            data.setFilingValueUsdMillion(average.orElse(-1));
                        }else if(name=="filingValueUsd"){
                            data.setFilingValueUsd(average.orElse(-1));
                        }
                    }
                    Integer sum = x.stream().mapToInt(TicBDrillDownData::getCountryId).sum();
                    data.setCountryId(sum);
                    list.add(data);
                    return  list;
                })));

        for (Object name : resultGroupBy.keySet())
        {
            // search  for value
            List<TicBDrillDownData> sub= resultGroupBy.get(name);

            System.out.println(sub.stream()
                    .map(TicBDrillDownData::getFilingValueUsd)
                    .reduce(0d,Double::max));

            TicBDrillDownData bDrillDownData=sub.stream().reduce(new TicBDrillDownData(),(c,p) -> {
                c=p;
               /* c.setCountryId(p.getCountryId());
                if(c.getFilingValueUsd()!=null){
                    c.setFilingValueUsd(Double.sum(c.getFilingValueUsd(),p.getFilingValueUsd()));
                }else {
                    c.setFilingValueUsd(p.getFilingValueUsd());
                }*/

                return c;
            });

            TicBDrillDownData bDrillDownData2=sub.stream().reduce(new TicBDrillDownData(),(object,element)->{
                object = element;
                if(object.getFilingValueUsd()!=null){
                    object.setFilingValueUsd(Double.sum(object.getFilingValueUsd(),object.getFilingValueUsd()));
                }else {
                    object.setFilingValueUsd(object.getFilingValueUsd());
                }
                return object;
            });
/*            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            int result2 = numbers.stream().reduce(0, Integer::sum);
            Optional<Integer> result3 = numbers.stream().reduce( Integer::sum);
            System.out.println(result2);
            System.out.println(result3);*/

        }
    }
}
