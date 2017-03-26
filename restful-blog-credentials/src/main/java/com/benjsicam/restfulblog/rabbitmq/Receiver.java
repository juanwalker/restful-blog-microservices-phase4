package com.benjsicam.restfulblog.rabbitmq;

import com.benjsicam.restfulblog.domain.Credentials;
import com.benjsicam.restfulblog.domain.RabbitMQMessage;
import com.benjsicam.restfulblog.service.CredentialsService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

    @Component
    public class Receiver {

        @Autowired
        CredentialsService credentialsService;

        public void receiveMessage(byte[] bytes) throws IOException {
            ObjectMapper mapper = new ObjectMapper();
            RabbitMQMessage message = mapper.readValue(new String(bytes), RabbitMQMessage.class);

            switch (message.getOperation()){

                case "create":
                    this.credentialsService.saveAndFlush(mapper.readValue(message.getBody(), Credentials.class));
                break;

                case "update":
                    this.credentialsService.saveAndFlush(mapper.readValue(message.getBody(), Credentials.class));
                break;
                case "delete":
                    this.credentialsService.delete(mapper.readValue(message.getBody(), Long.class));
                break;
            }

        }
    }
