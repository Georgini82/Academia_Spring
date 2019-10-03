package com.altran.manuelstore.controllers;

import com.altran.manuelstore.models.Produto;
import com.altran.manuelstore.repository.ProductRepository;
import org.apache.catalina.mapper.MapperListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping ("/api/products")
public class ProductController {

    @Autowired
    public ProductRepository productRepository;

    // POST
    @PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody Produto produto){
        Produto p = productRepository.save(produto);
        return ResponseEntity.ok(p);
    }

    // GET ALL
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    // GET BY ID
    @GetMapping(path = "/{id}")
    public ResponseEntity getById(@PathVariable Integer id){
        return ResponseEntity.ok(productRepository.findById(id));
    }

    // PUT (atualizar)

    // DELETE

}
