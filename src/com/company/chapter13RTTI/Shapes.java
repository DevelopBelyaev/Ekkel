package com.company.chapter13RTTI;

import java.util.Arrays;
import java.util.List;

/**
 * Created by oleg on 21.03.16.
 */
abstract class Shape{
    void draw(){
        System.out.println(this + ".draw");
    }

    abstract public String toString();
}


class Circle extends Shape {

    @Override
    public String toString() {
        return "Circle";
    }
}

class Rectangle extends Shape {

    @Override
    public String toString() {
        return "rectangle";
    }
}

class Triangle extends Shape {

    @Override
    public String toString() {
        return "triangle";
    }
}

public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(new Circle(), new Rectangle(), new Triangle());
        shapes.forEach(Shape::draw);
        System.out.println("test");
    }
}
