package com.pawanchoure.launcher;

import com.pawanchoure.implementor.VMessagetoCSV;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Pawan on 2/7/2016.
 */
public class ConvertorMain {

private String inputSourceLocation,outputSourceLocation;

    public String getInputSourceLocation() {
        return inputSourceLocation;
    }

    public void setInputSourceLocation(String inputSourceLocation) {
        this.inputSourceLocation = inputSourceLocation;
    }

    public String getOutputSourceLocation() {
        return outputSourceLocation;
    }

    public void setOutputSourceLocation(String outputSourceLocation) {
        this.outputSourceLocation = outputSourceLocation;
    }

    public static void main(String[] args){
        System.out.println("ConvertorMain");

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "SpringBeans.xml");

        ConvertorMain convertorMain = (ConvertorMain) context.getBean("converter");
        VMessagetoCSV vMessagetoCSV = (VMessagetoCSV) context.getBean("vMessageToCSV");
        vMessagetoCSV.convert(convertorMain.getInputSourceLocation(),convertorMain.getOutputSourceLocation());



    }

}
