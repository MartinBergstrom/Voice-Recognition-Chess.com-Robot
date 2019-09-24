package rest.model.customValidation;

public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
