package com.company.classloaders.classloader3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class<?> cl = defineClass(name, bytes, 0, bytes.length);
        return cl;
    }
}
