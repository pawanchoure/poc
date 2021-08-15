package com.pawan.choure

import com.pawan.choure.handler.TradeHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.messaging.SubscribableChannel

@SpringBootApplication
class KotlinMain

@Autowired
private val inputChannelTrade: SubscribableChannel? = null

fun main(args: Array<String>) {
    SpringApplication.run(KotlinMain::class.java, *args)
   // val result = inputChannelTrade?.subscribe(TradeHandler());
}