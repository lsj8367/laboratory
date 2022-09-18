package com.github.lsj8367.item10;

import java.util.Objects;

public class Point {

    private final int x;
    private final int y;

    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        // 리스코프 치환 원칙 위배
//        if (o == null || o.getClass() != getClass()) {
//            return false;
//        }

        Point p = (Point) o;

        return p.x == this.x && p.y == this.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
