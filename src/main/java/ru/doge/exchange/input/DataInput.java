package ru.doge.exchange.input;

import java.io.IOException;
import java.util.List;

public interface DataInput {

    String getSource();

    List<String> read() throws IOException;
}
