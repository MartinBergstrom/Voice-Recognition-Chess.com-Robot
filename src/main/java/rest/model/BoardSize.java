package rest.model;

import com.google.gson.annotations.SerializedName;

public class BoardSize {
    @SerializedName("width")
    private int myBoardWidth;

    public int getBoardWidth() {
        return myBoardWidth;
    }
}
