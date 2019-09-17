package base;

import java.awt.*;

public class Desktop {
    private static final int myWidth;
    private static final int myHeight;

    static {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        myWidth= gd.getDisplayMode().getWidth();
        myHeight = gd.getDisplayMode().getHeight();
    }

    public static int getWidth() {
        return myWidth;
    }

    public static int getHeight() {
        return myHeight;
    }
}
