package HelperClasses;
//To get the value of the direction between 0 and 360 degrees.

/**
 * Class representing a direction in degrees.
 */
public class Direction {

    private int angle;

    /**
     * Constructor for Direction.
     * @param angle in degrees.
     */
    public Direction(int angle){
        this.angle = angle % 360; //We use modulus to exclude potential overlap of degrees. We only want degrees in the interval between 0 and 360.
    }

    /**
     * Method to set direction. Uses degrees and will always be in range 0-360.
     * @param angle in degrees.
     */
    public void setDirection(int angle){
        this.angle = angle % 360;
    }

    /**
     * Method to get the current direction.
     * @return current direction.
     */
    public int getDirection(){
        return angle;
    }

}

