package com.company.classloaders.classloader1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoaderDemo extends ClassLoader {
    @Override
    public Class<?> findClass(String name) {
        byte[] bytes = loadClassData(name);
        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] loadClassData(String className) {
        //read class
        InputStream is = getClass().getClassLoader().getResourceAsStream(className.replace(".", "/") + ".class");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        //write into byte array
        int len = 0;
        try {
            while (true) {
                assert is != null;
                if ((len = is.read()) == -1) break;
                byteArrayOutputStream.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //convert into byte array
        return byteArrayOutputStream.toByteArray();
    }
}
