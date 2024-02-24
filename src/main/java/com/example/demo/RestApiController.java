package com.example.demo;

import com.example.demo.models.Product;
import com.example.demo.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class RestApiController {
    @Autowired
    ProductRepo productRepository;
//    public RestApiController(ProductRepo productRepository){
//        this.productRepository = productRepository;
//        this.productRepository.saveAll(List.of(
//              new Product("Café Cereza"),
//              new Product("Café Ganador"),
//              new Product("Café Lareño"),
//              new Product("Café Três Pontas")
//        ));
//    }



    @GetMapping
    Iterable<Product> getProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Product> getProduct(@PathVariable Long id){
        return productRepository.findById(id);
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
