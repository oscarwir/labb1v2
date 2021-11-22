public interface CargoPlatform {

    void moveCargo();

    <T> T unloadCargo();

    <T> void loadCargo(T object);

    void raisePlatform();

    void lowerPlatform();

    boolean isPlatformFullyOpen();

    boolean isPlatformClosed();
}
