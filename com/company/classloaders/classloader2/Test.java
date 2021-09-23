package com.company.classloaders.classloader2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] argv) throws Exception {
        ClassLoader loader;
        for (; ; ) {
            loader = new DynamicClassOverloader(new String[]{"."});
            // текущий каталог "." будет единственным каталогом поиска
            Class clazz = Class.forName("com.company.classloaders.classloader2.TestModule", true, loader);
            Object object = clazz.newInstance();
            System.out.println(object);
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        }
    }
}
