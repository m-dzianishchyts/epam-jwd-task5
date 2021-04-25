package by.jwd.denishchits.service.arguments;

import java.util.Optional;

public class CommandLineArgumentUtils {

    private CommandLineArgumentUtils() {
    }

    public static Optional<String> extractUsername(String[] arguments) {
        if (arguments == null) {
            return Optional.empty();
        }
        for (String argument : arguments) {
            if (!isOptionArgument(argument)) {
                return Optional.of(argument);
            }
        }
        return Optional.empty();
    }

    public static Optional<Integer> extractInteger(String[] arguments) throws CommandLineArgumentException {
        if (arguments == null) {
            return Optional.empty();
        }
        for (String argument : arguments) {
            if (!isOptionArgument(argument)) {
                try {
                    Integer number = Integer.parseInt(argument);
                    return Optional.of(number);
                } catch (NumberFormatException e) {
                    throw new CommandLineArgumentException("Argument is not a number.", e);
                }
            }
        }
        return Optional.empty();
    }

    public static Optional<OutputMode> extractOutputMode(String[] arguments) throws CommandLineArgumentException {
        if (arguments.length == 0) {
            return Optional.empty();
        }
        for (String argument : arguments) {
            if (isOptionArgument(argument)) {
                var optionalOutputMode = findOutputModeByArgument(argument);
                if (optionalOutputMode.isPresent()) {
                    OutputMode outputMode = optionalOutputMode.get();
                    return Optional.of(outputMode);
                }
            } else {
                break;
            }
        }
        return Optional.empty();
    }

    private static boolean isOptionArgument(String argument) {
        return argument.startsWith("--");
    }

    private static Optional<OutputMode> findOutputModeByArgument(String argument) {
        for (OutputMode outputMode : OutputMode.values()) {
            if (outputMode.getArgument().equals(argument)) {
                return Optional.of(outputMode);
            }
        }
        return Optional.empty();
    }
}
