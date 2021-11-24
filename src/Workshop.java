import java.util.ArrayList;

public abstract class Workshop<T extends Car> {

    int amountCars = 0;
    int capacity;
    private ArrayList<T> workshopCars = new ArrayList<T>();

    public Workshop(int capacity) {
        this.capacity = capacity;
    }

    abstract void loadCar(T car);

}
