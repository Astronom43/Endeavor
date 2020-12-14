package ru.doge.mapstruct.data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
public class Employee {

    private Integer id;
    private String name;
    private List<Animal> patients;
}
