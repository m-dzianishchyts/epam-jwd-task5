package by.jwd.denishchits.task3.util;

import by.jwd.denishchits.service.InvalidArrayException;

import java.util.ArrayList;
import java.util.List;

public class PrimitiveArrayUtils {

    public static List<Double> toList(double[] array) throws InvalidArrayException {
        if (array == null) {
            throw new InvalidArrayException("Array cannot be null.");
        }
        List<Double> list = new ArrayList<>(array.length);
        for (double value : array) {
            list.add(value);
        }
        return list;
    }
}
