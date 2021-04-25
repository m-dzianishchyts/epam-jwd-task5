package by.jwd.denishchits.task6.main;

import by.jwd.denishchits.service.IllegalValueException;
import by.jwd.denishchits.service.Printer;
import by.jwd.denishchits.service.arguments.CommandLineArgumentException;
import by.jwd.denishchits.service.arguments.CommandLineArgumentUtils;
import by.jwd.denishchits.task6.util.WorkflowUtils;

import java.util.Calendar;
import java.util.Optional;
import java.util.OptionalInt;

public class Deadline {

    public static void main(String[] args) {
        try {
            String developerLastName = defineDeveloperLastName(args);
            int daysAmountRequested = defineDaysAmountRequested(args);
            Calendar deadline = WorkflowUtils.calculateDeadline(daysAmountRequested);
            System.out.printf("%s requested %d days to complete the task.\nThe work should be completed before %s.\n",
                              developerLastName, daysAmountRequested, deadline.getTime());
        } catch (IllegalValueException | CommandLineArgumentException e) {
            Printer.printErrorMessage(e.getMessage());
        }
    }

    private static int defineDaysAmountRequested(String[] args)
            throws IllegalValueException, CommandLineArgumentException {
        OptionalInt optionalDaysAmountRequested = CommandLineArgumentUtils.extractInteger(args, 1);
        if (optionalDaysAmountRequested.isEmpty()) {
            throw new CommandLineArgumentException("Requested days amount was not provided.");
        }
        int daysAmountRequested = optionalDaysAmountRequested.getAsInt();
        if (daysAmountRequested < 0) {
            throw new CommandLineArgumentException("Days amount cannot be negative.");
        }
        return daysAmountRequested;
    }

    private static String defineDeveloperLastName(String[] args)
            throws IllegalValueException, CommandLineArgumentException {
        Optional<String> optionalDeveloperLastName = CommandLineArgumentUtils.extractLastName(args, 0);
        if (optionalDeveloperLastName.isEmpty()) {
            throw new CommandLineArgumentException("Developer last name was not provided.");
        }
        String developerLastName = optionalDeveloperLastName.get();
        return developerLastName;
    }
}
