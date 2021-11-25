import java.awt.*;

/**
 *
 */
public class Scania extends Truck{

    /**
     *
     */
    public Scania() {
        super("Scania", 5, new PointDouble(100,100), new Direction(0),
                4, Color.black,400, 3);

    }

    /**
     * @return
     */
    @Override
    protected CargoPlatform setCargoPlatform(){
        return new ScaniaCargoPlatform(this);
    }

    /**
     * @return
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }


}
