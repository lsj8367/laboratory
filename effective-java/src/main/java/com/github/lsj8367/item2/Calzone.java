package com.github.lsj8367.item2;

public class Calzone extends Pizza {

    private final boolean sauceInside;

    Calzone(final Builder builder) {
        super(builder);
        this.sauceInside = builder.sauceInside;
    }

    public static class Builder extends Pizza.Builder<Builder> {

        private boolean sauceInside = false;

        public Builder sauceInside() {
            this.sauceInside = true;
            return this;
        }

        @Override
        Pizza build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }

    }

}
