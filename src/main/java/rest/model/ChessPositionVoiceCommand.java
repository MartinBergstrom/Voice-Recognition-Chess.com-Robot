package rest.model;

import com.google.gson.annotations.SerializedName;
import rest.model.customValidation.ChessDigit;
import rest.model.customValidation.ChessLetter;

/**
 * Represents command from frontend, e.g. "A7" or "B4"
 */
public class ChessPositionVoiceCommand {

    @ChessLetter
    @SerializedName("x")
    private final char letter;

    @ChessDigit
    @SerializedName("y")
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
