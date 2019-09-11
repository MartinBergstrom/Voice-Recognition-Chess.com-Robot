/**
 * Representation of chess.com chessboard
 */
public class ChessBoard {
    private int width;
    private int height;

    //private CoordinateResolver myCoordinateResolver; convert char and int to corresponding,
    // maybe that should use chessboard isntead?

    public int getTotalWidth() {
        return width;
    }

    public int getTotalHeight() {
        return height;
    }

    public int getWidthOfSquare() {
        return 0;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
