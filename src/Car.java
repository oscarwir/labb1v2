import java.awt.*;

public abstract class Car extends AutoVehicle {


    //A constructor for all the declared variables above
    public Car(String modelName, int turningRadius, PointDouble location, Direction direction, int nrDoors, Color color, int enginePower, double brakeFactor) {
        super(modelName, turningRadius, location, direction, color, enginePower, brakeFactor, nrDoors);
    }

}