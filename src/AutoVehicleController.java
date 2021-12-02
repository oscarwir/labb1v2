import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Cars.*;
import Head.AutoVehicle;
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
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    AutoVehicleView frame;
    // A list of cars, modify if needed
    ArrayList<AutoVehicle> autoVehicles = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        AutoVehicleController cc = new AutoVehicleController();

        cc.autoVehicles.add(new Volvo240());
        cc.autoVehicles.add(new Saab95());
        cc.autoVehicles.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new AutoVehicleView("Bandana Rallyt", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (AutoVehicle autoVehicle : autoVehicles) {
                autoVehicle.move();
                int x = (int) Math.round(autoVehicle.getLocation().getX());
                int y = (int) Math.round(autoVehicle.getLocation().getY());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (AutoVehicle autoVehicle : autoVehicles
                ) {
            autoVehicle.gas(gas);
        }
    }

    // Calls the brake method for each car once
    void brake() {
        for (AutoVehicle autoVehicle : autoVehicles)
            autoVehicle.brake(0.50);
    }

    /*void setTurboOn() {
        for (Car car : cars) {

        }
    }

    void setTurboOff() {
        for (Car car : cars) {
            if (car istanceOf(Saab95)){

            }
        }

    }*/

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

}
