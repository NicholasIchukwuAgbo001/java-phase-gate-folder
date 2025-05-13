package TurtleGraphicsApp;

public class TurtleGraphics {

    private boolean penIsUp = true;

    Direction direction = Direction.EAST;

    public void isUp(){
         this.penIsUp = true;
    }

    public void isDown(){
        this.penIsUp = false;
    }

    public boolean getPenState(){
        return penIsUp;
    }

}
