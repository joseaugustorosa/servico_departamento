package com.jose.servidorservice.service;

import com.jose.servidorservice.model.Servidor;
import com.jose.servidorservice.repository.ServidorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServidorService {

    private final ServidorRepository servidorRepository;
    public List<Servidor> findAll() {
        return servidorRepository.findAll();
    }
    public Optional<Servidor> findById(int id) {
        return servidorRepository.findById(id);
    }
    public void save(Servidor servidor) {
        servidorRepository.save(servidor);

    }
    public void delete(int id) {
        servidorRepository.delete(servidorRepository.findById(id).get());
    }
    public Servidor update(int id, Servidor servidor) {
        return servidorRepository.save(servidor);
    }

}
