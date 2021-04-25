package by.jwd.denishchits.task6.util;

import by.jwd.denishchits.service.IllegalValueException;

import java.util.Calendar;

public final class WorkflowUtils {

    private WorkflowUtils() {
    }

    public static Calendar calculateDeadline(int daysToComplete) throws IllegalValueException {
        if (daysToComplete < 0) {
            throw new IllegalValueException("Days amount cannot be negative.");
        }
        Calendar deadline = Calendar.getInstance();
        deadline.add(Calendar.DATE, daysToComplete);
        return deadline;
    }
}
