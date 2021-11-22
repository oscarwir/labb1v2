/**
 * Represents a Truck Platform
 */
public class TruckPlatform {

    private double angle;
    private double angleStep;
    private double maxAngle;
    private Truck myTruck;

    /**
     * @param maxAngle max open angle for truck platform, 0 degrees being fully closed
     * @param angleStep the angle speed for lowering and lifting truck platform
     * @param myTruck the Truck object that uses the platform
     */
    public TruckPlatform(double maxAngle, double angleStep, Truck myTruck){
        this.maxAngle = maxAngle;
        this.angleStep = angleStep;
        this.myTruck = myTruck;
        angle = 0;
    }

    /**
     * @return True if the angle attribute of the TruckPlatform object is zero, else False
     */
    public boolean isPlatformClosed(){
        return angle == 0;
    }


    /**
     * This lowerPlatform method increases the angle attribute of the TruckPlatform object, when the trucks CurrentSpeed attribute is zero
     */
    public void lowerPlatform(){
        if (myTruck.getCurrentSpeed() == 0.0){
            angle = Math.min(angle + angleStep, maxAngle);
        }
    }

    /**
     * This raisePlatform method decreases the angle attribute of the TruckPlatform object
     */
    public void raisePlatform(){
        angle = Math.max(angle - angleStep, 0);
    }

}
