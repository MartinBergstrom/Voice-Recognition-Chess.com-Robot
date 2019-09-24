package base;

import rest.model.ChessPositionVoiceCommand;
import rest.model.MovePiece;

import java.util.HashMap;
import java.util.Map;

public class CoordinateResolver {
    private ChessBoard myChessBoard;
    /*
        A8 B8 C8 D8 E8 F8 G8 H8
        A7 B7 C7 D7 E7 F7 G7 H7
        A6 B6 C6 D6 E6 F6 G6 H6
        A5 B5 C5 D5 E5 F5 G5 H5
        A4 B4 C4 D4 E4 F4 G4 H4
        A3 B3 C3 D3 E3 F3 G3 H3
        A2 B2 C2 D2 E2 F2 G2 H2
        A1 B1 C1 D1 E1 F1 G1 H1
     */

    public CoordinateResolver(ChessBoard chessBoard) {
        myChessBoard = chessBoard;
    }

    public Pair<Coordinate> convert(MovePiece movePiece) {
        ChessBoardPosition convertedFrom = new ChessBoardPosition(movePiece.getFromPos());
        ChessBoardPosition convertedTo = new ChessBoardPosition(movePiece.getToPos());

        Coordinate resultCoordinateFrom = new Coordinate(calculateDelta(convertedFrom.convertedXpos), calculateDelta(convertedFrom.convertedYPos));
        Coordinate resultCoordinateTo = new Coordinate(calculateDelta(convertedTo.convertedXpos), calculateDelta(convertedTo.convertedYPos));

        return new Pair<>(resolveDelta(resultCoordinateFrom), resolveDelta(resultCoordinateTo));
    }

    private Coordinate resolveDelta(Coordinate deltaCoordinate) {
        Coordinate startCoordinate = myChessBoard.getStartingCoordinate();
        return new Coordinate(startCoordinate.getX() + deltaCoordinate.getX(),
                startCoordinate.getY() + deltaCoordinate.getY());
    }

    private int calculateDelta(int pos)  {
        int widthOfSquare = myChessBoard.getWidthOfSquare();
        return  (pos * widthOfSquare) - (widthOfSquare / 2);
    }

    private static class ChessBoardPosition {
        private int convertedXpos;
        private int convertedYPos;

        private static final Map<Character, Integer> X_AXIS = new HashMap<>();
        static {
            X_AXIS.put('A', 1);
            X_AXIS.put('B', 2);
            X_AXIS.put('C', 3);
            X_AXIS.put('D', 4);
            X_AXIS.put('E', 5);
            X_AXIS.put('F', 6);
            X_AXIS.put('G', 7);
            X_AXIS.put('H', 8);
        }

        private static int convertYAxisNumber(int x)
        {
            return ((8-x) % 8) + 1;
        }

        public ChessBoardPosition(ChessPositionVoiceCommand chessPositionVoiceCommand) {
            this.convertedXpos = X_AXIS.get(chessPositionVoiceCommand.getLetter());
            this.convertedYPos = convertYAxisNumber(chessPositionVoiceCommand.getDigit());
        }
    }
}
