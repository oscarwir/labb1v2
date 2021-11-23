public interface CargoPlatform {

    void moveCargo();

    void turnCargo();

    void unloadCargo();

    void loadCargo(Movable object);

    void raisePlatform();

    void lowerPlatform();

    boolean isPlatformFullyOpen();

    boolean isPlatformClosed();
}
