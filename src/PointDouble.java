//overriding Point due to the need of double.

/**
 *
 */
public class PointDouble {

    private double x;
    private double y;

    /**
     * @param x
     * @param y
     */
    public PointDouble(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return
     */
    public double getX(){
        return x;
    }

    /**
     * @return
     */
    public double getY(){
        return y;
    }

    /**
     * @param x
     * @param y
     */
    public void setLocation(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * @param p2
     * @return
     */
    public double distanceBetweenPoints(PointDouble p2){
        return Math.sqrt(Math.pow(this.getX() - p2.getX(),2) + Math.pow(this.getY() - p2.getY(),2));
    }
}
