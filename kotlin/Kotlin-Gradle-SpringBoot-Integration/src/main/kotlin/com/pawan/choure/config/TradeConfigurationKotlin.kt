package com.pawan.choure.config

import org.springframework.context.annotation.Bean
import org.springframework.integration.channel.DirectChannel
import org.springframework.messaging.SubscribableChannel

class TradeConfigurationKotlin {
    @Bean("inputChannelTrade")
    fun inputChannelTrade(): SubscribableChannel? {
        return DirectChannel()
    }
}