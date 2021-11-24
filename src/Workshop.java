import java.util.ArrayList;

public abstract class Workshop {

    int amountCars = 0;
    int capacity;
    private ArrayList<Car> workshopCars = new ArrayList<Car>();

    public Workshop(int capacity) {
        this.capacity = capacity;
    }

    abstract void loadCar(Car car);

}
