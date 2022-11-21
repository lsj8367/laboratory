package com.github.lsj8367.item52;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;

class BurgerTest {

    @Test
    void test() {
        final List<Burger> burgers = List.of(new Burger(), new ChickenBurger(), new Whopper());

        assertThat(burgers.get(0)).isExactlyInstanceOf(Burger.class);
        assertThat(burgers.get(1)).isExactlyInstanceOf(ChickenBurger.class);
        assertThat(burgers.get(2)).isExactlyInstanceOf(Whopper.class);

        for (Burger burger : burgers) {
            burger.print();
        }
    }

}
