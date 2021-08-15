package com.pawan.choure

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinMain

fun main(args: Array<String>) {
    SpringApplication.run(KotlinMain::class.java, *args)
}