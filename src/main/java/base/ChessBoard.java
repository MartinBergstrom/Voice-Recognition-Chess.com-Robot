package base;

/**
 * Representation of chess.com chessboard
 */
public class ChessBoard {
    private static final int DEFAULT_WIDTH = 800;

    private int width = DEFAULT_WIDTH;

    public int getTotalWidth() {
        return width;
    }

    public int getWidthOfSquare() {
        return DEFAULT_WIDTH / 8;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
