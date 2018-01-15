package com.kotlin.zcj.tc.tiancai

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@SpringBootApplication
@ServletComponentScan
class TiancaiApplication : WebMvcConfigurerAdapter() {
    override fun configureContentNegotiation(configurer: ContentNegotiationConfigurer?) {
        configurer?.favorPathExtension(false);
    }
}
fun main(args: Array<String>) {
    SpringApplication.run(TiancaiApplication::class.java, *args)
}


