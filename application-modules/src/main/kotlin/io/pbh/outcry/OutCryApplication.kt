package io.pbh.outcry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("io.pbh.infrastructure")
@EntityScan(basePackages = ["io.pbh.infrastructure.entity"])
class OutCryApplication

fun main(args: Array<String>) {
    runApplication<OutCryApplication>(*args)
}
