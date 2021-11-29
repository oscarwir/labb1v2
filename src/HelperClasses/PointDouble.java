package HelperClasses;//overriding Point due to the need of double.

/**
 * Class that represents a Point with doubles.
 */
public class PointDouble {

    private double x;
    private double y;

    /**
     * Constructor of a PointDouble.
     * @param x coordinate.
     * @param y coordinate.
     */
    public PointDouble(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * Method to get x-coordinate.
     * @return x coordinate.
     */
    public double getX(){
        return x;
    }

    /**
     * Method to get y-coordinate.
     * @return y coordinate.
     */
    public double getY(){
        return y;
    }

    /**
     * Method to set x and y coordinates.
     * @param x new coordinate.
     * @param y new coordinate.
     */
    public void setLocation(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * Method to calculate distance between this and another Point.
     * @param p2 Point to measure against.
     * @return distance between points.
     */
    public double distanceBetweenPoints(PointDouble p2){
        return Math.sqrt(Math.pow(this.getX() - p2.getX(),2) + Math.pow(this.getY() - p2.getY(),2));
    }

/* We need a getter and make distance between point private
    public double getDistanceBetweenPoints(){
        return distanceBetweenPoints(PointDouble p2);
    }

 */
}
