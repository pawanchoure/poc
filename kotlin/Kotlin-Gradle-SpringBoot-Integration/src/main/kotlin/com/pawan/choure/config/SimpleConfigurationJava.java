package com.pawan.choure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.handler.ServiceActivatingHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.PollableChannel;

@Configuration
public class SimpleConfigurationJava {
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



/*    @Bean("inputChannel")
    public MessageChannel inputChannel() {
        return new DirectChannel();
    }

    @Bean("outputChannel")
    public PollableChannel outputChannel() {
        return new QueueChannel();
    }
*/
/*    @Bean
    @ServiceActivator(inputChannel = "inputChannel", outputChannel = "outputChannel",autoStartup = "false")
    public MessageHandler serviceActivator() {
        return new ServiceActivatingHandler(new Object());
    }


    @Bean
    public IntegrationFlow simpleFlow(){
        return IntegrationFlows.from(MessageChannels.direct("inputChannel"))
                .filter("World"::equals)
                .transform("Hello "::concat)
                //.handle("simpleMessageHandler","process")  // You can uncomment this for using a handler. If so, comment out the .handle(System.out::println) statement.
                .handle(System.out::println)
                .get();
    }

    public void processMessage(){

    }*/

/*    @Bean
    @ServiceActivator(inputChannel = "inputChannel", outputChannel = "outputChannel",autoStartup = "false")
    public MessageHandler serviceActivator() {
        return new ServiceActivatingHandler(new Object(),);
        Filt

    }*/

}
