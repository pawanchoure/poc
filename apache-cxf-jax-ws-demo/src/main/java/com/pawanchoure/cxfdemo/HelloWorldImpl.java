
package com.pawanchoure.cxfdemo;

import javax.jws.WebService;

@WebService(endpointInterface = "com.pawanchoure.cxfdemo.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

