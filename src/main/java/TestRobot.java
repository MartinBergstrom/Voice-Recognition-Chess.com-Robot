import java.awt.*;
import java.awt.event.InputEvent;

public class TestRobot {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        robot.delay(5000);

        robot.mouseMove(650,530);

        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease( InputEvent.BUTTON1_MASK );

    }
}
