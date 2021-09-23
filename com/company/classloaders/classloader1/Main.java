package com.company.classloaders.classloader1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        CustomClassLoaderDemo loader = new CustomClassLoaderDemo();
        Class<?> c = loader.findClass("com.company.classloaders.classloader1.Test");
        Object ob = c.getDeclaredConstructor().newInstance();
        Method md = c.getMethod("show");
        md.invoke(ob);
    }
}
