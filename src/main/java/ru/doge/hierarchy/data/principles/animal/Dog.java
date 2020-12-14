package ru.doge.hierarchy.data.principles.animal;

import java.util.Collection;

public class Dog extends Animal implements Training {

    private Collection<String> commands;

    public Dog(double weight, int age) {
        super(weight, age);
    }

    public Dog(double weight, int age, Collection<String> commands) {
        super(weight, age);
        this.commands = commands;
    }

    @Override
    protected String say() {
        return "Bark!";
    }

    @Override
    public void learnNewCommand(String command) {
        this.commands.add(command);
    }

    @Override
    public String executeCommand(String command) {
        return this.commands.stream().filter(next -> next.equalsIgnoreCase(command)).findFirst().orElseThrow(UnsupportedOperationException::new);
    }
}
