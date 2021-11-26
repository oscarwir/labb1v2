package Trucks;

import Head.*;
import HelperClasses.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * Is a super class to all Trucks
 */
public abstract class Truck extends AutoVehicle {

    private CargoPlatform platform;

    /**
     * @param modelName name
     * @param turningRadius Higher results in faster turning
     * @param location HelperClasses.PointDouble object
     * @param direction HelperClasses.Direction object
     * @param nrDoors number of doors
     * @param color color
     * @param enginePower Higher enginePower results in Higher max speed
     * @param brakeFactor Higher brakeFactor results in heavier deceleration
     */
    public Truck(String modelName, int turningRadius, PointDouble location, Direction direction,
                 int nrDoors, Color color, int enginePower, double brakeFactor) {

        super(modelName, turningRadius, location, direction, color, enginePower, brakeFactor, nrDoors);
        this.platform = setCargoPlatform();
    }

    /**
     * @return
     */
    protected abstract CargoPlatform setCargoPlatform();

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
     *
     */
    @Override
    public void move(){
        super.move();
        platform.moveCargo();
    }

    /**
     *
     */
    @Override
    public void turnLeft(){
        super.turnLeft();
        platform.turnCargo();
    }

    /**
     *
     */
    @Override
    public void turnRight(){
        super.turnRight();
        platform.turnCargo();
    }


    /**
     * This lowerPlatform method increases the angle attribute of the Trucks.CargoPlatform object, when the trucks CurrentSpeed attribute is zero
     */
    public void lowerPlatform(){
        platform.lowerPlatform();
    }

    /**
     * This raisePlatform method decreases the angle attribute of the Trucks.CargoPlatform object
     */
    public void raisePlatform(){
        platform.raisePlatform();
    }

    /**
     * @return True if the angle attribute of the Trucks.CargoPlatform object is equal to maxAngle, else False
     */
    public boolean isPlatformFullyOpen(){
        return platform.isPlatformFullyOpen();
    }

    /**
     * @return True if the angle attribute of the Trucks.CargoPlatform object is zero, else False
     */
    public boolean isPlatformClosed(){
        return platform.isPlatformClosed();
    }


    /**
     * When called will unload object
     */
    public void unloadCargo(){
        platform.unloadCargo();
    }

    /**
     * When called will load object
     * @param object that will be loaded
     */
    public void loadCargo(Movable object){
        platform.loadCargo(object);
    }

    public ArrayList getCargoCars(){
        return platform.getCargo();
    }



}
