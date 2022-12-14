package com.github.lsj8367.item2;

import java.util.Objects;

public class NyPizza extends Pizza {

    public enum Size {SMALL, MEDIUM, LARGE}
    private final Size size;

    NyPizza(final Builder builder) {
        super(builder);
        this.size = builder.size;
    }


    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(final Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        Pizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }

    }
}

