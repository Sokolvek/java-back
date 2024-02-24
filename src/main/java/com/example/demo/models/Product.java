package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "products")
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

//    public Product(String name){
//
//        this.name = name;
//
//    }

//    public void setId(String id){
//        this.id = id;
//    }
//    public String getId(){
//        return id;
//    }

//    public String getName(){
//        return name;
//    }

//    public void setName(String name){
//        this.name = name;
//    }

}