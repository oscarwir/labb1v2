package Trucks;

import Head.Movable;

import java.util.ArrayList;

/**
 * Represents a Truck Platform
 */
public class ScaniaCargoPlatform implements CargoPlatform{

    private double angle;
    private double angleStep;
    private double maxAngle;
    private Truck myTruck;

    /**
     * @param myTruck the Trucks.Truck object that uses the platform
     */
    public ScaniaCargoPlatform(Truck myTruck){
        this.maxAngle = 70;
        this.angleStep = 5;
        this.myTruck = myTruck;
        angle = 0;
    }

    /**
     * @return True if the angle attribute of the Trucks.CargoPlatform object is zero, else False
     */
    public boolean isPlatformClosed(){
        return angle == 0;
    }

    /**
     * @return True if the angle attribute of the Trucks.CargoPlatform object is equal to maxAngle, else False
     */
    public boolean isPlatformFullyOpen(){
        return angle == maxAngle;
    }

    /**
     * This lowerPlatform method increases the angle attribute of the Trucks.CargoPlatform object, when the trucks CurrentSpeed attribute is zero
     */
    public void raisePlatform(){
        if (myTruck.getCurrentSpeed() == 0.0){
            angle = Math.min(angle + angleStep, maxAngle);
        }
    }

    /**
     * This raisePlatform method decreases the angle attribute of the Trucks.CargoPlatform object
     */
    public void lowerPlatform(){
        angle = Math.max(angle - angleStep, 0);
    }


    /**
     * Method to unload cargo. As this platform can not contain cargo this method does nothing.
     */
    public void unloadCargo(){

    }

    /**
     * Method to load cargo to platform. As this platforn can not contain cargo this method does nothing.
     * @param object
     */
    public void loadCargo(Movable object){

    }

    /**
     * Method to move cargo. As this platforn can not contain cargo this method does nothing.
     */
    public void moveCargo() {

    }

    /**
     * Method to turn cargo. As this platforn can not contain cargo this method does nothing.
     */
    public void turnCargo(){

    }

    /**
     * Method to get cargo. As this platforn can not contain cargo this method will always return an empty ArrayList.
     * @return an empty ArrayList
     */
    public ArrayList getCargo(){
        return new ArrayList();
    }
}
