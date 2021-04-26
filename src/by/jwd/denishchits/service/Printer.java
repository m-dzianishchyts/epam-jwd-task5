package by.jwd.denishchits.service;

import by.jwd.denishchits.service.arguments.OutputMode;

import java.util.List;
import java.util.Objects;

public final class Printer {

    private Printer() {
    }

    public static void printErrorMessage(String message) {
        Objects.requireNonNull(message, "Message cannot be null");
        System.err.println("Error: " + message);
    }

    public static void printSeveral(List<?> list, OutputMode outputMode) throws InvalidArgumentException {
        switch (outputMode) {
            case MULTILINE:
                printSeveralMultiLine(list);
                break;
            case SINGLE_LINE:
                printSeveralSingleLine(list);
                break;
            default:
                throw new PrinterArgumentException("Unknown output mode.");
        }
    }

    private static void printSeveralMultiLine(List<?> list) throws InvalidArgumentException {
        if (list == null) {
            throw new InvalidArgumentException("List of objects cannot be null.");
        }
        for (Object object : list) {
            System.out.println(object);
        }
    }

    private static void printSeveralSingleLine(List<?> list) throws InvalidArgumentException {
        if (list == null) {
            throw new InvalidArgumentException("List of objects cannot be null.");
        }
        for (Object object : list) {
            System.out.print(object + " ");
        }
        System.out.println();
    }
}
