package com.github.lsj8367.item10;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;

class EqualsTest {

    @Test
    void Should_equalTrue_When_linkedListIsOverride() {
        final List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        final List<Integer> list2 = new LinkedList<>();
        list2.add(1);

        System.out.println(list1.equals(list2));

        assertThat(list1).isEqualTo(list2);
    }

}
