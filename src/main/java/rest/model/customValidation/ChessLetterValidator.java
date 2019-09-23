package rest.model.customValidation;

import main.Validator;

public class ChessLetterValidator implements Validator<Character> {

    @Override
    public void validate(Character input) {
        System.out.println("validating chess letter: " + input);
    }
}
