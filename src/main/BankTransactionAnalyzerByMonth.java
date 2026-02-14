package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankTransactionAnalyzerByMonth {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {

        final Path path = Paths.get(RESOURCES + args[0]);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;
        Month month = Month.JANUARY;

        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (final String line : lines) {
            final String[] columns = line.split(",");
            final double ammount = Double.parseDouble(columns[1]);
            total += ammount;
        }

        System.out.println("O Total de Todas as transações é: " + total);
        total = 0d;

        for (final String line : lines) {
            final String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            if (date.getMonth() == month) {
                final double ammount = Double.parseDouble(columns[1]);
                total += ammount;
            }
        }

        System.out.println("O Total de Todas as transações de " + month + " É: " + total);
    }
}

