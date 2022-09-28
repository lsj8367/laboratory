package com.github.lsj8367.item17;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void Should_plusMoney_When_givenValue() {
        //given
        final Money money = new Money(new BigDecimal(1_000));

        //when
        final Money newMoney = money.plus(new BigDecimal(1_000));

        //then
        assertThat(newMoney).isEqualTo(new Money(new BigDecimal(2_000)));
    }

    @Test
    void Should_throwIllegalStateException_When_givenValueMoreThanOldValue() {
        //given
        Money money = new Money(new BigDecimal(1_000));

        //then
        assertThatIllegalStateException()
            .isThrownBy(() -> money.minus(new BigDecimal(2_000)))
            .withMessage("빼고자 하는 금액이 더 많습니다.");
    }


}
