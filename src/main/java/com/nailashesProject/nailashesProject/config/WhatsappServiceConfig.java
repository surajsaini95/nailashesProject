package com.nailashesProject.nailashesProject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WhatsappServiceConfig {

    @Bean(name = "whatsappClient")
    public WebClient getRfiServiceClient(){
        return WebClient.builder().build();
    }

}
