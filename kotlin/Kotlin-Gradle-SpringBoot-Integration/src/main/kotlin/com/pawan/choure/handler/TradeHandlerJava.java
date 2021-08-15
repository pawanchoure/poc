package com.pawan.choure.handler;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;

public class TradeHandlerJava {

    @ServiceActivator
    public String handleMessage(Message<?> message) throws MessagingException {
        System.out.println(message.getHeaders());
        System.out.println(message.getPayload());
        System.out.println(message.toString());
        return null;
    }
}
