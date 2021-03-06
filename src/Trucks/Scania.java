package Trucks;
import HelperClasses.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Class that represents a Scania.
 */
public class Scania extends Truck {

    /**
     * Constructor for Scania.
     */
    public Scania() {
        super("Scania", 5, new PointDouble(0,300), new Direction(0),
                4, Color.black,400, 0.03);
    }

    /**
     * Creates an ScaniaCargoPlatform.
     * @return the ScaniaCargoPlatform
     */
    @Override
    protected IHaveCargoPlatform setCargoPlatform(){
        return new ScaniaCargoPlatform(this);
    }

    /**
     * Method that calculates the speedFactor.
     * @return speed factor
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.001;
    }

    @Override
    protected BufferedImage setImage(){
        try {
            return ImageIO.read(new File("src/pics/Scania.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }


}
