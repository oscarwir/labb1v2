import java.util.ArrayList;

public class CarHaulerX2000CargoPlatform implements CargoPlatform{

    private double angle;
    private Truck myTruck;
    private ArrayList<Car> cargoCars = new ArrayList<Car>();


    /**
     * @param myTruck the Truck object that uses the platform
     */
    public CarHaulerX2000CargoPlatform(Truck myTruck){
        this.myTruck = myTruck;
        angle = 0;
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


    public Movable unloadCargo(){
        if (isPlatformFullyOpen()){
            if (cargoCars.size() == 1) {
                return cargoCars.remove(cargoCars.size() - 1);
            }
        }
        return null;
    }

    public void loadCargo(Movable car){
        if (isPlatformFullyOpen()){
            cargoCars.add((Car)car);
        }
    }

    public void moveCargo() {
        for (int i = 0; i < cargoCars.size(); i++) {
            Car car = cargoCars.get(i);
            car.setPosition(myTruck.getLocation());
        }
    }

    public void turnCargo(){
        for (int i = 0; i < cargoCars.size(); i++) {
            Car car = cargoCars.get(i);
            car.setDirection(new Direction(myTruck.getDirection()));
        }
    }
}
