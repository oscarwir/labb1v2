
//To get the value of the direction between 0 and 360 degrees.

public class Direction {

    protected int angle;

    Direction(int angle){
        this.angle = angle % 360; //We use modulus to exclude potential overlap of degrees. We only want degrees in the intervall between 0 and 360.
    }

    void setDirection(int angle){
        this.angle = angle % 360;
    }

    int getDirection(){
        return angle;
    }

}
