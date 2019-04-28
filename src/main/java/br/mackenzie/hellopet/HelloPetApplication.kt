package br.mackenzie.hellopet

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class HelloPetApplication

fun main (args : Array<String>) {
    SpringApplication.run(HelloPetApplication::class.java, *args)
}