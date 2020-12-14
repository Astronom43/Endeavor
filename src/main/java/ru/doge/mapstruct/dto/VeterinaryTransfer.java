package ru.doge.mapstruct.dto;

import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Getter
public class VeterinaryTransfer {

    private final Integer id;
    private final String name;
    private final List<AnimalTransfer> animals;
    private final List<EmployeeTransfer> personal;

    public VeterinaryTransfer(Integer id,
                              String name,
                              List<AnimalTransfer> animals,
                              List<EmployeeTransfer> personal) {
        this.id = id;
        this.name = name;
        this.animals = Optional.ofNullable(animals).map(Collections::unmodifiableList).orElse(Collections.emptyList());
        this.personal = Optional.ofNullable(personal).map(Collections::unmodifiableList).orElse(Collections.emptyList());
    }
}
