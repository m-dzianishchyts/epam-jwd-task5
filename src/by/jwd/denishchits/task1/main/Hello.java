package by.jwd.denishchits.task1.main;

import by.jwd.denishchits.service.Printer;
import by.jwd.denishchits.task1.cmd.CommandLineArgumentUtils;
import by.jwd.denishchits.task1.util.HelloUtils;
import by.jwd.denishchits.task1.util.InvalidUsernameException;

import java.util.Optional;

public class Hello {

    public static void main(String[] args) {
        Optional<String> optionalUsername = CommandLineArgumentUtils.extractUsername(args);
        if (optionalUsername.isPresent()) {
            String username = optionalUsername.get();
            try {
                String greetingMessage = HelloUtils.prepareGreetingMessageFor(username);
                System.out.println(greetingMessage);
            } catch (InvalidUsernameException e) {
                Printer.printErrorMessage("Username is empty or blank.");
            }
        } else {
            Printer.printErrorMessage("Username was not provided.");
        }
    }
}
