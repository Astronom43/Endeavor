package ru.doge.date;

import ru.doge.exchange.input.DataInput;
import ru.doge.exchange.input.adapter.impl.FileToData;
import ru.doge.exchange.input.impl.FileStreamReader;
import ru.doge.exchange.output.DataOutput;
import ru.doge.exchange.output.adapter.DataToFile;
import ru.doge.exchange.output.impl.OutputStreamWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class DateConverter {

    /*
    "dd-MM-yyyy H:mm:ss"
    "yyyy-MM-dd H:mm:ss"
    "D:\\Work\\datas\\start_date_fix_format.txt"
    "D:\\Work\\datas\\start_date_fix_format_result.txt"
    */

    public static void main(String[] args) throws IOException {
        String sourcePattern = args[0];
        String outputPattern = args[1];

        String sourcePath = args[2];
        String outputPath = args[3];

        DataInput input = new FileToData(new FileStreamReader(), sourcePath);
        DataOutput output = new DataToFile(new OutputStreamWriter(outputPath));

        List<String> sources = input.read();
        List<LocalDate> parsed = convertFrom(sourcePattern, sources);
        List<String> converted = convertTo(outputPattern, parsed);

        for (String next : converted) {
            output.write(next);
            output.write("\n");
        }
    }

    private static List<LocalDate> convertFrom(String pattern, Collection<String> source) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
        return source.stream().map(unparsed -> LocalDate.parse(unparsed, formatter)).collect(Collectors.toList());
    }

    private static List<String> convertTo(String pattern, Collection<LocalDate> source) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
        return source.stream()
                .map(LocalDate::atStartOfDay)
                .map(date -> date.format(formatter))
                .collect(Collectors.toList());
    }
}
