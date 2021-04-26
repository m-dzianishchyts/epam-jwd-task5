package by.jwd.denishchits.service.arguments;

import by.jwd.denishchits.service.InvalidArgumentException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public final class CommandLineArgumentUtils {

    private CommandLineArgumentUtils() {
    }

    public static OptionalInt extractInteger(String[] arguments, int position)
            throws InvalidArgumentException, CommandLineArgumentException {
        checkPosition(position);
        if (arguments == null || arguments.length < position + 1) {
            return OptionalInt.empty();
        }
        String argument = arguments[position];
        try {
            int number = Integer.parseInt(argument);
            return OptionalInt.of(number);
        } catch (NumberFormatException e) {
            throw new CommandLineArgumentException("Argument is not an integer.", e);
        }
    }

    public static OptionalInt extractInteger(String[] arguments) throws CommandLineArgumentException {
        if (arguments == null) {
            return OptionalInt.empty();
        }
        for (String argument : arguments) {
            if (!isOptionArgument(argument)) {
                try {
                    int number = Integer.parseInt(argument);
                    return OptionalInt.of(number);
                } catch (NumberFormatException e) {
                    throw new CommandLineArgumentException("Argument is not an integer.", e);
                }
            }
        }
        return OptionalInt.empty();
    }

    public static List<Integer> extractIntegers(String[] arguments) throws CommandLineArgumentException {
        if (arguments == null || arguments.length == 0) {
            return Collections.emptyList();
        }
        int integerPosition = 0;
        while (integerPosition < arguments.length) {
            String argument = arguments[integerPosition];
            if (!isOptionArgument(argument)) {
                break;
            }
            integerPosition++;
        }
        List<Integer> integers = new ArrayList<>();
        while (integerPosition < arguments.length) {
            String argument = arguments[integerPosition];
            try {
                Integer integer = Integer.parseInt(argument);
                integers.add(integer);
            } catch (NumberFormatException e) {
                throw new CommandLineArgumentException("Argument is not an integer.", e);
            }
            integerPosition++;
        }
        return integers;
    }

    public static Optional<String> extractLastName(String[] arguments, int position) throws InvalidArgumentException {
        checkPosition(position);
        if (arguments == null || arguments.length < position + 1) {
            return Optional.empty();
        }
        Predicate<String> lastNamePredicate = Pattern.compile("^[a-z ,.'-]+$", Pattern.CASE_INSENSITIVE).asPredicate();
        String argument = arguments[position];
        if (lastNamePredicate.test(argument)) {
            return Optional.of(argument);
        } else {
            return Optional.empty();
        }
    }

    public static Optional<OutputMode> extractOutputMode(String[] arguments) {
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

    public static Optional<String> extractPassword(String[] arguments, int position) throws InvalidArgumentException {
        checkPosition(position);
        if (arguments == null || arguments.length < position + 1) {
            return Optional.empty();
        }
        return Optional.of(arguments[position]);
    }

    public static Optional<ReduceMode> extractReduceMode(String[] arguments) {
        if (arguments.length == 0) {
            return Optional.empty();
        }
        for (String argument : arguments) {
            if (isOptionArgument(argument)) {
                var optionalReduceMode = findReduceModeByArgument(argument);
                if (optionalReduceMode.isPresent()) {
                    ReduceMode reduceMode = optionalReduceMode.get();
                    return Optional.of(reduceMode);
                }
            } else {
                break;
            }
        }
        return Optional.empty();
    }

    public static Optional<Calendar> extractDate(String[] arguments, SimpleDateFormat dateFormat, int position)
            throws InvalidArgumentException, CommandLineArgumentException {
        if (dateFormat == null) {
            throw new InvalidArgumentException("Format cannot be null.");
        }
        checkPosition(position);
        if (arguments == null || arguments.length < position + 1) {
            return Optional.empty();
        }
        String argument = arguments[position];
        try {
            Date date = dateFormat.parse(argument);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return Optional.of(calendar);
        } catch (ParseException e) {
            throw new CommandLineArgumentException("Invalid date.", e);
        }
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

    private static void checkPosition(int position) throws InvalidArgumentException {
        if (position < 0) {
            throw new InvalidArgumentException("Position in arguments cannot be negative.");
        }
    }

    private static Optional<OutputMode> findOutputModeByArgument(String argument) {
        for (OutputMode outputMode : OutputMode.values()) {
            if (outputMode.getArgument().equals(argument)) {
                return Optional.of(outputMode);
            }
        }
        return Optional.empty();
    }

    private static Optional<ReduceMode> findReduceModeByArgument(String argument) {
        for (ReduceMode reduceMode : ReduceMode.values()) {
            if (reduceMode.getArgument().equals(argument)) {
                return Optional.of(reduceMode);
            }
        }
        return Optional.empty();
    }

    private static boolean isOptionArgument(String argument) {
        return argument.startsWith("--");
    }
}
