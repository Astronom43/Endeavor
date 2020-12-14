package ru.doge.mapstruct;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.doge.mapstruct.data.Animal;
import ru.doge.mapstruct.data.Employee;
import ru.doge.mapstruct.dto.AnimalTransfer;
import ru.doge.mapstruct.dto.EmployeeTransfer;
import ru.doge.mapstruct.mapstruct.AnimalMapper;
import ru.doge.mapstruct.mapstruct.AnimalMapperImpl;
import ru.doge.mapstruct.mapstruct.EmployeeMapper;
import ru.doge.mapstruct.mapstruct.EmployeeMapperImpl;

class MapstructTest {

    @MethodSource("ru.doge.mapstruct.data.MapstructTestData#convertAnimalData")
    @ParameterizedTest
    void shouldConvertAnimal(Animal actual, AnimalTransfer expected) {
        AnimalMapper mapper = new AnimalMapperImpl();

        AnimalTransfer result = mapper.sourceToTransfer(actual);

        Assertions.assertThat(result.getId()).isEqualTo(expected.getId());
        Assertions.assertThat(result.getName()).isEqualTo(expected.getName());
        Assertions.assertThat(result.getAge()).isEqualTo(expected.getAge());
    }

    @MethodSource("ru.doge.mapstruct.data.MapstructTestData#convertPersonalData")
    @ParameterizedTest
    void shouldConvertPersonal(Employee actual, EmployeeTransfer expected) {
        EmployeeMapper mapper = new EmployeeMapperImpl();

        EmployeeTransfer result = mapper.sourceToTransfer(actual);

        Assertions.assertThat(result.getId()).isEqualTo(expected.getId());
        Assertions.assertThat(result.getName()).isEqualTo(expected.getName());

        Assertions.assertThat(result.getAnimals().size()).isEqualTo(expected.getAnimals().size());

        AnimalTransfer[] resultAnimals = result.getAnimals().toArray(AnimalTransfer[]::new);
        AnimalTransfer[] expectedAnimals = expected.getAnimals().toArray(AnimalTransfer[]::new);
        for (int i = 0 ; i < resultAnimals.length; i++) {
            Assertions.assertThat(resultAnimals[i].getId()).isEqualTo(expectedAnimals[i].getId());
            Assertions.assertThat(resultAnimals[i].getAge()).isEqualTo(expectedAnimals[i].getAge());
            Assertions.assertThat(resultAnimals[i].getName()).isEqualTo(expectedAnimals[i].getName());
        }
    }
}
