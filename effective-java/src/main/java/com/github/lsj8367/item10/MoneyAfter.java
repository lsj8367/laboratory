package com.github.lsj8367.item10;

import java.math.BigDecimal;
import java.util.Objects;

public class MoneyAfter {

    private final BigDecimal value;

    public MoneyAfter(final long value) {
        this.value = BigDecimal.valueOf(value);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final MoneyAfter that = (MoneyAfter) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
