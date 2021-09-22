package com.grak0s.webclientrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WebclientRestApplication {

    public static void main(String[] args) {


        ConfigurableApplicationContext context = SpringApplication.run(WebclientRestApplication.class, args);
        QuoteClient quoteClient = context.getBean(QuoteClient.class);
        // We need to block for the content here or the JVM might exit before the message is logged
        System.out.println(">> message = " + quoteClient.getMessage().block());



    }






}
