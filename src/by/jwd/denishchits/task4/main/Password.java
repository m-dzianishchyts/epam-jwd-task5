package by.jwd.denishchits.task4.main;

import by.jwd.denishchits.service.Printer;
import by.jwd.denishchits.service.arguments.CommandLineArgumentUtils;

import java.util.Optional;
import java.util.stream.Stream;

public class Password {

    private static final String SUPER_PASSWORD = "qwerty123";

    public static void main(String[] args) {
        Optional<String> optionalPassword = CommandLineArgumentUtils.extractPassword(args);
        if (optionalPassword.isPresent()) {
            String password = optionalPassword.get();
            boolean isCorrectPassword = password.equals(SUPER_PASSWORD);
            if (isCorrectPassword) {
                System.out.println("You would better change your password, but welcome!");
            } else {
                System.out.println("Incorrect password. Bye.");
            }
        } else {
            Printer.printErrorMessage("No password provided.");
        }
    }
}
