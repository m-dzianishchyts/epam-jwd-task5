package by.jwd.denishchits.task1.util;

public final class HelloUtils {

    private HelloUtils() {
    }

    public static String prepareGreetingMessageFor(String username) throws InvalidUsernameException {
        if (username == null || username.isBlank()) {
            throw new InvalidUsernameException("Username cannot be null or blank.");
        }
        String greetingMessage = "Hello, " + username + "!";
        return greetingMessage;
    }
}
