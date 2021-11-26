package HelperClasses;//overriding Point due to the need of double.

/**
 *
 */
public class PointDouble {

    private double x;
    private double y;

    /**
     * @param x coordinate.
     * @param y coordinate.
     */
    public PointDouble(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return x coordinate.
     */
    public double getX(){
        return x;
    }

    /**
     * @return y coordinate.
     */
    public double getY(){
        return y;
    }

    /**
     * @param x coordinate.
     * @param y coordinate.
     */
    public void setLocation(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * @param p2 Point to measure against.
     * @return distance between points.
     */
    public double distanceBetweenPoints(PointDouble p2){
        return Math.sqrt(Math.pow(this.getX() - p2.getX(),2) + Math.pow(this.getY() - p2.getY(),2));
    }
}
