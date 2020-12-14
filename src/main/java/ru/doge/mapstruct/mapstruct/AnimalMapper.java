package ru.doge.mapstruct.mapstruct;

import org.mapstruct.Mapper;
import ru.doge.mapstruct.data.Animal;
import ru.doge.mapstruct.dto.AnimalTransfer;

import java.util.Collection;
import java.util.List;
import java.util.Set;

//@Mapper(componentModel = "spring")
@Mapper
public interface AnimalMapper {

    default AnimalTransfer sourceToTransfer(Animal source) {
        return new AnimalTransfer(
                source.getId(),
                source.getAge(),
                source.getName()
        );
    }

    List<AnimalTransfer> sourceToTransfer(Collection<Animal> source);
}
