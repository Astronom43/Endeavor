package ru.doge.hierarchy.data.principles.animal;

import lombok.Getter;

@Getter
abstract class Animal {

    private final double weight;
    private final int age;

    public Animal(double weight, int age) {
        this.weight = weight;
        this.age = age;
    }

    protected String say() {
        throw new UnsupportedOperationException();
    }
}
