package com.jose.servidorservice.rabbitMQ;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jose.servidorservice.model.Servidor;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CriacaoProducer {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    public void send(Servidor servidor) throws JsonProcessingException {
        amqpTemplate.convertAndSend("servidor.exc", "servidor.rk" , objectMapper.writeValueAsString(servidor));
    }

}
