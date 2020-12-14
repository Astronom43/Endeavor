package ru.doge.hierarchy.data.principles.veterenary;

import java.util.Collection;

public class Clinic<T> implements Medicine<T> {

    private Collection<Doctor> personal;

    public Clinic(Collection<Doctor> personal) {
        this.personal = personal;
    }

    @Override
    public void cure(T patient) {

    }
}