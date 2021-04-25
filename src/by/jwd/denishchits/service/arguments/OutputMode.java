package by.jwd.denishchits.service.arguments;

public enum OutputMode {
    MULTILINE("--multiline"),
    SINGLE_LINE("--single-line");

    private final String argument;

    OutputMode(String argument) {
        this.argument = argument;
    }

    public String getArgument() {
        return argument;
    }
}
