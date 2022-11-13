package com.github.lsj8367.item44.lambda;

public class Ramen {

    public void cook(RamenPowder ramenPowder) {
        water();
        ramenPowder.inputPowder();
        inputNoodle();
        boil();
    }

    private void water() {
        System.out.println("물을 넣음");
    }

    private void inputNoodle() {
        System.out.println("면을 넣음");
    }

    private void boil() {
        System.out.println("잘 끓인다.");
    }
}
