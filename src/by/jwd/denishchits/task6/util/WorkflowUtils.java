package by.jwd.denishchits.task6.util;

import by.jwd.denishchits.service.InvalidArgumentException;

import java.util.Calendar;

public final class WorkflowUtils {

    private WorkflowUtils() {
    }

    public static Calendar calculateDeadline(int daysToComplete) throws InvalidArgumentException {
        if (daysToComplete < 0) {
            throw new InvalidArgumentException("Days amount cannot be negative.");
        }
        Calendar deadline = Calendar.getInstance();
        deadline.add(Calendar.DATE, daysToComplete);
        return deadline;
    }
}
