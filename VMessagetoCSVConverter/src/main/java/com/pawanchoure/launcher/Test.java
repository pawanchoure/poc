package com.pawanchoure.launcher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Pawan on 2/8/2016.
 */
public class Test {
    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/dd/mm hh:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String dateInString = "2013/05/03 12:13:00";
        Date date = sdf.parse(dateInString);
        System.out.println(sdf.format(date));
        SimpleDateFormat sdf2 = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss");
        System.out.println(sdf2.format(date)); //Tue Aug 31 10:20:56 SGT 1982

/*        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "31-08-1982 10:20:56";
        Date date = sdf.parse(dateInString);
        System.out.println(date); //Tue Aug 31 10:20:56 SGT 1982*/
    }
}
