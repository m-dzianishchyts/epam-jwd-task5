package by.jwd.denishchits.task2.util;

import by.jwd.denishchits.service.InvalidArgumentException;

import java.util.ArrayList;
import java.util.List;

public final class ArrayUtils {

    private ArrayUtils() {
    }

    public static <T> List<T> reverseArrayAsList(T[] array) throws InvalidArgumentException {
        if (array == null) {
            throw new InvalidArgumentException("Array cannot be null.");
        }
        List<T> reversedArrayAsList = new ArrayList<>();
        for (int i = array.length - 1; i >= 0; i--) {
            reversedArrayAsList.add(array[i]);
        }
        return reversedArrayAsList;
    }
}
