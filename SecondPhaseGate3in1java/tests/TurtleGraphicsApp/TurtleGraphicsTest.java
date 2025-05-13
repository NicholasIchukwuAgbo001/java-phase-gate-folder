package TurtleGraphicsApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TurtleGraphicsTest {

    @Test
    public void testPenIsUp(){
        TurtleGraphics turtleGraphics = new TurtleGraphics();
        turtleGraphics.isUp();
        assertTrue(turtleGraphics.getPenState());
    }

}