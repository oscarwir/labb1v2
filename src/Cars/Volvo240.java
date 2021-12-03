package Cars;

import HelperClasses.Direction;
import HelperClasses.PointDouble;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Represents a Volvo240 car.
 */
public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;

    /**
     * Constructor for Volvo240
     */
    public Volvo240(){
        super("Volvo240", 20, new PointDouble(0,100), new Direction(0),4,Color.red,150, 1.5);
    }

    /**
     * Method that calculates the speedFactor. Dependent on EnginePower and trimFactor
     * @return speed factor
     */
    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    protected BufferedImage setImage(){
        try {
            return ImageIO.read(new File("src/pics/Volvo240.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }


}