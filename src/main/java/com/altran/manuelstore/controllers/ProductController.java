package com.altran.manuelstore.controllers;

import com.altran.manuelstore.models.Produto;
import com.altran.manuelstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.stream.Collectors;


@RestController
@RequestMapping ("/api/products")
public class ProductController {

    @Autowired
    public ProductRepository productRepository;

    // POST
    @PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody @Valid Produto produto, BindingResult result){
        // confere se existem erros no formato do produto
        if (result.hasErrors())
            return ResponseEntity.status(
                    HttpStatus.BAD_REQUEST).body(result.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));

        Produto p = productRepository.save(produto);
        return ResponseEntity.ok(p);
    }

    // GET ALL
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    // GET BY ID
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getById(@PathVariable Integer id){
        return ResponseEntity.ok(productRepository.findById(id));
    }

    // PUT (atualizar)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity pu(@RequestBody Produto produto){

        Produto p = productRepository.save(produto);
        return ResponseEntity.ok(p);
    }

    // DELETE
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity delete(@PathVariable Integer id) {

        return ResponseEntity.ok(id);
    }
}
