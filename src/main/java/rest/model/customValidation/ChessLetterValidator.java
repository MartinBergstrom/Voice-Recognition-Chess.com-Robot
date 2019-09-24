package rest.model.customValidation;

import main.Validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ChessLetterValidator implements Validator<Character> {
    private final static Set<Character> VALID_CHARS;
    static {
        VALID_CHARS = new HashSet<>(Arrays.asList('a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G'));
    }

    @Override
    public void validate(Character input) {
        if (!VALID_CHARS.contains(input)) {
            throw new ValidationException("Chess letter: " + input + " is invalid. Valid letters are from A to G (case insensitive)");
        }
    }

}
