import java.awt.*;

/**
 * Is a super class to all Trucks
 */
public abstract class Truck extends AutoVehicle {

    private CargoPlatform platform;


    /**
     * @param modelName name
     * @param turningRadius Higher results in faster turning
     * @param location PointDouble object
     * @param direction Direction object
     * @param nrDoors number of doors
     * @param color color
     * @param enginePower Higher enginePower results in Higher max speed
     * @param brakeFactor Higher brakeFactor results in heavier deceleration
     */
    //A constructor for all the declared variables above
    public Truck(String modelName, int turningRadius, PointDouble location, Direction direction,
                 int nrDoors, Color color, int enginePower, double brakeFactor) {

        super(modelName, turningRadius, location, direction, color, enginePower, brakeFactor, nrDoors);
    }

    protected void setCargoPlatform(CargoPlatform platform){
        this.platform = platform;
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
     * This lowerPlatform method increases the angle attribute of the CargoPlatform object, when the trucks CurrentSpeed attribute is zero
     */
    public void lowerPlatform(){
        platform.lowerPlatform();
    }

    /**
     * This raisePlatform method decreases the angle attribute of the CargoPlatform object
     */
    public void raisePlatform(){
        platform.raisePlatform();
    }

    /**
     * @return True if the angle attribute of the CargoPlatform object is equal to maxAngle, else False
     */
    public boolean isPlatformFullyOpen(){
        return platform.isPlatformFullyOpen();
    }

    /**
     * @return True if the angle attribute of the CargoPlatform object is zero, else False
     */
    public boolean isPlatformClosed(){
        return platform.isPlatformClosed();
    }

    <T> T unloadCargo(){
        return platform.unloadCargo();
    }

    <T> void loadCargo(T object){
        platform.loadCargo(object);
    }





}
