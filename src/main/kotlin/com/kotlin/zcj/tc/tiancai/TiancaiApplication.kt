package com.kotlin.zcj.tc.tiancai

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@SpringBootApplication
@ServletComponentScan
class TiancaiApplication

fun main(args: Array<String>) {
    SpringApplication.run(TiancaiApplication::class.java, *args)
}
