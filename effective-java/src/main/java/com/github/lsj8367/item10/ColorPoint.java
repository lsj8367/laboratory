package com.github.lsj8367.item10;

import java.awt.Color;

public class ColorPoint extends Point {

    private Color color;

    public ColorPoint(final int x, final int y, final Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Point)) {
            return false;
        }

        //o가 일반이라면 Color는 무시한채 비교한다.
        // 추이성 위반가능 코드
        if (!(o instanceof ColorPoint)) {
            return o.equals(this);
        }

        return super.equals(o) && ((ColorPoint) o).color == this.color;
    }

}
