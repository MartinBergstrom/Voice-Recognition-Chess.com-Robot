package rest.model;

import com.google.gson.annotations.SerializedName;

public class MovePiece {
    @SerializedName("from")
    private final ChessPositionVoiceCommand fromPos;
    @SerializedName("to")
    private final ChessPositionVoiceCommand toPos;

    public MovePiece(ChessPositionVoiceCommand fromPos, ChessPositionVoiceCommand toPos) {
        this.fromPos = fromPos;
        this.toPos = toPos;
    }

    public ChessPositionVoiceCommand getFromPos() {
        return fromPos;
    }

    public ChessPositionVoiceCommand getToPos() {
        return toPos;
    }
}
