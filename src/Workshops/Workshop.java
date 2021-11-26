package Workshops;

import Cars.Car;

import java.util.ArrayList;

/**
 *
 *
 * @param <T>
 */
public abstract class Workshop<T extends Car> {

    int amountCars = 0;
    int capacity;
    private ArrayList<T> workshopCars = new ArrayList<T>();

    /**
     * @param capacity
     */
    public Workshop(int capacity) {
        this.capacity = capacity;
    }

    public void loadCar(T car){
        if (amountCars < capacity){
            workshopCars.add(car);
            amountCars++;
        }
    }

}