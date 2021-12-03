package Head;

import HelperClasses.Direction;
import HelperClasses.PointDouble;
import java.awt.image.BufferedImage;
import java.awt.*;


/**
 * Class of arbitrary motorized vehicles.
 */
public abstract class AutoVehicle implements IMovable {

    private double enginePower; // Engine power of the vehicle
    private double currentSpeed; // The current speed of the vehicle
    private Color color; // Color of the vehicle
    private String modelName; // The model name of the vehicle
    private Direction direction; //The direction the vehicle has using degrees
    private PointDouble location;   // The position the vehicle has using Java's built-in Point class
    private int turningRadius; //The turning radius of the vehicle
    private double breakFactor; //A factor that determine an arbitrary vehicle's breaking capability
    private boolean engineOn; //A boolean that serves as condition to drive the vehicle
    private int nrDoors; //An integer of the number of doors the vehicle has
    private BufferedImage image;

    /**
     * Constructor that creates an object of type AutoVehicle.
     * @param modelName name of Vehicle model
     * @param turningRadius turning radius of Vehicle
     * @param location location of Vehicle
     * @param direction direction of Vehicle
     * @param color color of Vehicle
     * @param enginePower engine power of Vehicle
     * @param brakeFactor brake factor of Vehicle
     * @param nrDoors number of doors of Vehicle
     */
    public AutoVehicle(String modelName, int turningRadius, PointDouble location, Direction direction, Color color, double enginePower, double brakeFactor, int nrDoors){
        this.modelName = modelName;
        this.turningRadius = turningRadius;
        this.location = location;
        this.direction = direction;
        this.color = color;
        this.enginePower = enginePower;
        this.breakFactor = brakeFactor;
        this.engineOn = false;
        this.nrDoors = nrDoors;
        this.image = setImage();
    }


    /**
     * Method to retrieve image of AutoVehicle
     * @return BufferedImage
     */
    public BufferedImage getImage(){
        return image;
    }

    /**
     * Method to get number of doors.
     * @return number of doors
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Method to get enginePower.
     * @return enginePower
     */
    public double getEnginePower() {
        return enginePower;
    }


    /**
     * Method to get currentSpeed.
     * @return currentSpeed
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }


    /**
     * Method to get modelName.
     * @return modelName
     */
    public String getModelName(){
        return modelName;
    }

    /**
     * Method to get location.
     * @return location
     */
    public PointDouble getLocation(){
        return location;
    }

    /**
     * Method to get direction.
     * @return direction
     */
    public int getDirection(){
        return direction.getDirection();
    }

    /**
     * Method to get color.
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Method to get turning radius.
     * @return turningRadius
     */
    public int getTurningRadius(){
        return turningRadius;
    }

    /**
     * Method to see engine state.
     * @return engineOn
     */
    public boolean getEngineOn(){
        return engineOn;
    }

    public double getBreakDistance(){

    }

    /**
     * Method to set turning radius.
     * @param turningRadius new turning radius
     */
    public void setTurningRadius(int turningRadius){
        this.turningRadius = turningRadius;
    }

    /**
     * Method to set color.
     * @param clr new color
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Method to set location.
     * @param location new location
     */
    public void setPosition(PointDouble location){
        this.location = location;
    }

    /**
     * Method to set direction.
     * @param direction new direction
     */
    public void setDirection(Direction direction){
        this.direction = direction;
    }

    /**
     * Method to start engine. This method sets the variable engineOn to true.
     */
    public void startEngine() {
        engineOn = true;
    }

    /**
     * Method to stop engine. This method sets the variable engineOn to false.
     */
    public void stopEngine() {
        engineOn = false;
    }




    /**
     * An abstract method only to be utilized by subclasses.
     */
    protected abstract double speedFactor();

    /**
     * An abstract method only to be utilized by subclasses.
     */
    protected abstract BufferedImage setImage();


    //Increment- and DecrementSpeed increases or decreases the speed based on the current speed.
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - breakFactor * amount,0);
    }

    /**
     * Method to increase vehicle speed. This method increases the vehicle's speed if engine is on and throws
     * IllegalArgumentException if parameter is out of bounds.
     * @param amount throttle percentage
     */
    public void gas(double amount) {
        if (engineOn) {
            if (amount >= 0 && amount <= 1) {
                incrementSpeed(amount);
            } else {
                throw new IllegalArgumentException("Gas amount is lower than 0 or higher than 1");
            }
        }
    }


    /**
     * Method to decrease vehicle speed. This method decreases the vehicle's speed and throws IllegalArgumentException
     * if parameter is out of bounds.
     * @param amount brake percentage
     */
    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
        else {
            throw new IllegalArgumentException("Break amount is lower than 0 or higher than 1");
        }
    }

    /**
     * Method that moves the vehicle. This method moves the vehicle to a new point calculated based on currentSpeed,
     * old position and direction. Direction and currentSpeed are unchanged.
     */
    public void move(){
        double x;
        double y;

        x = location.getX() + Math.cos(Math.toRadians(direction.getDirection())) * currentSpeed;
        y = location.getY() + Math.sin(Math.toRadians(direction.getDirection())) * currentSpeed;

        location.setLocation(x, y);

    }


    /**
     * Method to change direction to the left.
     * */
    public void turnLeft(){
        direction.setDirection(direction.getDirection() + turningRadius);
    }

    /**
     * Method to change direction to the right.
     */
    public void turnRight(){
        direction.setDirection(direction.getDirection() - turningRadius);
    }


}
