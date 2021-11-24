import java.awt.*;

public class CarHaulerX2000 extends Truck{

    public CarHaulerX2000(){
        super("CarHaulerX2000", 5, new PointDouble(200,100), new Direction(0), 2, Color.black,400, 3);
    }

    @Override
    protected CargoPlatform setCargoPlatform(){
        return new CarHaulerX2000CargoPlatform(this);
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

}
