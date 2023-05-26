package com.nailashesProject.nailashesProject.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nailashesProject.nailashesProject.request.WhatsapppRequestDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WhatsappServiceClient {

    private final WebClient whatsappServiceClient;

    public WhatsappServiceClient(WebClient whatsappServiceClient) {
        this.whatsappServiceClient = whatsappServiceClient;
    }

    public String getWhatsappReponse(@Qualifier("whatsappClient") WhatsapppRequestDTO whatsapppRequestDTO) throws JsonProcessingException {
        String response = whatsappServiceClient.method(HttpMethod.POST)
                .uri("https://graph.facebook.com/v16.0/113596308344791/messages")
                .header("Authorization","Bearer EAAQU5ZBZC8ZBJIBAKdZBZBQCydPtvZAVZAzJyz2tkuVxcxTSug6rFxLka4M8ljxsjIRsi8VyJOJmszZCPXgTnRlO7tYx5r2Nl3Ia5dpXQ3311US0BylJ8hkSbJQM8D3xvs5JiCuHpTFal7ZA66Tvjdci49Ni8haJAJalV7lIchQvNadwnypQirw2AZBcPNLlfHeHhDxeKRkBIPvQZDZD")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue(whatsapppRequestDTO))
                .retrieve()
                .toEntity(String.class).toString();
        return response;

    }
}

