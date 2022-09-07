package com.github.lsj8367.item2;

import com.github.lsj8367.item2.NyPizza.Size;
import com.github.lsj8367.item2.Pizza.Topping;

public class Main {

    public static void main(String[] args) {
        Pizza newYork = new NyPizza.Builder(Size.SMALL)
            .addTopping(Topping.SAUSAGE)
            .addTopping(Topping.ONION)
            .build();

        Pizza calzone = new Calzone.Builder()
            .addTopping(Topping.PEPPER)
            .sauceInside()
            .build();
    }

}
