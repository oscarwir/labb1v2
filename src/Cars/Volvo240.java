package Cars;

import HelperClasses.Direction;
import HelperClasses.PointDouble;

import java.awt.*;

/**
 * Represents a Volvo240 car.
 */
public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;

    /**
     * Constructor for Volvo240
     */
    public Volvo240(){
        super("Volvo240", 20, new PointDouble(0,100), new Direction(0),4,Color.red,150, 1.5);
    }

    /**
     * Method that calculates the speedFactor. Dependent on EnginePower and trimFactor
     * @return speed factor
     */
    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }


}