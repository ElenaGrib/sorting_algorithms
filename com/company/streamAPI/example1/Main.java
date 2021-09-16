package com.company.streamAPI.example1;

public class Main {
    ShapeService rectangleService = (a, b) -> 2 * (a + b);
    ShapeService squareService = (a, b) -> b * a;
}
