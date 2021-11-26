package HelperClasses;
//To get the value of the direction between 0 and 360 degrees.

/**
 *
 */
public class Direction {

    protected int angle;

    /**
     * Constructor for Direction.
     * @param angle in degrees.
     */
    public Direction(int angle){
        this.angle = angle % 360; //We use modulus to exclude potential overlap of degrees. We only want degrees in the interval between 0 and 360.
    }

    /**
     * @param angle in degrees.
     */
    public void setDirection(int angle){
        this.angle = angle % 360;
    }

    /**
     * @return current angle of direction.
     */
    public int getDirection(){
        return angle;
    }

}

