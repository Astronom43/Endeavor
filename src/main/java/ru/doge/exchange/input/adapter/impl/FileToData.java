package ru.doge.exchange.input.adapter.impl;


import ru.doge.exchange.input.FileReader;
import ru.doge.exchange.input.DataInput;
import ru.doge.exchange.input.adapter.validator.InputFileValidator;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileToData implements DataInput {
    private static final String DEFAULT_ELEMENT_DELIMITER = "(\\n)";

    private final FileReader reader;
    private final String pathToFile;
    private final String elementDelimiter;

    public FileToData(FileReader reader, String pathToFile) {
        this.reader = reader;
        this.pathToFile = pathToFile;
        this.elementDelimiter = DEFAULT_ELEMENT_DELIMITER;
    }

    public FileToData(FileReader reader, String pathToFile, String elementDelimiter) {
        this.reader = reader;
        this.pathToFile = pathToFile;
        this.elementDelimiter = elementDelimiter;
    }

    @Override
    public String getSource() {
        return pathToFile;
    }

    @Override
    public List<String> read() throws IOException {
        String source = getSourceFromFile();
        InputFileValidator.checkDelimiterIsCorrect(source, elementDelimiter);

        return Arrays.stream(source.split(elementDelimiter)).map(String::strip).collect(Collectors.toList());
    }

    private String getSourceFromFile() throws IOException {
        String source = new String(reader.read(pathToFile), Charset.defaultCharset());
        InputFileValidator.checkFileIsEmpty(source);
        return source;
    }
}
