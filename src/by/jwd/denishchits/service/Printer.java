package by.jwd.denishchits.service;

import java.util.Objects;

public class Printer {

    private Printer() {
    }

    public static void printErrorMessage(String message) {
        Objects.requireNonNull(message, "Message cannot be null");
        System.err.println("Error: " + message);
    }
}
