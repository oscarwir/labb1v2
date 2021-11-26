package Trucks;

import Head.*;
import HelperClasses.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * Class that represents Truck objects.
 */
public abstract class Truck extends AutoVehicle {

    private CargoPlatform platform;

    /**
     * Constructor of an arbitrary truck.
     * @param modelName model name of truck
     * @param turningRadius turning radius of truck
     * @param location location of truck
     * @param direction direction of truck
     * @param nrDoors number of doors on truck
     * @param color color of truck
     * @param enginePower engine power of truck
     * @param brakeFactor brake factor of truck
     */
    public Truck(String modelName, int turningRadius, PointDouble location, Direction direction,
                 int nrDoors, Color color, int enginePower, double brakeFactor) {

        super(modelName, turningRadius, location, direction, color, enginePower, brakeFactor, nrDoors);
        this.platform = setCargoPlatform();
    }

    /**
     * An abstract method to be utilized by subclasses. Specifies the type of cargo platform used by truck.
     * @return CargoPlatform
     */
    protected abstract CargoPlatform setCargoPlatform();

    /**
     * Increases the speed of the truck.
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
     * Method to move the truck.
     */
    @Override
    public void move(){
        super.move();
        platform.moveCargo();
    }

    /**
     * Method to turn the truck to the left.
     */
    @Override
    public void turnLeft(){
        super.turnLeft();
        platform.turnCargo();
    }

    /**
     * Method to turn the truck to the right.
     */
    @Override
    public void turnRight(){
        super.turnRight();
        platform.turnCargo();
    }


    /**
     * Method to lower the truck's cargo platform.
     */
    public void lowerPlatform(){
        platform.lowerPlatform();
    }

    /**
     * Method to raise the truck's cargo platform.
     */
    public void raisePlatform(){
        platform.raisePlatform();
    }

    /**
     * Method to see if truck's cargoPlatform is fully open.
     * @return boolean
     */
    public boolean isPlatformFullyOpen(){
        return platform.isPlatformFullyOpen();
    }

    /**
     * Method to see if truck's cargoPlatform is fully closed.
     * @return boolean
     */
    public boolean isPlatformClosed(){
        return platform.isPlatformClosed();
    }


    /**
     * Method to unload cargo from cargoPlatform.
     */
    public void unloadCargo(){
        platform.unloadCargo();
    }

    /**
     * Method to load cargo to cargoPlatform.
     * @param object that will be loaded
     */
    public void loadCargo(Movable object){
        platform.loadCargo(object);
    }


    /**
     * Method to get list of cargo on cargoPlatform.
     * @return list of cargo on platform
     */
    public ArrayList getCargo(){
        return platform.getCargo();
    }



}
