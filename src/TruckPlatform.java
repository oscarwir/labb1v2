public class TruckPlatform {

    private double angle;
    private double angleStep;
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

    public void lowerPlatform(){
        if (myTruck.getCurrentSpeed() == 0.0){

        }
    }

    public void raisePlatform(){

    }

}
