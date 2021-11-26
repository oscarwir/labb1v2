package Trucks;
import HelperClasses.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * Class of car-haulers
 * Is a subclass of Trucks.Truck.
 */
public class CarHaulerX2000 extends Truck {

    /**
     * Constructor of Trucks.CarHaulerX2000
     */
    public CarHaulerX2000(){
        super("Trucks.CarHaulerX2000", 5, new PointDouble(200,100), new Direction(0), 2, Color.black,400, 3);
    }

    /**
     * Creates an arbitrary CargoPlatform
     * @return the arbitrary cargoPlatform
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

    public ArrayList getCargoCars(){
        return getPlatform().getCargo();
    }
}
