package ru.doge.mapstruct.dto;

import lombok.Getter;

@Getter
public class AnimalTransfer {

    private final Integer id;
    private final Integer age;
    private final String name;

    public AnimalTransfer(Integer id,
                          Integer age,
                          String name) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
