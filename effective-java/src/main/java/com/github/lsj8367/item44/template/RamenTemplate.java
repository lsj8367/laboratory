package com.github.lsj8367.item44.template;

public abstract class RamenTemplate {

    public void cook() {
        water();
        inputPowder();
        inputNoodle();
        boil();
    }

    abstract void inputPowder();

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
