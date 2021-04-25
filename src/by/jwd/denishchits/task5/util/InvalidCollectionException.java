package by.jwd.denishchits.task5.util;

public class InvalidCollectionException extends Exception {
    public InvalidCollectionException() {
    }

    public InvalidCollectionException(String message) {
        super(message);
    }

    public InvalidCollectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCollectionException(Throwable cause) {
        super(cause);
    }
}
