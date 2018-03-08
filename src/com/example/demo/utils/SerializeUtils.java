package com.example.demo.utils;

import java.io.*;

public class SerializeUtils {

    /**
     * 将对象序列化为byte数组
     *
     * @param object
     * @return
     */
    public static byte[] serialization(Object object) {


        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

            // 将对象写入输出流
            objectOutputStream.writeObject(object);
            return byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("序列化异常");
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将byte数组反序列化为对象
     *
     * @param bytes
     * @return
     */
    public static <T>T deSerialization(byte[] bytes,Class<T> t) {
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);

            // 从输入流读取对象
            return (T) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("反序列化异常");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("反序列化类型转化异常");
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
