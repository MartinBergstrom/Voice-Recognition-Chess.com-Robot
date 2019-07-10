package model;

import com.google.gson.annotations.SerializedName;

public class MovePiece {
    @SerializedName("from")
    private final Coordinate fromCoordinate;
    @SerializedName("to")
    private final Coordinate toCoordinate;

    public MovePiece(Coordinate fromCoordinate, Coordinate toCoordinate) {
        this.fromCoordinate = fromCoordinate;
        this.toCoordinate = toCoordinate;
    }

    public Coordinate getFromCoordinate() {
        return fromCoordinate;
    }

    public Coordinate getToCoordinate() {
        return toCoordinate;
    }
}
