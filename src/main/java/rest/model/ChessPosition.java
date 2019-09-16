package rest.model;

public class ChessPosition {
    private final char letter;
    private final int digit;

    public ChessPosition(char letter, int digit) {
        this.letter = letter;
        this.digit = digit;
    }

    public char getLetter() {
        return letter;
    }

    public int getDigit() {
        return digit;
    }
}
