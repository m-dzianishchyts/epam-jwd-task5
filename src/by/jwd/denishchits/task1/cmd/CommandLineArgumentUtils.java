package by.jwd.denishchits.task1.cmd;

import java.util.Optional;

public class CommandLineArgumentUtils {

    private CommandLineArgumentUtils() {
    }

    public static Optional<String> extractUsername(String[] args) {
        if (args.length == 0) {
            return Optional.empty();
        }
        int userNamePosition = args.length - 1;
        String userName = args[userNamePosition];
        return Optional.of(userName);
    }
}
