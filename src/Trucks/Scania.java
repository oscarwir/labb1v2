package Trucks;
import HelperClasses.*;
import java.awt.*;

/**
 * Class that represents a Scania.
 */
public class Scania extends Truck {

    /**
     * Constructor for Scania.
     */
    public Scania() {
        super("Scania", 5, new PointDouble(100,100), new Direction(0),
                4, Color.black,400, 3);
    }

    /**
     * Creates an ScaniaCargoPlatform.
     * @return the ScaniaCargoPlatform
     */
    @Override
    protected CargoPlatform setCargoPlatform(){
        return new ScaniaCargoPlatform(this);
    }

    /**
     * Method that calculates the speedFactor.
     * @return speed factor
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }


}
