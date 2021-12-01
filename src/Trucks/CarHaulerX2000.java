package Trucks;

import HelperClasses.Direction;
import HelperClasses.PointDouble;

import java.awt.*;

/**
 * Class representing car-haulers
 */
public class CarHaulerX2000 extends Truck {

    /**
     * Constructor of CarHaulerX2000
     */
    public CarHaulerX2000(){
        super("Trucks.CarHaulerX2000", 5, new PointDouble(200,100), new Direction(0), 2, Color.black,400, 3);
    }

    /**
     * Creates an CarHaulerX2000CargoPlatform
     * @return the CarHaulerX2000CargoPlatform
     */
    @Override
    protected CargoPlatform setCargoPlatform(){
        return new CarHaulerX2000CargoPlatform(this);
    }

    /**
     * @return speedFactor based on enginePower
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

}
