package Trucks;

import Head.*;
import Cars.*;
import HelperClasses.*;
import java.util.ArrayList;

/**
 * Represents a CarHaulerX2000CargoPlatform. Platform mainly for CarHaulerX2000.
 */
public class CarHaulerX2000CargoPlatform implements CargoPlatform{

    private double angle;
    private Truck myTruck;
    private ArrayList<Car> cargoCars = new ArrayList<Car>(); //An Arraylist whereas order is significant
    private int currentCarAmount;

    private final int maxCarAmount = 6;
    private final double maxLoadDistance = 15.0;
    private final double spawnDistance = 20.0;
    /**
     * Constructor of a CarHaulerX2000CargoPlatform
     * @param myTruck the Truck object that uses the platform
     */
    public CarHaulerX2000CargoPlatform(Truck myTruck){
        this.myTruck = myTruck;
        angle = 0;
        currentCarAmount = 0;
    }

    /**
     * Method that checks if the platform is fully closed.
     * @return boolean
     */
    public boolean isPlatformClosed(){
        return angle == 0;
    }

    /**
     * Method that checks if the platform is fully open.
     * @return boolean
     */
    public boolean isPlatformFullyOpen(){
        return angle == 120;
    }

    /**
     * Method to lower platform. Only works if truck's speed is zero,
     */
    public void lowerPlatform(){
        if (myTruck.getCurrentSpeed() == 0.0){
            angle = 120;
        }
    }

    /**
     * Method to raise platform.
     */
    public void raisePlatform(){
        angle = 0;
    }


    /**
     * Method to unload cargo from platform. Only works if platform has cargo and is fully open.
     */
    public void unloadCargo(){
        if (isPlatformFullyOpen()){
            if (cargoCars.size() > 0) {
                Car unloadedVehicle = cargoCars.remove(cargoCars.size()-1);
                unloadedVehicle.setPosition(getUnloadedPos());

            }
        }
    }


    /**
     * Method to load object on platform. If all conditions are met, then the movable object will be stored on the platform.
     * @param object that attempts to be loaded
     */
    public void loadCargo(Movable object){
        if (isPlatformFullyOpen()){
            if (object instanceof Car){
                loadCar((Car) object);
            }
        }
    }

    /**
     * Method to move cargo. When called all cargo is moved to the same location as myTruck
     */
    public void moveCargo() {
        for (Car car : cargoCars) {
            car.setPosition(myTruck.getLocation());
        }
    }

    /**
     * Method to turn cargo. When called all cargo is oriented in the same direction as myTruck
     */
    public void turnCargo(){
        for (Car car : cargoCars) {
            car.setDirection(new Direction(myTruck.getDirection()));
        }
    }

    private void loadCar(Car car){
        if (myTruck.getLocation().distanceBetweenPoints(car.getLocation()) < maxLoadDistance){
            if(currentCarAmount < maxCarAmount){
                cargoCars.add(car);
                moveCargo();
                turnCargo();
                currentCarAmount++;
            }
        }
    }

    private PointDouble getUnloadedPos(){
        double x = myTruck.getLocation().getX();
        double y = myTruck.getLocation().getY();
        int behindTruckDir = myTruck.getDirection() + 180;


        x = x + Math.cos(Math.toRadians(behindTruckDir)) * spawnDistance;
        y = y + Math.sin(Math.toRadians(behindTruckDir)) * spawnDistance;

        return new PointDouble(x, y);



    }

    /**
     * Method to get cargo.
     * @return ArrayList of cars in cargo
     */
    public ArrayList getCargo(){
        return cargoCars;
    }


}
