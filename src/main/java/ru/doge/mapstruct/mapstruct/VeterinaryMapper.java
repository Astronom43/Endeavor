package ru.doge.mapstruct.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.doge.mapstruct.data.Veterinary;
import ru.doge.mapstruct.dto.VeterinaryTransfer;

import java.util.Collection;
import java.util.List;
import java.util.Set;

//@Mapper(componentModel = "spring")
@Mapper
public interface VeterinaryMapper {

    default VeterinaryTransfer sourceToTransfer(Veterinary source) {
        return new VeterinaryTransfer(
                source.getId(),
                source.getName(),
                Mappers.getMapper(AnimalMapper.class).sourceToTransfer(source.getAnimals()),
                Mappers.getMapper(EmployeeMapper.class).sourceToTransfer(source.getPersonal())
        );
    }

    List<VeterinaryTransfer> sourceToTransfer(Collection<Veterinary> source);
}
