package project.repositories.exception;

public class UndefinedEntityException extends RuntimeException {
    public UndefinedEntityException() {
        super("Undefined entity");
    }
}
