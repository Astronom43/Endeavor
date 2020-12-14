package ru.doge.exchange.output.adapter;

import ru.doge.exchange.output.DataOutput;
import ru.doge.exchange.output.FileWriter;

import java.io.IOException;

public class DataToFile implements DataOutput {

    private final FileWriter writer;

    public DataToFile(FileWriter writer) {
        this.writer = writer;
    }

    @Override
    public void write(String target) throws IOException {
        writer.write(target.getBytes());
    }
}
