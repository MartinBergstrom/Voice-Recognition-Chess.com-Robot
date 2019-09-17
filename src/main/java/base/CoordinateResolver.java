package base;

import rest.model.MovePiece;

public class CoordinateResolver {
    private ChessBoard myChessBoard;

    public CoordinateResolver(ChessBoard chessBoard) {
        myChessBoard = chessBoard;
    }

    public Coordinate resolveStartingCoordinate(Coordinate coordinate)
    {
        return new Coordinate(coordinate.getX(),  (Desktop.getHeight() - coordinate.getY()) );
    }

    public Pair<Coordinate> convert(MovePiece movePiece) {
        // calculate with math shits, keep matrix? [][], or scale factor for x, y.
        // for x, just get width of board, get scale factor e= 5/8 = 0.625. divide that shit
        // then substract width of one square.

        myChessBoard.getTotalWidth();


        return null;
    }
}
