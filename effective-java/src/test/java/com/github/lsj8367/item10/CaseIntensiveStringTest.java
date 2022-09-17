package com.github.lsj8367.item10;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;

class CaseIntensiveStringTest {

    private final CaseIntensiveString cis = new CaseIntensiveString("Example");

    @Test
    void equalsTrue() {
        final boolean actual = cis.equals("example");
//        assertThat(actual).isTrue();
        assertThat(actual).isFalse(); // 재구현된 equals에 의해 false를 도출한다.
    }

    @Test
    void equalsFalse() {
        final String s = "example";
        assertThat(s.equals(cis)).isFalse();
    }

    @Test
    void listContains() {
        final String s = "example";

        final List<CaseIntensiveString> list = List.of(cis);
        final boolean contains = list.contains(s);
        System.out.println(contains);
    }

}
