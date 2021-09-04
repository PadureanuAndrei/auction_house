package project.commands.exceptions;

public class IllegalCommandTypeException extends RuntimeException {
    public IllegalCommandTypeException(String commandType) {
        super("Command '" + commandType + "' is not allowed");
    }
}
