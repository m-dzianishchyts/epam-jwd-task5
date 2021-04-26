package by.jwd.denishchits.task1.main;

import by.jwd.denishchits.service.Printer;
import by.jwd.denishchits.service.arguments.CommandLineArgumentException;
import by.jwd.denishchits.service.arguments.CommandLineArgumentUtils;
import by.jwd.denishchits.task1.util.HelloUtils;
import by.jwd.denishchits.task1.util.InvalidUsernameException;

import java.util.Optional;

public final class Hello {

    private Hello() {
    }

    public static void main(String[] args) {
        try {
            String username = defineUserName(args);
            String greetingMessage = HelloUtils.prepareGreetingMessageFor(username);
            System.out.println(greetingMessage);
        } catch (CommandLineArgumentException e) {
            Printer.printErrorMessage(e.getMessage());
        } catch (InvalidUsernameException e) {
            Printer.printErrorMessage("Username is empty or blank.");
        }
    }

    private static String defineUserName(String[] args) throws CommandLineArgumentException {
        Optional<String> optionalUsername = CommandLineArgumentUtils.extractUsername(args);
        if (optionalUsername.isPresent()) {
            return optionalUsername.get();
        } else {
            throw new CommandLineArgumentException("Username was not provided.");
        }
    }
}
