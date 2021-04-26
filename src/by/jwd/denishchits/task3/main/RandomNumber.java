package by.jwd.denishchits.task3.main;

import by.jwd.denishchits.service.InvalidArgumentException;
import by.jwd.denishchits.service.Printer;
import by.jwd.denishchits.service.arguments.CommandLineArgumentException;
import by.jwd.denishchits.service.arguments.CommandLineArgumentUtils;
import by.jwd.denishchits.service.arguments.OutputMode;
import by.jwd.denishchits.task3.util.PrimitiveArrayUtils;
import by.jwd.denishchits.task3.util.RandomUtil;

import java.util.List;
import java.util.OptionalInt;

public final class RandomNumber {

    private static final OutputMode DEFAULT_OUTPUT_MODE = OutputMode.SINGLE_LINE;
    private static final double MAX_VALUE = 100;
    private static final double MIN_VALUE = 0;

    private RandomNumber() {
    }

    public static void main(String[] args) {
        try {
            OutputMode outputMode = defineOutputMode(args);
            int randomNumbersAmount = defineRandomNumbersAmount(args);
            double[] randomNumbers = RandomUtil.generateRandomNumbers(randomNumbersAmount, MIN_VALUE, MAX_VALUE);
            List<Double> randomNumbersList = PrimitiveArrayUtils.toList(randomNumbers);
            Printer.printSeveral(randomNumbersList, outputMode);
        } catch (CommandLineArgumentException | InvalidArgumentException e) {
            Printer.printErrorMessage(e.getMessage());
        }
    }

    private static int defineRandomNumbersAmount(String[] args) throws CommandLineArgumentException {
        OptionalInt optionalInteger = CommandLineArgumentUtils.extractInteger(args);
        if (optionalInteger.isEmpty()) {
            throw new CommandLineArgumentException("No random numbers amount provided.");
        }
        int amount = optionalInteger.getAsInt();
        return amount;
    }

    private static OutputMode defineOutputMode(String[] args) {
        var optionalOutputMode = CommandLineArgumentUtils.extractOutputMode(args);
        OutputMode outputMode = optionalOutputMode.orElse(DEFAULT_OUTPUT_MODE);
        return outputMode;
    }
}
