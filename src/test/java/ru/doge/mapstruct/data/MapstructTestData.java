package ru.doge.mapstruct.data;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.junit.jupiter.params.provider.Arguments;
import ru.doge.last.ListNode;
import ru.doge.mapstruct.dto.AnimalTransfer;
import ru.doge.mapstruct.dto.EmployeeTransfer;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MapstructTestData {

    public static Stream<Arguments> convertAnimalData() {
        Animal actual = new Animal();
        actual.setId(1);
        actual.setAge(2);
        actual.setName("Dog");

        AnimalTransfer expected = new AnimalTransfer(1, 2, "Dog");

        Animal actualSecond = new Animal();
        actualSecond.setId(2);
        actualSecond.setAge(5);
        actualSecond.setName("Cat");

        AnimalTransfer expectedSecond = new AnimalTransfer(2, 5, "Cat");

        return Stream.of(
                Arguments.of(
                        actual, expected
                ),
                Arguments.of(
                        actualSecond, expectedSecond
                )
        );
    }

    public static Stream<Arguments> convertPersonalData() {
        Animal actual = new Animal();
        actual.setId(1);
        actual.setAge(2);
        actual.setName("Dog");

        AnimalTransfer expected = new AnimalTransfer(1, 2, "Dog");

        Animal actualSecond = new Animal();
        actualSecond.setId(2);
        actualSecond.setAge(5);
        actualSecond.setName("Cat");

        AnimalTransfer expectedSecond = new AnimalTransfer(2, 5, "Cat");

        Employee actualEmployee = new Employee();
        actualEmployee.setId(1);
        actualEmployee.setName("John");
        actualEmployee.setPatients(List.of(actual, actualSecond));

        EmployeeTransfer expectedEmployee = new EmployeeTransfer(1, "John", List.of(expected, expectedSecond));

        return Stream.of(
                Arguments.of(
                        actualEmployee, expectedEmployee
                )
        );
    }
}
