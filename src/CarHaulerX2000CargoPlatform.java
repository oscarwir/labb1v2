import java.util.ArrayList;

public class CarHaulerX2000CargoPlatform implements CargoPlatform{

    private double angle;
    private Truck myTruck;
    private ArrayList<Car> cargoCars = new ArrayList<Car>();
    private int currentCarAmount;

    private final int maxCarAmount = 10;
    private final double maxLoadDistance = 15.0;
    /**
     * @param myTruck the Truck object that uses the platform
     */
    public CarHaulerX2000CargoPlatform(Truck myTruck){
        this.myTruck = myTruck;
        angle = 0;
        currentCarAmount = 0;
    }

    /**
     * @return True if the angle attribute of the CargoPlatform object is zero, else False
     */
    public boolean isPlatformClosed(){
        return angle == 0;
    }

    /**
     * @return True if the angle attribute of the CargoPlatform object is equal to maxAngle, else False
     */
    public boolean isPlatformFullyOpen(){
        return angle == 120;
    }

    /**
     * This lowerPlatform method increases the angle attribute of the CargoPlatform object, when the trucks CurrentSpeed attribute is zero
     */
    public void lowerPlatform(){
        if (myTruck.getCurrentSpeed() == 0.0){
            angle = 120;
        }
    }

    /**
     * This raisePlatform method decreases the angle attribute of the CargoPlatform object
     */
    public void raisePlatform(){
        angle = 0;
    }


    public void unloadCargo(){
        if (isPlatformFullyOpen()){
            if (cargoCars.size() > 0) {

            }
        }
    }

    public void loadCargo(Movable car){
        if (isPlatformFullyOpen()){
            if (car instanceof Car){
                loadCar((Car) car);
            }
        }
    }

    /**
     * When called all cargo is moved to the same location as mytruck
     */
    public void moveCargo() {
        for (int i = 0; i < cargoCars.size(); i++) {
            Car car = cargoCars.get(i);
            car.setPosition(myTruck.getLocation());
        }
    }

    /**
     * When called all cargo is oriented in the same direction as mytruck
     */
    public void turnCargo(){
        for (int i = 0; i < cargoCars.size(); i++) {
            Car car = cargoCars.get(i);
            car.setDirection(new Direction(myTruck.getDirection()));
        }
    }

    private void loadCar(Car car){
        if (myTruck.getLocation().distanceBetweenPoints(car.getLocation()) < maxLoadDistance){
            if(currentCarAmount < maxCarAmount){
                loadCargo(car);
                moveCargo();
                turnCargo();
                currentCarAmount++;
            }
        }
    }


}
