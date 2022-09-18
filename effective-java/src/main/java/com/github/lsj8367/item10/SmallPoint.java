package com.github.lsj8367.item10;

public class SmallPoint extends Point {

    private final int z;

    public SmallPoint(final int x, final int y, final int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Point)) {
            return false;
        }

        //o가 일반이라면 Color는 무시한채 비교한다.
        // 추이성 위반가능 코드
        if (!(o instanceof SmallPoint)) {
            return o.equals(this);
        }

        return super.equals(o) && ((SmallPoint) o).z == this.z;
    }

}
