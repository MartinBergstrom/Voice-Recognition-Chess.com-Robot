package rest.model.validation;

public class ChessDigitValidator implements Validator<Integer> {

    @Override
    public void validate(Integer input) {
        System.out.println("validating chess digit: " + input);
        throw new RuntimeException("hehe");
    }
}
