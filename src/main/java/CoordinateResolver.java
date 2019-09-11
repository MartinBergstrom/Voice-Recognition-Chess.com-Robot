import model.ChessPosition;
import model.Coordinate;

public class CoordinateResolver {
    private ChessBoard myChessBoard;

    public CoordinateResolver(ChessBoard chessBoard) {
        myChessBoard = chessBoard;
    }

    public Coordinate convert(ChessPosition chessPosition) {
        // get Current ChessBoard position
        // calculate with math shits, keep matrix? [][], or scale factor for x, y.
        // for x, just get width of board, get scale factor e= 5/8 = 0.625. divide that shit
        // then substract width of one square.


        return null;
    }
}
