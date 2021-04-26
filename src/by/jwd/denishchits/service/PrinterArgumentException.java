package by.jwd.denishchits.service;

public class PrinterArgumentException extends InvalidArgumentException {

    public PrinterArgumentException() {
    }

    public PrinterArgumentException(String message) {
        super(message);
    }

    public PrinterArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrinterArgumentException(Throwable cause) {
        super(cause);
    }
}
