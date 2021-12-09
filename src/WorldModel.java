import DistanceQuadrantHandler.DistanceInDirectionToCoordinateSystemEdge;
import Head.AutoVehicle;
import HelperClasses.Direction;
import HelperClasses.PointDouble;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observer;

public class WorldModel{

    private int worldWidth;
    private int worldHeight;
    private ArrayList <IObserver> observers;
    private final int delay = 50;
    private ArrayList <AutoVehicle> autoVehicles;

    private javax.swing.Timer timer = new Timer(delay, new TimerListener());

    WorldModel(int width, int height){
        this.worldWidth = width;
        this.worldHeight = height;
        timer.start();
    }

    public void gas(double gasAmount) {

    }

    public void brake(double brakeAmount) {

    }

    public void setTurboOn() {
    }

    public void setTurboOff() {
    }

    public void startCarEngine() {
    }

    public void stopCarEngine() {
    }

    public void raisePlatform() {
    }

    public void lowerPlatform() {
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
        this.autoVehicles.add(autoVehicle);
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