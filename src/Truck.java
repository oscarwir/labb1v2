import java.awt.*;

public abstract class Truck extends AutoVehicle {

    private TruckPlatform platform;
    private int nrDoors; // Number of doors on the car

    //A constructor for all the declared variables above
    public Truck(String modelName, int turningRadius, PointDouble location, Direction direction,
                 int nrDoors, Color color, int enginePower, double brakeFactor,
                 double[] truckPlatformInterval, double truckPlatformAngleStep) {
        super(modelName, turningRadius, location, direction, color, enginePower, brakeFactor);
        this.nrDoors = nrDoors;
        this.platform = new TruckPlatform(truckPlatformInterval, truckPlatformAngleStep, this);
    }




    //All the getters

    public int getNrDoors() {
        return nrDoors;
    }



}
