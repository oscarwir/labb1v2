public class TruckPlatform {

    private double angle;
    private double angleStep = 1.0;
    private double[] interval;
    private Truck myTruck;

    public TruckPlatform(double[] interval, double angleStep, Truck myTruck){
        this.interval = interval;
        this.angleStep = angleStep;
        this.myTruck = myTruck;
        angle = 0;
    }

    public boolean isPlatformClosed(){
        return angle == interval[0];
    }

}
