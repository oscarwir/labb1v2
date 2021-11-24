public class ChalmersCustoms extends Workshop{

    public ChalmersCustoms(){
        super(20);
    }

    public void loadCar(Volvo240 car){
        if(amountCars < capacity){
            if (car instanceof Volvo240) {
                loadCar((Volvo240) car);
            }
        }
    }
}
