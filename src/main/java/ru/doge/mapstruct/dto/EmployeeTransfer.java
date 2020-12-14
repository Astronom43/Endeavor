package ru.doge.mapstruct.dto;

import lombok.Getter;
import ru.doge.mapstruct.data.Animal;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Getter
public class EmployeeTransfer {

    private final Integer id;
    private final String name;
    private final List<AnimalTransfer> animals;

    public EmployeeTransfer(Integer id,
                            String name,
                            List<AnimalTransfer> animals) {
        this.id = id;
        this.name = name;
        this.animals = Optional.ofNullable(animals).map(Collections::unmodifiableList).orElse(Collections.emptyList());
    }
}
