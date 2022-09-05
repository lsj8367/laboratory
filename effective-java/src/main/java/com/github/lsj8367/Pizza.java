package com.github.lsj8367;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {

    public enum Topping {
        HAM, MUSHROOM, ONION, PEPPER, SAUSAGE
    }
    private final Set<Topping> toppingSet;

    abstract static class Builder<T extends Builder<T>> {
        private final EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(final Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        protected abstract T self();

    }

    Pizza(final Builder<?> builder) {
        this.toppingSet = builder.toppings.clone();
    }

}
