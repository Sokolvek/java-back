package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class RestApiController {
    @Autowired
    ProductRepo productRepository;

    @GetMapping
    Iterable<Product> getProducts(){
        return productRepository.findAll();
    }



    @GetMapping("/{id}")
    Optional<Product> getProduct(@PathVariable Long id){
        return productRepository.findById(id);
    }

    @GetMapping("product/{name}")
    List<Product> getOneProduct(@PathVariable String name){
        return productRepository.findByName(name);
    }

    @PostMapping
    Product postProduct(@RequestBody Product product){
        return productRepository.save(product);
    }


    @PutMapping("/{id}")
    ResponseEntity<Product> putCoffee(@PathVariable Long id, @RequestBody Product product){
        return (!productRepository.existsById(id))
                ? new ResponseEntity<>(productRepository.save(product),
                    HttpStatus.CREATED)
                : new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
