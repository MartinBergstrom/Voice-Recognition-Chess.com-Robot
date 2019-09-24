package rest.model.customValidation;

import main.Validator;

public class ChessDigitValidator implements Validator<Integer> {

    @Override
    public void validate(Integer input) {
        if (input < 1 || input > 8) {
            throw new ValidationException("Chess digit: " + input + " is invalid. Must be in the interval [1, 8]");
        }
    }

}
