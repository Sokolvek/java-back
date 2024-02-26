package com.example.demo.repos;

import com.example.demo.models.Product;
import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query(value = "select * from products where name = ?1", nativeQuery = true)
    List<Product> findByName(String name);
}
