import Cars.Saab95;
import Cars.Volvo240;
import Trucks.Scania;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
* This class represents the Controller part in the MVC pattern.
* Its responsibility is to listen to the View and respond in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class AutoVehicleController {
    // member fields:


    private WorldModel model;
    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 1;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");


    //methods:

    public AutoVehicleController(WorldModel model, JFrame frame) {
        this.model = model;

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        10);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        frame.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((AutoVehicleView.X/2)+4, 200));
        frame.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(AutoVehicleView.X/5-15,200));
        frame.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(AutoVehicleView.X/5-15,200));
        frame.add(stopButton);

        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(gasAmount);
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake();
            }
        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOn();
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOff();
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                raisePlatform();
            }
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerPlatform();
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startCarEngine();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopCarEngine();
            }
        });






    }
    public static void main(String[] args) {
        // Instance of this class

        WorldModel model = new WorldModel(800, 560);
        AutoVehicleView view = new AutoVehicleView("Banana Rally", model);
        AutoVehicleController cc = new AutoVehicleController(model, view);
        view.finalise();
        model.addObserver(view);

        model.addAutoVehicle(new Volvo240());
        model.addAutoVehicle(new Saab95());
        model.addAutoVehicle(new Scania());


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
