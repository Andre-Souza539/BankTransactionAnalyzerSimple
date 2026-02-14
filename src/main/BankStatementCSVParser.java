package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private BankTransaction parserFromCSV(final String line) {
        final String[] columns = line.split(",");
        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double ammount = Double.parseDouble(columns[1]);
        final String description = columns[2];
        return new BankTransaction(date, ammount, description);
    }

    public List<BankTransaction> parseListFromCSV(final List<String> lines) {
        final List<BankTransaction> bankTransaction = new ArrayList<>();
        for (final String line : lines) {
            bankTransaction.add(parserFromCSV(line));
        }
        return bankTransaction;
    }


}
