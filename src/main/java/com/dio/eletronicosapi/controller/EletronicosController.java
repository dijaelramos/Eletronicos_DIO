package com.dio.eletronicosapi.controller;

import com.dio.eletronicosapi.document.Eletronicos;
import com.dio.eletronicosapi.repository.EletronicosRepository;
import com.dio.eletronicosapi.service.EletronicosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.dio.eletronicosapi.constants.EletronicosConstant.ELETRONICOS_ENDPOINT_LOCAL;

@RestController
@Slf4j
public class EletronicosController {

    EletronicosService eletronicosService;

    EletronicosRepository eletronicosRepository;

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(EletronicosController.class);

    public EletronicosController(EletronicosService eletronicosService, EletronicosRepository eletronicosRepository) {
        this.eletronicosService = eletronicosService;
        this.eletronicosRepository = eletronicosRepository;
    }

    @GetMapping(ELETRONICOS_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Eletronicos> getAllItems() {
        log.info("requesting the list off all Eletronicos");
        return eletronicosService.findAll();
    }

    @GetMapping(ELETRONICOS_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Eletronicos>> findByIdEletronicos(@PathVariable String id) {
        log.info("Requesting the eletronicos with id {}", id);
        return eletronicosService.findByIDEletronicos(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(ELETRONICOS_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Eletronicos> createEletronicos(@RequestBody Eletronicos eletronicos) {
        log.info("A new Eletronico was Created");
        return eletronicosService.save(eletronicos);
    }

    @DeleteMapping(ELETRONICOS_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deleteByIDEletronicos(@PathVariable String id) {
        EletronicosService.deleteByIDEletronicos(id);
        log.info("Deleting the eletronico with id {}", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }
}
