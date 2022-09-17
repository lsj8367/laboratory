package com.github.lsj8367.item10;

import java.util.Objects;

public class CaseIntensiveString {

    private final String s;

    public CaseIntensiveString(final String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(final Object o) {
        if (o instanceof CaseIntensiveString c) {
            return s.equalsIgnoreCase(c.s);
        }

        if (o instanceof String str) {
            return s.equalsIgnoreCase(str);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(s);
    }

}
