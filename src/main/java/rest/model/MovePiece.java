package rest.model;

import com.google.gson.annotations.SerializedName;

public class MovePiece {
    @SerializedName("from")
    private final ChessPosition fromPos;
    @SerializedName("to")
    private final ChessPosition toPos;

    public MovePiece(ChessPosition fromPos, ChessPosition toPos) {
        this.fromPos = fromPos;
        this.toPos = toPos;
    }

    public ChessPosition getFromPos() {
        return fromPos;
    }

    public ChessPosition getToPos() {
        return toPos;
    }
}
