package com.dio.eletronicosapi.service;

import com.dio.eletronicosapi.document.Eletronicos;
import com.dio.eletronicosapi.repository.EletronicosRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EletronicosService {

    private final EletronicosRepository eletronicosRepository;

    public EletronicosService(EletronicosRepository eletronicosRepository) {
        this.eletronicosRepository = eletronicosRepository;
    }
    public Flux<Eletronicos> findAll(){

        return Flux.fromIterable(this.eletronicosRepository.findAll());
    }
    public  Mono<Eletronicos> findByIDEletronicos(String id){

        return  Mono.justOrEmpty(this.eletronicosRepository.findById(id));
    }

    public Mono<Eletronicos> save(Eletronicos eletronicos){
        return  Mono.justOrEmpty(this.eletronicosRepository.save(eletronicos));
    }

    public Mono<Boolean> deleteByIDEletronicos(String id) {
        eletronicosRepository.deleteById(id);
        return Mono.just(true);
    }
}
