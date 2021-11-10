package com.dio.eletronicosapi.repository;

import com.dio.eletronicosapi.document.Eletronicos;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface EletronicosRepository extends CrudRepository<Eletronicos, String>{
}
