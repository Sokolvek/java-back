package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class RestApiController {
    private List<Product> products = new ArrayList<>();

    public RestApiController(){
        products.addAll(List.of(
                new Product("Café Cereza"),
                new Product("Café Ganador"),
                new Product("Café Lareño"),
                new Product("Café Três Pontas")

        ));

    }

    @GetMapping("/products")
    Iterable<Product> getProducts(){
        return products;
    }

    @PostMapping("/products")
    Product postProduct(@RequestBody Product product){
        products.add(product);
        return product;
    }


//    @PutMapping("/{id}")
//    Product putProduct(@PathVariable String id, @RequestBody Product product) {
//        int productIndex = -1;
//        for (Product c: products) {
//            if (c.getId().equals(id)) {
//                productIndex = products.indexOf(c);
//                products.set(productIndex, product);
//            }
//        }
//        return (productIndex == -1) ? postProduct(product) : product;
//    }
//
//    @DeleteMapping("/{id}")
//    void deleteCoffee(@PathVariable String id) {
//        products.removeIf(c -> c.getId().equals(id));
//    }
}
