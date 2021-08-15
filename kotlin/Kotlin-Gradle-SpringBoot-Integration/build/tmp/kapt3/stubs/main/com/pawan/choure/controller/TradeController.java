package com.pawan.choure.controller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\b\b\u0001\u0010\u0015\u001a\u00020\u0007H\u0017J\b\u0010\u0016\u001a\u00020\u0017H\u0017J\u001a\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\b\b\u0001\u0010\u0015\u001a\u00020\u0007H\u0017R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0012X\u0093\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00070\u00070\u0006X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0012X\u0093\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/pawan/choure/controller/TradeController;", "", "()V", "inputChannelTrade", "Lorg/springframework/messaging/SubscribableChannel;", "message1", "Lorg/springframework/messaging/Message;", "", "getMessage1", "()Lorg/springframework/messaging/Message;", "setMessage1", "(Lorg/springframework/messaging/Message;)V", "message2", "kotlin.jvm.PlatformType", "getMessage2", "setMessage2", "tradeMapper", "Lcom/pawan/choure/mapper/TradeMapper;", "helloWorldSpringIntegration", "", "Lcom/pawan/choure/model/Trade;", "name", "pubSub", "", "trade", "Kotlin-Gradle-SpringBoot-Integration"})
@org.springframework.integration.config.EnableIntegration
@org.springframework.web.bind.annotation.RestController
public class TradeController {
    @org.springframework.beans.factory.annotation.Autowired
    private final com.pawan.choure.mapper.TradeMapper tradeMapper = null;
    @org.springframework.beans.factory.annotation.Autowired
    private final org.springframework.messaging.SubscribableChannel inputChannelTrade = null;
    @org.jetbrains.annotations.NotNull
    private org.springframework.messaging.Message<java.lang.String> message1;
    @org.jetbrains.annotations.NotNull
    private org.springframework.messaging.Message<java.lang.String> message2;
    
    @org.jetbrains.annotations.Nullable
    @org.springframework.web.bind.annotation.GetMapping(value = {"/trade"})
    public java.util.List<com.pawan.choure.model.Trade> trade(@org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.RequestParam(value = "tradeId", defaultValue = "TE123")
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @org.springframework.web.bind.annotation.GetMapping(value = {"/springIntegration"})
    public java.util.List<com.pawan.choure.model.Trade> helloWorldSpringIntegration(@org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.RequestParam(value = "name", defaultValue = "AA")
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public org.springframework.messaging.Message<java.lang.String> getMessage1() {
        return null;
    }
    
    public void setMessage1(@org.jetbrains.annotations.NotNull
    org.springframework.messaging.Message<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public org.springframework.messaging.Message<java.lang.String> getMessage2() {
        return null;
    }
    
    public void setMessage2(@org.jetbrains.annotations.NotNull
    org.springframework.messaging.Message<java.lang.String> p0) {
    }
    
    @org.springframework.web.bind.annotation.GetMapping(value = {"/pubSub"})
    public void pubSub() {
    }
    
    public TradeController() {
        super();
    }
}