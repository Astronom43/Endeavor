package ru.doge.exchange.output;

import java.io.IOException;

public interface DataOutput {

    void write(String target) throws IOException;
}
