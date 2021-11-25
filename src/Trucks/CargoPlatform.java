package Trucks;

/**
 *
 */
public interface CargoPlatform {

    /**
     *
     */
    void moveCargo();

    /**
     *
     */
    void turnCargo();

    /**
     *
     */
    void unloadCargo();

    /**
     * @param object
     */
    void loadCargo(Movable object);

    /**
     *
     */
    void raisePlatform();

    /**
     *
     */
    void lowerPlatform();

    /**
     * @return
     */
    boolean isPlatformFullyOpen();

    /**
     * @return
     */
    boolean isPlatformClosed();
}
