package by.jwd.denishchits.task3.util;

public class RandomUtil {

    public static double[] generateRandomNumbers(int amount, double minValue, double maxValue)
            throws IllegalValueException {
        if (amount < 0) {
            throw new IllegalValueException("Amount cannot be negative.");
        }
        if (!Double.isFinite(minValue)) {
            throw new IllegalValueException("Min value is not finite.");
        }
        if (!Double.isFinite(maxValue)) {
            throw new IllegalValueException("Max value is not finite.");
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
