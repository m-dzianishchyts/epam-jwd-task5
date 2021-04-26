package by.jwd.denishchits.task5.main;

import by.jwd.denishchits.service.InvalidArgumentException;
import by.jwd.denishchits.service.Printer;
import by.jwd.denishchits.service.arguments.CommandLineArgumentException;
import by.jwd.denishchits.service.arguments.CommandLineArgumentUtils;
import by.jwd.denishchits.service.arguments.OutputMode;
import by.jwd.denishchits.service.arguments.ReduceMode;
import by.jwd.denishchits.task5.util.ReduceUtils;

import java.util.List;
import java.util.Objects;

public final class TotalReduce {

    private static final ReduceMode DEFAULT_REDUCE_MODE = ReduceMode.SUM;

    private TotalReduce() {
    }

    public static void main(String[] args) {
        try {
            ReduceMode reduceMode = defineReduceMode(args);
            List<Integer> integers = CommandLineArgumentUtils.extractIntegers(args);
            int reducedValue = ReduceUtils.reduceInts(integers, reduceMode);
            Printer.printSeveral(integers, OutputMode.SINGLE_LINE);
            System.out.println(capitalize(reduceMode.name()) + ": " + reducedValue + ".");
        } catch (CommandLineArgumentException | InvalidArgumentException e) {
            Printer.printErrorMessage(e.getMessage());
        }
    }

    private static ReduceMode defineReduceMode(String[] args) {
        var optionalReduceMode = CommandLineArgumentUtils.extractReduceMode(args);
        ReduceMode reduceMode = optionalReduceMode.orElse(DEFAULT_REDUCE_MODE);
        return reduceMode;
    }

    private static String capitalize(String string) {
        Objects.requireNonNull(string);
        switch (string.length()) {
            case 0:
                return string;
            case 1:
                return string.substring(0, 1).toUpperCase();
            default:
                return Character.toUpperCase(string.charAt(0)) + string.substring(1).toLowerCase();
        }
    }
}
