import model.Coordinate;

import java.awt.*;
import java.awt.event.InputEvent;

public class RobotHandler {
    private final Robot myRobot;

    public static void main(String[] args) throws AWTException {
        RobotHandler robotHandler = new RobotHandler();
        robotHandler.moveAndClick(new Coordinate(500, 530));
        robotHandler.moveAndClick(new Coordinate(500, 410));
    }

    // scritet kommer skicka röst from och to, "e1 to e3"
    // logik för att räkna ut vilka koordinater som krävs för klicka mitten på ruta
    // e1 till att klicka på mitten ruta e3
    // scriptet skickar updaterad info om skärmstorlek
    // samt enable/disable

    public RobotHandler() throws AWTException {
        myRobot = new Robot();
    }

    public void moveMouse(Coordinate coordinate) {
        myRobot.mouseMove(coordinate.getX(), coordinate.getY());
    }

    public void moveAndClick(Coordinate coord) {
        myRobot.delay(2000);
        myRobot.mouseMove(coord.getX(), coord.getY());
        myRobot.mousePress(InputEvent.BUTTON1_MASK);
        myRobot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
}
