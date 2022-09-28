package com.github.lsj8367.item17;

import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class MoneyForJdk17Test {

    @Test
    void Should_plusMoney_When_givenValue() {
        //given
        final MoneyForJdk17 money = new MoneyForJdk17(new BigDecimal(1_000));

        //when
        final MoneyForJdk17 newMoney = money.plus(new BigDecimal(1_000));

        //then
        assertThat(newMoney).isEqualTo(new MoneyForJdk17(new BigDecimal(2_000)));
    }

}
