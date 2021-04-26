package by.jwd.denishchits.task3.util;

import by.jwd.denishchits.service.InvalidArgumentException;

import java.util.ArrayList;
import java.util.List;

public final class PrimitiveArrayUtils {

    private PrimitiveArrayUtils() {
    }

    public static List<Double> toList(double[] array) throws InvalidArgumentException {
        if (array == null) {
            throw new InvalidArgumentException("Array cannot be null.");
        }
        List<Double> list = new ArrayList<>(array.length);
        for (double value : array) {
            list.add(value);
        }
        return list;
    }
}
