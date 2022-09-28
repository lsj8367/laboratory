package com.github.lsj8367.item17;

import java.math.BigDecimal;
import java.util.Objects;

public final class Money {

    private final BigDecimal amount;

    public Money(final BigDecimal amount) {
        this.amount = amount;
    }

    // 동사대신 전치사를 쓴 이유는 값을 변경하지 않는다는 사실을 강조하기 위함
    public Money plus(final BigDecimal amount) {
        return new Money(this.amount.add(amount));
    }

    public Money minus(final BigDecimal amount) {
        validSubtract(amount);

        return new Money(this.amount.subtract(amount));
    }

    private void validSubtract(final BigDecimal amount) {
        if (this.amount.compareTo(amount) < 0) {
            throw new IllegalStateException("빼고자 하는 금액이 더 많습니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

}
