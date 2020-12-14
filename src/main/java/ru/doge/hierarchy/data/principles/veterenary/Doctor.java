package ru.doge.hierarchy.data.principles.veterenary;

import lombok.Getter;

@Getter
abstract class Doctor extends Employee {

    private boolean isLicenseExpired;

    public Doctor(String name, int age, double experience) {
        super(name, age, experience);
    }
}
