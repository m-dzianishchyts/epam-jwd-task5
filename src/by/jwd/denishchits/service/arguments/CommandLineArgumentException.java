package by.jwd.denishchits.service.arguments;

public class CommandLineArgumentException extends Exception {
    public CommandLineArgumentException() {
    }

    public CommandLineArgumentException(String message) {
        super(message);
    }

    public CommandLineArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandLineArgumentException(Throwable cause) {
        super(cause);
    }
}
