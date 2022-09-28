package com.github.lsj8367.item17;

import java.math.BigDecimal;

public record MoneyForJdk17(BigDecimal amount) {

    public MoneyForJdk17 plus(final BigDecimal amount) {
        return new MoneyForJdk17(this.amount.add(amount));
    }

    public MoneyForJdk17 minus(final BigDecimal amount) {
        validSubtract(amount);

        return new MoneyForJdk17(this.amount.subtract(amount));
    }

    private void validSubtract(final BigDecimal amount) {
        if (this.amount.compareTo(amount) < 0) {
            throw new IllegalStateException("빼고자 하는 금액이 더 많습니다.");
        }
    }

}
