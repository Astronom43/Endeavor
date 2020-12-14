package ru.doge.mapstruct.data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class Veterinary {

    private Integer id;
    private String name;
    private List<Animal> animals;
    private List<Employee> personal;
}
