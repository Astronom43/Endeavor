package ru.doge.exchange.output;

import java.io.IOException;

public interface FileWriter {

    void write(byte[] target) throws IOException;
}
