package ru.doge.hierarchy.data.principles.veterenary;

import ru.doge.hierarchy.data.principles.animal.Dog;

public class DogDoctor extends Doctor {

    public DogDoctor(String name, int age, double experience) {
        super(name, age, experience);
    }

    @Override
    public void work() {

    }
}
