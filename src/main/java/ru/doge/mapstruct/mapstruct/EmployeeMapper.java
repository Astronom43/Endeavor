package ru.doge.mapstruct.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.doge.mapstruct.data.Employee;
import ru.doge.mapstruct.dto.EmployeeTransfer;

import java.util.Collection;
import java.util.List;
import java.util.Set;

//@Mapper(componentModel = "spring")
@Mapper
public interface EmployeeMapper {

    default EmployeeTransfer sourceToTransfer(Employee source) {
        return new EmployeeTransfer(
                source.getId(),
                source.getName(),
                Mappers.getMapper(AnimalMapper.class).sourceToTransfer(source.getPatients())
        );
    }

    List<EmployeeTransfer> sourceToTransfer(Collection<Employee> source);
}
