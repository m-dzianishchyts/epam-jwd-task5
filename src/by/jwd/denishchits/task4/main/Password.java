package by.jwd.denishchits.task4.main;

import by.jwd.denishchits.service.InvalidArgumentException;
import by.jwd.denishchits.service.Printer;
import by.jwd.denishchits.service.arguments.CommandLineArgumentException;
import by.jwd.denishchits.service.arguments.CommandLineArgumentUtils;

import java.util.Optional;

public final class Password {

    private static final String SUPER_PASSWORD = "qwerty123";

    private Password() {
    }

    public static void main(String[] args) {
        try {
            String password = definePassword(args);
            boolean isCorrectPassword = password.equals(SUPER_PASSWORD);
            if (isCorrectPassword) {
                System.out.println("You would better change your password, but welcome!");
            } else {
                System.out.println("Incorrect password. Bye.");
            }
        } catch (InvalidArgumentException | CommandLineArgumentException e) {
            Printer.printErrorMessage(e.getMessage());
        }
    }

    private static String definePassword(String[] args) throws InvalidArgumentException, CommandLineArgumentException {
        Optional<String> optionalPassword = CommandLineArgumentUtils.extractPassword(args, 0);
        if (optionalPassword.isPresent()) {
            return optionalPassword.get();
        } else {
            throw new CommandLineArgumentException("No password provided.");
        }
    }
}
