package by.jwd.denishchits.task3.util;

public class IllegalValueException extends Exception {
    public IllegalValueException() {
    }

    public IllegalValueException(String message) {
        super(message);
    }

    public IllegalValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalValueException(Throwable cause) {
        super(cause);
    }
}