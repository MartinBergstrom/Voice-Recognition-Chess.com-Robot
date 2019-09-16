package base;

import java.awt.*;
import java.awt.event.InputEvent;

public class RobotHandler {
    private final Robot myRobot;

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
