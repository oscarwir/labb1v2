import Cars.Saab95;
import Cars.Volvo240;
import DistanceQuadrantHandler.DistanceInDirectionToCoordinateSystemEdge;
import Head.AutoVehicle;
import Head.IHaveTurbo;
import HelperClasses.Direction;
import HelperClasses.PointDouble;
import Trucks.Scania;
import Trucks.Truck;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibility is to listen to the View and respond in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class AutoVehicleController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;

    // The frame that represents this instance View of the MVC pattern
    private AutoVehicleView frame;
    // A list of cars, modify if needed
    private WorldModel model;


    //methods:

    public static void main(String[] args) {
        // Instance of this class
        AutoVehicleController cc = new AutoVehicleController();

        cc.model = new WorldModel(800, 560);

        // Start a new view and send a reference of self
        cc.frame = new AutoVehicleView("Banana Rally", cc);

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
        for (AutoVehicle autoVehicle : autoVehicles) {
            if (autoVehicle instanceof IHaveTurbo){
                ((IHaveTurbo) autoVehicle).setTurboOn();
            }
        }
    }

    // Calls the set turbo off method once per car that has a turbo
    void setTurboOff() {
        for (AutoVehicle autoVehicle : autoVehicles) {
            if (autoVehicle instanceof IHaveTurbo){
                ((IHaveTurbo) autoVehicle).setTurboOff();
            }
        }
    }

    // Calls the start engine method for each car once
    void startCarEngine() {
        for (AutoVehicle autoVehicle : autoVehicles)
            autoVehicle.startEngine();
    }

    // Calls the stop engine method for each car once
    void stopCarEngine() {
        for (AutoVehicle autoVehicle : autoVehicles)
            autoVehicle.stopEngine();
    }

    // Calls the raise platform method once per car that has a platform
    void raisePlatform(){
        for (AutoVehicle autoVehicle : autoVehicles){
            if (autoVehicle instanceof Truck){
                ((Truck) autoVehicle).raisePlatform();
                System.out.println("Platform raised");
            }

        }

    }

    // Calls the lower platform method once per car that has a platform
    void lowerPlatform(){
        for (AutoVehicle autoVehicle : autoVehicles){
            if (autoVehicle instanceof Truck){
                ((Truck) autoVehicle).lowerPlatform();
                System.out.println("Platform lowered");

            }

        }

    }



}
