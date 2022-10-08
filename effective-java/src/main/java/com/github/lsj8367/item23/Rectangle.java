package com.github.lsj8367.item23;

public class Rectangle extends RefactorFigure {

    private final double length;
    private final double width;

    public Rectangle(final double length, final double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }

}
