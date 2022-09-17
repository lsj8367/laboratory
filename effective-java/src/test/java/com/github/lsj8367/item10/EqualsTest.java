package com.github.lsj8367.item10;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class EqualsTest {

    @Test
    void test() {
        final List<Integer> list1 = List.of(1, 2, 3);
        final List<Integer> list2 = List.of(1, 2, 3);

        System.out.println(list1.equals(list2));

        assertThat(list1).isEqualTo(list2);
    }

}
