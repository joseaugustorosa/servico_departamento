package com.jose.servidorservice.controller;

import com.jose.servidorservice.model.Servidor;
import com.jose.servidorservice.service.ServidorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ServidorController {
    private final ServidorService servidorService;

    @GetMapping
    public ResponseEntity<List<Servidor>> getAll(@RequestParam(required = false) Optional<String> nome) {

        if (nome.isEmpty()) {
//            Log log = new Log();
//            log.setMensagem("Listando servidores!");
//            log.setData(LocalDate.from(LocalDateTime.now()));
//            logService.save(log);
           return ResponseEntity.ok(servidorService.findAll());
        }else {
//            List<Servidor> servidores = servidorService.findById(nome.get());
//            if (servidores.isEmpty()) {
//
//                return ResponseEntity.noContent().build();
//            }else {
//                return ResponseEntity.ok(servidores);
//            }
            return  ResponseEntity.noContent().build();
        }

    }
    @PostMapping
    public  ResponseEntity<Servidor>  save(@RequestBody Servidor servidor){
        System.out.println(servidor.getDepartamento());
        servidorService.save(servidor);
//        Log log = new Log();
//        log.setMensagem("Novo servidor criado!");
//        log.setData(LocalDate.from(LocalDateTime.now()));
//        logService.save(log);
        return ResponseEntity.status(HttpStatus.CREATED).body(servidor);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Servidor> delete(@PathVariable Integer id){
        try {
            servidorService.delete(id);
//            Log log = new Log();
//            log.setMensagem("Servidor deletado!");
//            log.setData(LocalDate.from(LocalDateTime.now()));
//            logService.save(log);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Servidor> update(@PathVariable Integer id, @RequestBody Servidor servidor){
        try {
            servidorService.update(id, servidor);
//            Log log = new Log();
//            log.setMensagem("Servidor alterado!");
//            log.setData(LocalDate.from(LocalDateTime.now()));
//            logService.save(log);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(servidor);
        } catch (Exception e) {
//            Log log = new Log();
//            log.setMensagem("Nenhum servidor achado para edição!");
//            log.setData(LocalDate.from(LocalDateTime.now()));
//            logService.save(log);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
