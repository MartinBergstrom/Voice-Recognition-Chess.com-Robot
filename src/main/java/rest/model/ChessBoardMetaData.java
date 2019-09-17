package rest.model;

import base.Coordinate;
import com.google.gson.annotations.SerializedName;

import java.util.Optional;

public class ChessBoardMetaData {
    @SerializedName("width")
    private int myBoardWidth;
    @SerializedName("startCoordinate")
    private Coordinate myStartingCoordinate;

    public int getBoardWidth() {
        return myBoardWidth;
    }

    public Optional<Coordinate> getStartingCoordinate() {
        return Optional.ofNullable(myStartingCoordinate);
    }
}
