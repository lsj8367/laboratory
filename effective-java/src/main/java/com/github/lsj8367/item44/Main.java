package com.github.lsj8367.item44;

import com.github.lsj8367.item44.lambda.Ramen;
import com.github.lsj8367.item44.template.RamenTemplate;
import com.github.lsj8367.item44.template.SinRamen;

public class Main {

    public static void main(String[] args) {
        Ramen ramen = new Ramen();
        ramen.cook(() -> System.out.println("신라면 스프를 넣는다."));

        System.out.println("=====================");

        RamenTemplate ramen1 = new SinRamen();
        ramen1.cook();
    }

}
