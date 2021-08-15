package com.pawan.choure.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.annotation.ServiceActivator
import org.springframework.integration.channel.DirectChannel
import org.springframework.integration.channel.QueueChannel
import org.springframework.integration.dsl.MessageChannels
import org.springframework.integration.handler.ServiceActivatingHandler
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.MessageHandler
import org.springframework.messaging.PollableChannel

@Configuration
class SimpleConfiguration {

/*    @Bean
    fun oddFlow() =
        IntegrationFlow { flow ->
            flow.handle<Any> { _, _ -> "odd" }
        }*/

    fun input(): MessageChannel? {
        return MessageChannels.direct().get()
    }
/*    @Bean
    @Qualifier
    fun myFlow(): IntegrationFlow? {
        return IntegrationFlows.from(MessageChannels.direct("input"))
            .filter { anObject: Any? -> "World".equals(anObject) }
            .transform { str: String -> "Hello $str" }
            .handle { x: Message<*>? -> println(x) }
            .get()
    }*/

/*    @Bean
    fun process(input: MessageChannel): CommandLineRunner? {
        return CommandLineRunner { args -> input.send(MessageBuilder.withPayload("World").build()) }
    }

    fun processMessage(input: MessageChannel){
        input.send(MessageBuilder.withPayload("World").build())
    }*/

    /*    @Bean
    CommandLineRunner process(MessageChannel input){
        return args -> {
            input.send(MessageBuilder.withPayload("World").build());
        };
    }*/
    /*    @Bean
    public IntegrationFlow simpleFlow(){
        return IntegrationFlows.from(MessageChannels.direct("inputJava"))
                .filter("World"::equals)
                .transform("Hello "::concat)
                //.handle("simpleMessageHandler","process")  // You can uncomment this for using a handler. If so, comment out the .handle(System.out::println) statement.
                .handle(System.out::println)
                .get();
    }

    public void process(MessageChannel input){
        input.send(MessageBuilder.withPayload("World").build());
    }*/
    @Bean("inputChannel")
    open fun inputChannel(): MessageChannel? {
        return DirectChannel()
    }

    @Bean("outputChannel")
    open fun outputChannel(): PollableChannel? {
        return QueueChannel()
    }

/*    @Bean
    @ServiceActivator(inputChannel = "inputChannel", outputChannel = "outputChannel")
    open fun serviceActivator(): MessageHandler? {
        return ServiceActivatingHandler(Any())
    }*/



}