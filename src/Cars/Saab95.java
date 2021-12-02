package Cars;

import HelperClasses.Direction;
import HelperClasses.PointDouble;

import java.awt.*;

/**
 * Class that represents a Saab95 car.
 */
public class Saab95 extends Car {

    public boolean turboOn;

    /**
     * Constructor of objects of type Saab95
     */
    public Saab95() {
        super("Saab95", 10, new PointDouble(20,200), new Direction(0),4,Color.white,170, 2);
        turboOn = false;
    }

    /**
     * Method that turns on turbo.
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Method that turns off turbo
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * Method that calculates the speedFactor.
     * @return speed factor
     */
    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}