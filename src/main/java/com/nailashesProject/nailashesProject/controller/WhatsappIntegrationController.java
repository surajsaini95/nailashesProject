package com.nailashesProject.nailashesProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nailashesProject.nailashesProject.config.WhatsappServiceClient;
import com.nailashesProject.nailashesProject.request.WhatsapppRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@RequestMapping("/api/post/message")
public class WhatsappIntegrationController {
    @Autowired
    WhatsappServiceClient whatsappServiceClient;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping(consumes={"application/json"})
    public String postMessage(@RequestBody WhatsapppRequestDTO whatsapppRequestDTO) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization","Bearer "+whatsapppRequestDTO.getToken());
        HttpEntity<WhatsapppRequestDTO> entity = new HttpEntity<>(whatsapppRequestDTO,headers);
        return restTemplate.exchange("https://graph.facebook.com/v16.0/113596308344791/messages", HttpMethod.POST, entity, String.class).getBody();
    }
}
