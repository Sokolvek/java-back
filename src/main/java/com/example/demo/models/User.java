package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    public String name;

    @Column(name = "password")
    private String password;

    @Column(name = "balance")
    private int balance;

    public String getName() {return name;}

    public String getPassword() {return password;}


}
