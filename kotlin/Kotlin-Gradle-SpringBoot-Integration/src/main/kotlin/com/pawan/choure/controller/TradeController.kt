package com.pawan.choure.controller

import com.pawan.choure.handler.TradeHandler
import com.pawan.choure.handler.TradeMessageHandler
import com.pawan.choure.mapper.TradeMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.integration.config.EnableIntegration
import org.springframework.messaging.Message
import org.springframework.messaging.SubscribableChannel
import org.springframework.messaging.support.MessageBuilder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@EnableIntegration
class TradeController {
    @Autowired
    private val tradeMapper: TradeMapper? = null

 /*   @Autowired
    @Qualifier("inputJava")
    private val someInputChannel: MessageChannel? = null

    private val commandLineRunner: CommandLineRunner?=null;

    private val simpleConfiguration: SimpleConfiguration?=null;*/
   // @Autowired
    //private val messageChannel: MessageChannel?=null;

/*    @Autowired
    @Qualifier("inputChannel")
    private val inputChannel: MessageChannel? = null

    @Autowired
    private val outputChannel: PollableChannel? = null*/


 /*   @Autowired
    @Qualifier("helloGateway")
    private val tradeService: TradeServiceImpl? = null*/

    @Autowired
    private val inputChannelTrade: SubscribableChannel? = null

    @GetMapping("/trade")
    fun trade(@RequestParam(value = "tradeId", defaultValue = "TE123") name: String) =
        this.tradeMapper?.findByTradeId("TE123")

    @GetMapping("/springIntegration")
    fun helloWorldSpringIntegration(@RequestParam(value = "name", defaultValue = "AA") name: String) =
        //messageChannel?.send(MessageBuilder.withPayload("World").build());
        //someInputChannel?.send(MessageBuilder.withPayload("World").build())
        //someInputChannel?.send(MessageBuilder.withPayload(name).build())
        //MessageChannels.direct().get().send(MessageBuilder.withPayload(name).build())
        //tradeService?.sayHello(name);
        this.tradeMapper?.findByTradeId("TE123")
        var message1: Message<String> = MessageBuilder.withPayload("Hello World")
            .setHeader("foo", "bar")
            .build()
        var message2 = MessageBuilder.fromMessage(message1).build()

/*    @GetMapping("/pubSub")
    fun pubSub(): String? {
        inputChannel!!.send(org.springframework.integration.support.MessageBuilder.withPayload("Hello").build())
        println(outputChannel!!.receive(0)!!.payload)
        return "Hello"
    }*/
@GetMapping("/pubSub")
fun pubSub() {
    inputChannelTrade?.send(MessageBuilder.withPayload("Hello").build())
}


}