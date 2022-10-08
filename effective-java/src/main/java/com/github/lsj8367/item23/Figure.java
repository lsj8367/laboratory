package com.github.lsj8367.item23;

public class Figure {

    final Shape shape;
    // 다음 필드는 모양이 사각형일 때만 사용
    double length;
    double width;
    // 다음 필드는 모양이 원일때만 사용
    double radius;

    // 원용 생성자
    public Figure(final double radius) {
        this.shape = Shape.CIRCLE;
        this.radius = radius;
    }

    public Figure(final double length, final double width) {
        this.shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    // 사각형용 생성자

    double area() {
        if (shape.equals(Shape.RECTANGLE)) {
            return length * width;
        }

        if (shape.equals(Shape.CIRCLE)) {
            return Math.PI * (radius * radius);
        }

        throw new AssertionError(shape);
    }

    enum Shape {RECTANGLE, CIRCLE}

}
