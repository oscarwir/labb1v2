//overriding Point due to the need of double.

public class PointDouble {

    private double x;
    private double y;

    public PointDouble(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setLocation(double x, double y){
        this.x = x;
        this.y = y;
    }
}
