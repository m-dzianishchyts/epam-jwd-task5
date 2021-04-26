package by.jwd.denishchits.task5.util;

import by.jwd.denishchits.service.InvalidArgumentException;
import by.jwd.denishchits.service.arguments.ReduceMode;

import java.util.List;

public final class ReduceUtils {

    private ReduceUtils() {
    }

    public static int reduceInts(List<Integer> integers, ReduceMode reduceMode) throws InvalidArgumentException {
        if (integers == null || integers.isEmpty()) {
            throw new InvalidArgumentException("List of numbers cannot be null or empty.");
        }
        int accumulator = reduceMode.getIdentity();
        for (Integer integer : integers) {
            accumulator = reduceMode.getBinaryOperator().applyAsInt(accumulator, integer);
        }
        return accumulator;
    }
}
