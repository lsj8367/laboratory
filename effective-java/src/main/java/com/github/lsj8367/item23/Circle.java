package com.github.lsj8367.item23;

public class Circle extends RefactorFigure {

    private final double radius;

    public Circle(final double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

}
