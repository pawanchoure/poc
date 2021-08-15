package com.pawan.choure.handler

import org.springframework.messaging.Message
import org.springframework.messaging.MessageHandler
import org.springframework.messaging.MessagingException
import org.springframework.stereotype.Component

@Component
open class TradeHandler : MessageHandler {
    @Throws(MessagingException::class)
    override fun handleMessage(message: Message<*>) {
        println(message.headers)
        println(message.payload)
        println(message.toString())
    }
}