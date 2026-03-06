package com.example.BMI

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BmiApplication

fun main(args: Array<String>) {
	runApplication<BmiApplication>(*args)
}
