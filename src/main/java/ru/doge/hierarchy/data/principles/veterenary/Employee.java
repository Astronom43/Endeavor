package ru.doge.hierarchy.data.principles.veterenary;

import lombok.Getter;
import lombok.Setter;

@Getter
abstract class Employee implements Job {

    private final String name;
    private final int age;
    private final double experience;

    @Setter
    private boolean onDuty;

    public Employee(String name, int age, double experience) {
        this.name = name;
        this.age = age;
        this.experience = experience;
    }
}
