import Cars.Saab95;
import Cars.Volvo240;
import Trucks.Scania;


/*
* This class represents the Controller part in the MVC pattern.
* Its responsibility is to listen to the View and respond in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class AutoVehicleController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;


    // A list of cars, modify if needed
    private WorldModel model;


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        AutoVehicleController cc = new AutoVehicleController();

        cc.model = new WorldModel(800, 560);

        cc.model.addAutoVehicle(new Volvo240());
        cc.model.addAutoVehicle(new Saab95());
        cc.model.addAutoVehicle(new Scania());

        cc.model.addObserver(new AutoVehicleView("Banana Rally", cc, cc.model));

    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gasAmount = ((double) amount) / 100;
        model.gas(gasAmount);
    }

    // Calls the brake method for each car once
    void brake() {
        model.brake(1.0);
    }

    // Calls the set turbo on method once per car that has a tubo
    void setTurboOn() {
        model.setTurboOn();
    }

    // Calls the set turbo off method once per car that has a turbo
    void setTurboOff() {
        model.setTurboOff();
    }

    // Calls the start engine method for each car once
    void startCarEngine() {
        model.startCarEngine();
    }

    // Calls the stop engine method for each car once
    void stopCarEngine() {
        model.stopCarEngine();
    }

    // Calls the raise platform method once per car that has a platform
    void raisePlatform(){
        model.raisePlatform();
    }

    // Calls the lower platform method once per car that has a platform
    void lowerPlatform(){
        model.lowerPlatform();

    }



}
