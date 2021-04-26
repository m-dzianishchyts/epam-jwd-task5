package by.jwd.denishchits.task3.util;

import by.jwd.denishchits.service.InvalidArgumentException;

public final class RandomUtil {

    private RandomUtil() {
    }

    public static double[] generateRandomNumbers(int amount, double minValue, double maxValue)
            throws InvalidArgumentException {
        if (amount < 0) {
            throw new InvalidArgumentException("Amount cannot be negative.");
        }
        if (!Double.isFinite(minValue)) {
            throw new InvalidArgumentException("Min value is not finite.");
        }
        if (!Double.isFinite(maxValue)) {
            throw new InvalidArgumentException("Max value is not finite.");
        }
        double[] randomNumbers = new double[amount];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = randomDouble(minValue, maxValue);
        }
        return randomNumbers;
    }

    public static double randomDouble(double minValue, double maxValue) {
        return Math.random() * (maxValue - minValue) + minValue;
    }
}
