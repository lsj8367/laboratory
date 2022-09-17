package com.github.lsj8367.item10;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void notEqualTest() {
        final List<MoneyBefore> money = List.of(new MoneyBefore(1000));
        assertThat(money).isNotEmpty()
            .doesNotContain(new MoneyBefore(1000));
    }

    @Test
    void equalTest() {
        final List<MoneyAfter> money = List.of(new MoneyAfter(1000));
        assertThat(money).contains(new MoneyAfter(1000));
    }

}
