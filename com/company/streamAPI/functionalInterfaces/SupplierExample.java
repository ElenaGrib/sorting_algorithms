package com.company.streamAPI.functionalInterfaces;

import javax.security.sasl.SaslClient;
import java.util.Scanner;
import java.util.function.Supplier;

public class SupplierExample {
    //не принимает ничего, но возвращает объект типа Т
    public static void main(String[] args) {
        Supplier<User> userFactory = () -> {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя:");
            String name = in.nextLine();
            return new User(name);
        };

        User user1 = userFactory.get();
        User user2 = userFactory.get();

        System.out.println("Имя user1: " + user1.getName());
        System.out.println("Имя user2: " + user2.getName());
    }

    static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}

