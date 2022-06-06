package io.github.ufukhalis.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class SpringBootCoroutinesApplication

fun main(args: Array<String>) {
    runApplication<SpringBootCoroutinesApplication>(*args)
}
