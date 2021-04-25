package by.jwd.denishchits.task2.main;

import by.jwd.denishchits.service.Printer;
import by.jwd.denishchits.task2.util.ArrayUtils;
import by.jwd.denishchits.service.InvalidArrayException;

import java.util.List;

public class ReverseOrder {

    public static void main(String[] args) {
        try {
            List<String> argumentsReversedOrder = ArrayUtils.reverseArrayAsList(args);
            for (String argument : argumentsReversedOrder) {
                System.out.print(argument + " ");
            }
        } catch (InvalidArrayException e) {
            Printer.printErrorMessage("Arguments list does not exist.");
        }
    }
}
