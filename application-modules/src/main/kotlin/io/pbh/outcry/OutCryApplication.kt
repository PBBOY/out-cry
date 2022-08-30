package io.pbh.outcry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OutCryApplication

fun main(args: Array<String>) {
    runApplication<OutCryApplication>(*args)
}
