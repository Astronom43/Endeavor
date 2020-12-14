package ru.doge.exchange.input;

import java.io.IOException;

public interface FileReader {

    byte[] read(String path) throws IOException;
}
