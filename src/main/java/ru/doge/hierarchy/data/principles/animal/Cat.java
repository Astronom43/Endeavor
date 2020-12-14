package ru.doge.hierarchy.data.principles.animal;

public class Cat extends Animal {

    public Cat(double weight, int age) {
        super(weight, age);
    }

    @Override
    protected String say() {
        return "Meow!";
    }
}
