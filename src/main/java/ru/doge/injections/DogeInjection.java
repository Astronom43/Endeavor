package ru.doge.injections;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DogeInjection {

    private DogeInjection() {
    }

    public static void injectCollection(Doge doge) throws IllegalAccessException, NoSuchFieldException {
        Field list = doge.getClass().getDeclaredField("list");
        list.setAccessible(true);

        LinkedList<String> intruder = new LinkedList<>();
        intruder.add("Cat");
        intruder.add("Say");
        intruder.add("Woof");

        list.set(doge, Collections.unmodifiableList(intruder));
        list.setAccessible(false);
    }

    @SuppressWarnings("unchecked")
    public static void injectValue(Doge doge) throws IllegalAccessException, NoSuchFieldException {
        Field list = doge.getClass().getDeclaredField("list");
        list.setAccessible(true);

        Class<?> unmodifiableCollection = list.get(doge).getClass();
        Field outerList = unmodifiableCollection.getDeclaredField("list");
        outerList.setAccessible(true);
        Object innerList = outerList.get(list.get(doge));
        if (innerList instanceof LinkedList) {
            LinkedList<String> modifiableInner = (LinkedList<String>) innerList;
            modifiableInner.set(0, "Cat");
        }
        outerList.setAccessible(false);


        list.setAccessible(false);
    }

    public static class Doge {

        private final List<String> list;

        public Doge() {
            list = Collections.unmodifiableList(getLinkedCollection());
        }

        private List<String> getLinkedCollection() {
            List<String> result = new LinkedList<>();
            result.add("Doge");
            result.add("Say");
            result.add("Woof");
            return result;
        }

        public List<String> getList() {
            return list;
        }

        @Override
        public String toString() {
            return String.join(" ", getList());
        }
    }
}
