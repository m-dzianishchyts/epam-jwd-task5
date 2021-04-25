package by.jwd.denishchits.service.arguments;

import java.util.function.IntBinaryOperator;

public enum ReduceMode {
    SUM("--sum", Integer::sum, 0),
    PRODUCT("--product", (a, b) -> a * b, 1);

    private final String argument;
    private final IntBinaryOperator binaryOperator;
    private final int identity;

    ReduceMode(String argument, IntBinaryOperator binaryOperator, int identity) {
        this.argument = argument;
        this.binaryOperator = binaryOperator;
        this.identity = identity;
    }

    public IntBinaryOperator getBinaryOperator() {
        return binaryOperator;
    }

    public int getIdentity() {
        return identity;
    }

    public String getArgument() {
        return argument;
    }
}
