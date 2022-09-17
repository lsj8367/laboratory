package com.github.lsj8367.item10;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class CaseIntensiveStringTest {

    @Test
    void equalsTrue() {
        final CaseIntensiveString cis = new CaseIntensiveString("Example");
        final boolean actual = cis.equals("example");
        assertThat(actual).isTrue();
    }

    @Test
    void equalsFalse() {
        final String s = "example";
        final CaseIntensiveString cis = new CaseIntensiveString("Example");
        assertThat(s.equals(cis)).isFalse();
    }

}
