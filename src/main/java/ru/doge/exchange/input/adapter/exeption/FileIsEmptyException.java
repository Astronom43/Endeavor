package ru.doge.exchange.input.adapter.exeption;

public final class FileIsEmptyException extends RuntimeException {

    public FileIsEmptyException(String message) {
        super(message);
    }
}
