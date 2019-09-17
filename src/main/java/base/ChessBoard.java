package base;

/**
 * Representation of chess.com chessboard
 */
public class ChessBoard {
    private static final int DEFAULT_WIDTH = 800;

    private int width = DEFAULT_WIDTH;
    private Coordinate myStartingCoordinate;

    public int getTotalWidth() {
        return width;
    }

    public int getWidthOfSquare() {
        return DEFAULT_WIDTH / 8;
    }

    public Coordinate getStartingCoordinate() {
        return myStartingCoordinate;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setStartingCoordinate(Coordinate coordinate) {
       this.myStartingCoordinate = coordinate;
    }

}
