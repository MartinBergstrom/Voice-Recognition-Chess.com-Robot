import rest.model.ChessPositionVoiceCommand;
import rest.model.MovePiece;

import java.awt.*;
import java.awt.event.InputEvent;

import static main.AnnotationValidationEngine.runValidationOnBean;

public class TestRobot {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        MovePiece movePiece = new MovePiece(new ChessPositionVoiceCommand('a', 1),
                new ChessPositionVoiceCommand('b', 2));

        runValidationOnBean(movePiece);
    }
}
