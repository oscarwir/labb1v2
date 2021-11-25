/**
 *
 */
public class ChalmersCustoms extends Workshop<Volvo240>{

    /**
     *
     */
    public ChalmersCustoms(){
        super(20);
    }

    /**
     * @param car
     */
    @Override
    void loadCar(Volvo240 car) {
        if(amountCars < capacity){
            getWorkshopCars().add(car);
        }
    }
}
