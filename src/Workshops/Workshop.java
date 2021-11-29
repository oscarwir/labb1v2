package Workshops;

import Cars.Car;

import java.util.ArrayList;

/**
 * Class that represents an arbitrary workshop.
 * @param <T> any car
 */
public abstract class Workshop<T extends Car> {

    private int amountCars = 0;
    private int capacity;
    private ArrayList<T> workshopCars = new ArrayList<T>();

    /**
     * Constructor of arbitrary workshop.
     * @param capacity max capacity of workshop
     */
    public Workshop(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Method to add new car to workshop.
     * @param car car to add to workshop
     */
    public void loadCar(T car){
        if (amountCars < capacity){
            workshopCars.add(car);
            amountCars++;
        }
    }

    public ArrayList getWorkshopCars(){
        return Workshop<T>;
    }

}
