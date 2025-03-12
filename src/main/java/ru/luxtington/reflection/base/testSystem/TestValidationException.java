package ru.luxtington.reflection.base.testSystem;

public class TestValidationException extends RuntimeException{
    public TestValidationException() {
        super();
    }

    public TestValidationException(String message) {
        super(message);
    }

    public TestValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestValidationException(Throwable cause) {
        super(cause);
    }

    protected TestValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
