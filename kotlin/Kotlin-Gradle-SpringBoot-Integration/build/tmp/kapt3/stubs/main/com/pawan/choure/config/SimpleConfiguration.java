package com.pawan.choure.config;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0017\u00a8\u0006\b"}, d2 = {"Lcom/pawan/choure/config/SimpleConfiguration;", "", "()V", "input", "Lorg/springframework/messaging/MessageChannel;", "inputChannel", "outputChannel", "Lorg/springframework/messaging/PollableChannel;", "Kotlin-Gradle-SpringBoot-Integration"})
@org.springframework.context.annotation.Configuration
public class SimpleConfiguration {
    
    @org.jetbrains.annotations.Nullable
    public org.springframework.messaging.MessageChannel input() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @org.springframework.context.annotation.Bean(value = {"inputChannel"})
    public org.springframework.messaging.MessageChannel inputChannel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @org.springframework.context.annotation.Bean(value = {"outputChannel"})
    public org.springframework.messaging.PollableChannel outputChannel() {
        return null;
    }
    
    public SimpleConfiguration() {
        super();
    }
}