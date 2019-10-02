package com.altran.manuelstore.controllers;

import com.altran.manuelstore.models.Produto;
import com.altran.manuelstore.repository.ProductRepository;
import org.apache.catalina.mapper.MapperListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("/api/products")
public class ProductController {

    @Autowired
    public ProductRepository productRepository;

    @PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody Produto produto){
        Produto p = productRepository.save(produto);
        return ResponseEntity.ok(p);
    }

}
