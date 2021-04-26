package by.jwd.denishchits.task1.util;

import by.jwd.denishchits.service.InvalidArgumentException;

public class InvalidUsernameException extends InvalidArgumentException {

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
