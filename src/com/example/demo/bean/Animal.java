package com.example.demo.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Animal implements Serializable {

    private String name;
    private String color;

    public Animal() {
    }

    public Animal(String name, String color) {
        this.name = name;
        this.color = color;
    }
}
