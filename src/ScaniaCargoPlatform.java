/**
 * Represents a Truck Platform
 */
public class ScaniaCargoPlatform implements CargoPlatform{

    private double angle;
    private double angleStep;
    private double maxAngle;
    private Truck myTruck;

    /**
     * @param myTruck the Truck object that uses the platform
     */
    public ScaniaCargoPlatform(Truck myTruck){
        this.maxAngle = 70;
        this.angleStep = 5;
        this.myTruck = myTruck;
        angle = 0;
    }

    /**
     * @return True if the angle attribute of the CargoPlatform object is zero, else False
     */
    public boolean isPlatformClosed(){
        return angle == 0;
    }

    /**
     * @return True if the angle attribute of the CargoPlatform object is equal to maxAngle, else False
     */
    public boolean isPlatformFullyOpen(){
        return angle == maxAngle;
    }

    /**
     * This lowerPlatform method increases the angle attribute of the CargoPlatform object, when the trucks CurrentSpeed attribute is zero
     */
    public void raisePlatform(){
        if (myTruck.getCurrentSpeed() == 0.0){
            angle = Math.min(angle + angleStep, maxAngle);
        }
    }

    /**
     * This raisePlatform method decreases the angle attribute of the CargoPlatform object
     */
    public void lowerPlatform(){
        angle = Math.max(angle - angleStep, 0);
    }


    /**
     *
     */
    public void unloadCargo(){

    }

    /**
     * @param object
     */
    public void loadCargo(Movable object){

    }

    /**
     *
     */
    public void moveCargo() {

    }

    /**
     *
     */
    public void turnCargo(){

    }
}
