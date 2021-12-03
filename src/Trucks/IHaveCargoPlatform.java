package Trucks;

import Head.IMovable;

import java.util.ArrayList;


/**
 * Interface of all CargoPlatforms.
 */
public interface IHaveCargoPlatform {


    /**
     * Method to move cargo.
     */
    void moveCargo();


    /**
     * Method to change cargo direction.
     */
    void turnCargo();


    /**
     * Method to unload cargo.
     */
    void unloadCargo();


    /**
     * Method to load cargo to platform.
     * @param object
     */
    void loadCargo(IMovable object);


    /**
     * Method to raise platform.
     */
    void raisePlatform();


    /**
     * Method to lower platform.
     */
    void lowerPlatform();


    /**
     * Method to check if platform is fully open.
     * @return boolean
     */
    boolean isPlatformFullyOpen();

    /**
     * Method to check if platform is fully closed.
     * @return boolean
     */
    boolean isPlatformClosed();

    /**
     * Method to get cargo.
     * @return list of cargo
     */
    ArrayList getCargo();
}
