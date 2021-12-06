package Cars;

import Head.IHaveTurbo;
import HelperClasses.Direction;
import HelperClasses.PointDouble;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Class that represents a Saab95 car.
 */
public class Saab95 extends Car implements IHaveTurbo {

    private boolean turboOn;

    /**
     * Constructor of objects of type Saab95
     */
    public Saab95() {
        super("Saab95", 10, new PointDouble(0,200), new Direction(0),4,Color.white,170, 0.02);
        turboOn = false;
    }

    /**
     * Method that turns on turbo.
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Method that turns off turbo
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * Method to get turbo's current value
     * @return boolean
     */
    public boolean getTurboState() {
        return turboOn;
    }

    /**
     * Method that calculates the speedFactor.
     * @return speed factor
     */
    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.001 * turbo;
    }

    @Override
    protected BufferedImage setImage(){
        try {
            return ImageIO.read(new File("src/pics/Saab95.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

}