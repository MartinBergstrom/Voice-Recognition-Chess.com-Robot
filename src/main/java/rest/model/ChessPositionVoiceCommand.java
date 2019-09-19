package rest.model;

import rest.model.validation.CustomAnnotations.ChessDigit;
import rest.model.validation.CustomAnnotations.ChessLetter;

/**
 * Represents command from frontend, e.g. "A7" or "B4"
 */
public class ChessPositionVoiceCommand {

    @ChessLetter
    private final char letter;

    @ChessDigit
    private final int digit;

    public ChessPositionVoiceCommand(char letter, int digit) {
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
