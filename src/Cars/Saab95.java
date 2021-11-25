package Cars;

import java.awt.*;
import HelperClasses.*;

/**
 *
 */
public class Saab95 extends Car {

    public boolean turboOn;

    /**
     *
     */
    public Saab95() {
        super("Car.Car.Saab95", 10, new PointDouble(100,100), new Direction(0),4,Color.white,170, 2);
        turboOn = false;
    }

    /**
     *
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     *
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * @return
     */
    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}