package Cars;

import Head.*;
import HelperClasses.*;


import java.awt.*;

/**
 * Class that defines an arbitrary Car.
 */
public abstract class Car extends AutoVehicle {


    /**
     * Constructor of Car.
     *
     * @param modelName name of Car model
     * @param turningRadius turning radius of Car
     * @param location location of Car
     * @param direction direction of Car
     * @param nrDoors number of doors on Car
     * @param color color of Car
     * @param enginePower engine power of Car
     * @param brakeFactor brake factor of Car
     */
    //A constructor for all the declared variables above
    public Car(String modelName, int turningRadius, PointDouble location, Direction direction, int nrDoors, Color color, int enginePower, double brakeFactor) {
        super(modelName, turningRadius, location, direction, color, enginePower, brakeFactor, nrDoors);
    }

}