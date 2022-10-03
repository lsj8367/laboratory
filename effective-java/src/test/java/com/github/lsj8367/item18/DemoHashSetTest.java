package com.github.lsj8367.item18;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DemoHashSetTest {

    @Test
    void test() {
        DemoHashSet<Integer> set = new DemoHashSet<>();
        set.addAll(List.of(1, 2, 3));
        Assertions.assertThat(set.getAddCount()).isEqualTo(6);
    }

}
