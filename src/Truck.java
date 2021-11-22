import java.awt.*;

/**
 * Is a super class to all Trucks
 */
public abstract class Truck extends AutoVehicle {

    private TruckPlatform platform;


    /**
     * @param modelName name
     * @param turningRadius Higher results in faster turning
     * @param location PointDouble object
     * @param direction Direction object
     * @param nrDoors number of doors
     * @param color color
     * @param enginePower Higher enginePower results in Higher max speed
     * @param brakeFactor Higher brakeFactor results in heavier deceleration
     * @param truckPlatformMaxAngle max open angle for truck platform, 0 degrees being fully closed
     * @param truckPlatformAngleStep the angle speed for lowering and lifting truck platform
     */
    //A constructor for all the declared variables above
    public Truck(String modelName, int turningRadius, PointDouble location, Direction direction,
                 int nrDoors, Color color, int enginePower, double brakeFactor,
                 double truckPlatformMaxAngle, double truckPlatformAngleStep) {

        super(modelName, turningRadius, location, direction, color, enginePower, brakeFactor, nrDoors);
        this.platform = new TruckPlatform(truckPlatformMaxAngle, truckPlatformAngleStep, this);
    }

    /**
     * Sets acceleration, 0 if platform is not closed
     * @param amount throttle percentage
     */
    @Override
    public void gas(double amount){
        if (platform.isPlatformClosed()){
            super.gas(amount);
        }
        else {
            super.gas(0);
        }
    }

    /**
     * This lowerPlatform method increases the angle attribute of the TruckPlatform object, when the trucks CurrentSpeed attribute is zero
     */
    public void lowerPlatform(){
        platform.lowerPlatform();
    }

    /**
     * This raisePlatform method decreases the angle attribute of the TruckPlatform object
     */
    public void raisePlatform(){
        platform.raisePlatform();
    }






}
