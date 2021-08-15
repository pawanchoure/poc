package com.pawan.choure.controller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0017R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/pawan/choure/controller/GreetingController;", "", "()V", "counter", "Ljava/util/concurrent/atomic/AtomicLong;", "getCounter", "()Ljava/util/concurrent/atomic/AtomicLong;", "greeting", "Lcom/pawan/choure/model/Greeting;", "name", "", "KotlinGradleHelloWorld"})
@org.springframework.web.bind.annotation.RestController
public class GreetingController {
    @org.jetbrains.annotations.NotNull
    private final java.util.concurrent.atomic.AtomicLong counter = null;
    
    @org.jetbrains.annotations.NotNull
    public java.util.concurrent.atomic.AtomicLong getCounter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.GetMapping(value = {"/greeting"})
    public com.pawan.choure.model.Greeting greeting(@org.jetbrains.annotations.NotNull
    @org.springframework.web.bind.annotation.RequestParam(value = "name", defaultValue = "World")
    java.lang.String name) {
        return null;
    }
    
    public GreetingController() {
        super();
    }
}