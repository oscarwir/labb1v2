import java.awt.*;

/**
 *
 */
public class Volvo240 extends Car{

    public final static double trimFactor = 1.25;

    /**
     *
     */
    public Volvo240(){
        super("Volvo240", 20, new PointDouble(150,100), new Direction(180),4,Color.red,150, 1.5);
    }

    /**
     * @return 
     */
    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }


}