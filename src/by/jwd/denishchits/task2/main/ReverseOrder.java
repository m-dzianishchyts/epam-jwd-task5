package by.jwd.denishchits.task2.main;

import by.jwd.denishchits.service.InvalidArgumentException;
import by.jwd.denishchits.service.Printer;
import by.jwd.denishchits.service.PrinterArgumentException;
import by.jwd.denishchits.service.arguments.OutputMode;
import by.jwd.denishchits.task2.util.ArrayUtils;

import java.util.List;

public final class ReverseOrder {

    private ReverseOrder() {
    }

    public static void main(String[] args) {
        try {
            List<String> argumentsReversedOrder = ArrayUtils.reverseArrayAsList(args);
            Printer.printSeveral(argumentsReversedOrder, OutputMode.SINGLE_LINE);
        } catch (PrinterArgumentException e) {
            Printer.printErrorMessage(e.getMessage());
        } catch (InvalidArgumentException e) {
            Printer.printErrorMessage("Arguments list does not exist.");
        }
    }
}
