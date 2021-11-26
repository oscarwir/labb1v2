package Trucks;

import Head.Movable;

import java.util.ArrayList;


public interface CargoPlatform {


    void moveCargo();


    void turnCargo();


    void unloadCargo();


    void loadCargo(Movable object);


    void raisePlatform();


    void lowerPlatform();


    boolean isPlatformFullyOpen();


    boolean isPlatformClosed();

    ArrayList getCargo();
}
