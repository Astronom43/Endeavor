package ru.doge.injections;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DogeInjectionTest {

    private List<String> mockedCat;

    @BeforeEach
    void setUp() {
        mockedCat = List.of("Cat", "Say", "Woof");
    }

    @Test
    void whenInjectCollectionThenCorrect() throws NoSuchFieldException, IllegalAccessException {
        DogeInjection.Doge before = new DogeInjection.Doge();
        DogeInjection.injectCollection(before);
        Assertions.assertThat(before.getList()).containsExactlyInAnyOrder(mockedCat.toArray(String[]::new));
    }

    @Test
    void whenInjectValueThenCorrect() throws NoSuchFieldException, IllegalAccessException {
        DogeInjection.Doge before = new DogeInjection.Doge();
        DogeInjection.injectValue(before);
        Assertions.assertThat(before.getList()).containsExactlyInAnyOrder(mockedCat.toArray(String[]::new));
    }
}
