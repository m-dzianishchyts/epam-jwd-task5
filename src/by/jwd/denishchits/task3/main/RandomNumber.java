package by.jwd.denishchits.task3.main;

import by.jwd.denishchits.service.InvalidArrayException;
import by.jwd.denishchits.service.Printer;
import by.jwd.denishchits.service.PrinterArgumentException;
import by.jwd.denishchits.service.arguments.CommandLineArgumentException;
import by.jwd.denishchits.service.arguments.CommandLineArgumentUtils;
import by.jwd.denishchits.service.arguments.OutputMode;
import by.jwd.denishchits.service.IllegalValueException;
import by.jwd.denishchits.task3.util.PrimitiveArrayUtils;
import by.jwd.denishchits.task3.util.RandomUtil;

import java.util.List;
import java.util.OptionalInt;

public class RandomNumber {

    private static final OutputMode DEFAULT_OUTPUT_MODE = OutputMode.SINGLE_LINE;
    private static final double MIN_VALUE = 0;
    private static final double MAX_VALUE = 100;

    public static void main(String[] args) {
        try {
            var optionalOutputMode = CommandLineArgumentUtils.extractOutputMode(args);
            OutputMode outputMode = optionalOutputMode.orElse(DEFAULT_OUTPUT_MODE);
            OptionalInt optionalInteger = CommandLineArgumentUtils.extractInteger(args);
            if (optionalInteger.isEmpty()) {
                throw new CommandLineArgumentException("No random numbers amount provided.");
            }
            int amount = optionalInteger.getAsInt();
            double[] randomNumbers = RandomUtil.generateRandomNumbers(amount, MIN_VALUE, MAX_VALUE);
            List<Double> randomNumbersList = PrimitiveArrayUtils.toList(randomNumbers);
            Printer.printSeveral(randomNumbersList, outputMode);
        } catch (CommandLineArgumentException | IllegalValueException | PrinterArgumentException
                | InvalidArrayException e) {
            Printer.printErrorMessage(e.getMessage());
        }
    }
}
