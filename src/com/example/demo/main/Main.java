package com.example.demo.main;

import com.example.demo.bean.Animal;
import com.example.demo.utils.SerializeUtils;

public class Main {

    public static void main(String[] args) throws Exception {
        Animal animal = new Animal("dog", "red");

        // 序列化为byte数组
        byte[] bytes = SerializeUtils.serialization(animal);

        // byte数组反序列化为对象
        Animal result = SerializeUtils.deSerialization(bytes,Animal.class);

        System.out.println("原始bytes反序列化:" + result.toString());
    }
}
