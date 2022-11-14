package com.github.lsj8367.item45;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Foo> list = new ArrayList<>();

        final int sum = list.stream()
            .filter(x -> x.getGrade() == 3)
            .mapToInt(x -> x.getPoint())
            .sum();

        ;
    }

}
