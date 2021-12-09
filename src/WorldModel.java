import DistanceQuadrantHandler.DistanceInDirectionToCoordinateSystemEdge;
import Head.AutoVehicle;
import Head.IHaveTurbo;
import HelperClasses.Direction;
import HelperClasses.PointDouble;
import Trucks.Truck;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observer;

public class WorldModel{

    private int worldWidth;
    private int worldHeight;
    private ArrayList <IObserver> observers = new ArrayList<>();
    private final int delay = 50;
    private ArrayList <AutoVehicle> autoVehicles = new ArrayList<>();

    private javax.swing.Timer timer = new Timer(delay, new TimerListener());

    WorldModel(int width, int height){
        this.worldWidth = width;
        this.worldHeight = height;
        timer.start();
    }

    public void gas(double gasAmount) {
            double gas = ((double) gasAmount) / 100;
            for (AutoVehicle autoVehicle : autoVehicles) {
                autoVehicle.gas(gas);
            }
    }

    public void brake(double brakeAmount) {
        for (AutoVehicle autoVehicle : autoVehicles) {
            for (int i = 0; i < 10; i++) {
                autoVehicle.brake(1.0);
            }

        }
    }

    public void setTurboOn() {
        for (AutoVehicle autoVehicle : autoVehicles) {
            if (autoVehicle instanceof IHaveTurbo){
                ((IHaveTurbo) autoVehicle).setTurboOn();
            }
        }
    }

    public void setTurboOff() {
        for (AutoVehicle autoVehicle : autoVehicles) {
            if (autoVehicle instanceof IHaveTurbo){
                ((IHaveTurbo) autoVehicle).setTurboOff();
            }
        }
    }

    public void startCarEngine() {
        for (AutoVehicle autoVehicle : autoVehicles)
            autoVehicle.startEngine();
    }

    public void stopCarEngine() {
        for (AutoVehicle autoVehicle : autoVehicles)
            autoVehicle.stopEngine();
    }

    public void raisePlatform() {
        for (AutoVehicle autoVehicle : autoVehicles){
            if (autoVehicle instanceof Truck){
                ((Truck) autoVehicle).raisePlatform();
                System.out.println("Platform raised");
            }
        }
    }

    public void lowerPlatform() {
        for (AutoVehicle autoVehicle : autoVehicles){
            if (autoVehicle instanceof Truck){
                ((Truck) autoVehicle).lowerPlatform();
                System.out.println("Platform lowered");

            }
        }
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (AutoVehicle autoVehicle : autoVehicles){
                breakAndChangeDirectionAtEdgeOfDrawAutoVehiclesPanel(autoVehicle);
                autoVehicle.move();
            }
            for (IObserver observer : observers){
                observer.update();
            }
        }
    }

    public void addObserver(IObserver observer){
        observers.add(observer);
    }

    public void addAutoVehicle(AutoVehicle autoVehicle){
        autoVehicles.add(autoVehicle);
    }

    public ArrayList<AutoVehicle> getAutoVehicles(){
        return this.autoVehicles;
    }

    private void breakAndChangeDirectionAtEdgeOfDrawAutoVehiclesPanel(AutoVehicle autoVehicle){

        PointDouble pos = autoVehicle.getLocation();
        int dir = autoVehicle.getDirection();

        double distanceToEdge = DistanceInDirectionToCoordinateSystemEdge.getDistance(dir, pos, worldWidth - autoVehicle.getImage().getWidth(), worldHeight - autoVehicle.getImage().getHeight());
        double minBreakDistance = autoVehicle.getMinBreakDistance();


        if (autoVehicle.getCurrentSpeed() == 0.0){
            autoVehicle.setGasLock(false);
        }

        if (distanceToEdge < minBreakDistance){
            autoVehicle.setGasLock(true);
            autoVehicle.brake(1.0);
            if (autoVehicle.getCurrentSpeed() < 0.0001){
                autoVehicle.setGasLock(false);
                autoVehicle.setDirection(new Direction(autoVehicle.getDirection() + 180));
                autoVehicle.gas(1.0);
            }
        }

    }



}