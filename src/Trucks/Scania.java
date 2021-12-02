package Trucks;
import Cars.Saab95;
import HelperClasses.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Class that represents a Scania.
 */
public class Scania extends Truck {

    /**
     * Constructor for Scania.
     */
    public Scania() {
        super("Scania", 5, new PointDouble(0,300), new Direction(0),
                4, Color.black,400, 3);
    }

    /**
     * Creates an ScaniaCargoPlatform.
     * @return the ScaniaCargoPlatform
     */
    @Override
    protected CargoPlatform setCargoPlatform(){
        return new ScaniaCargoPlatform(this);
    }

    /**
     * Method that calculates the speedFactor.
     * @return speed factor
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
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
