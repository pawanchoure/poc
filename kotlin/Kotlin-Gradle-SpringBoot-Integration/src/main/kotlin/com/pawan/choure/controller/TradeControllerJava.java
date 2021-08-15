package com.pawan.choure.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import  com.pawan.choure.handler.TradeMessageHandler;

@RestController
@EnableIntegration
public class TradeControllerJava {

/*    @Autowired
    private MessageChannel inputChannel;

    @Autowired
    private PollableChannel outputChannel;


    @GetMapping("/pubSub")
    public String pubSub() {
        inputChannel.send(MessageBuilder.withPayload("Hello").build());
        System.out.println(outputChannel.receive(0).getPayload());
        return  "Hello";
    }*/

/*    public void getMessge(){
        TradeMessageHandler t= new TradeMessageHandler();
    }*/

}
