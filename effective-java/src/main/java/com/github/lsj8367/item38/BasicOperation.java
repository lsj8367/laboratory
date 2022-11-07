package com.github.lsj8367.item38;

public enum BasicOperation implements Operation {
    PLUS("+") {
        @Override
        public double apply(final double x, final double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(final double x, final double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        public double apply(final double x, final double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(final double x, final double y) {
            return x / y;
        }
    };

    private final String symbol;

    BasicOperation(final String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
