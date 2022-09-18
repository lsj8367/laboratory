package com.github.lsj8367.item10;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import java.awt.Color;
import java.util.Set;
import org.junit.jupiter.api.Test;

class PointTest {

    private static final Set<Point> unitCircle = Set.of(
        new Point(1, 0), new Point(0, 1),
        new Point(-1, 0), new Point(0, -1)
    );
    ColorPoint cp = new ColorPoint(1, 2, Color.RED);
    Point p = new Point(1, 2);
    ColorPoint cp2 = new ColorPoint(1, 2, Color.BLUE);
    SmallPoint sp = new SmallPoint(1, 2, 3);

    public static boolean onUnitCircle(Point p) {
        return unitCircle.contains(p);
    }

//    @Test
//    void basicEqualTest() {
//        assertThat(p).isEqualTo(cp);
//        assertThat(cp).isNotEqualTo(p);
//    }

//    @Test
//    void 추이성_위반_테스트() {
//        assertThat(cp.equals(p)).isTrue();
//        assertThat(p.equals(cp2)).isFalse();
//        assertThat(cp.equals(cp2)).isFalse();
//    }

    @Test
    void stackOverFlowTest() {
        assertThatExceptionOfType(StackOverflowError.class)
            .isThrownBy(() -> sp.equals(cp));
    }

//    @Test
//    void test() {
//        final boolean b1 = onUnitCircle(new Point(1, 0));
//        final boolean b = onUnitCircle(new ColorPoint(1, 0, Color.BLUE));
//        System.out.println(b1 + " " + b);
//    }

}
