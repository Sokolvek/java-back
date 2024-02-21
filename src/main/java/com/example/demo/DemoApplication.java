package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

class Product{
	private final String id;
	private String name;

	public Product(String id, String name){
		this.id = id;
		this.name = name;
	}

	public Product(String name){
		this(UUID.randomUUID().toString(), name);
	}

	public String getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

}