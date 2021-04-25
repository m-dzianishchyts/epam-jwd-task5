package by.jwd.denishchits.task1.util;

public class InvalidUsernameException extends Exception {
    public InvalidUsernameException() {
    }

    public InvalidUsernameException(String message) {
        super(message);
    }

    public InvalidUsernameException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUsernameException(Throwable cause) {
        super(cause);
    }
}
