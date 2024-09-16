package com.jose.servidorservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jose.servidorservice.model.Servidor;
import com.jose.servidorservice.model.StatusServidor;
import com.jose.servidorservice.rabbitMQ.CriacaoProducer;
import com.jose.servidorservice.repository.ServidorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CriacaoService {
    private final CriacaoProducer producer;
    private final ServidorRepository servidorRepository;
    public Servidor CriacaoServidor(Servidor servidor) throws JsonProcessingException {
        producer.send(servidor);
        servidor.setStatus(StatusServidor.CRIADO);
         return servidorRepository.save(servidor);
    }
}
