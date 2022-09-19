package com.github.lsj8367.item12;

public class ToStringAfter {

    private final String name;
    private final String email;

    public ToStringAfter(final String name, final String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "ToStringAfter{" +
            "name='" + name + '\'' +
            ", email='" + email + '\'' +
            '}';
    }

}
