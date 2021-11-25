import java.awt.*;

/**
 * An abstract class for arbitrary vehicles.
 */
public abstract class AutoVehicle implements Movable{

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

    /**
     * Constructor that creates an object of type AutoVehicle
     * @param modelName the supplied modelName
     * @param turningRadius the supplied turningRadius
     * @param location the supplied location
     * @param direction the supplied direction
     * @param color the supplied color
     * @param enginePower the supplied enginePower
     * @param brakeFactor the supplied brakeFactor
     * @param nrDoors the supplied nrDoors
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
    }

    /**
     * @return the number of doors
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * @return the value for the engine power for the vehicle
     */
    public double getEnginePower() {
        return enginePower;
    }


    /**
     * @return the current speed
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }


    /**
     * @return the modelName
     */
    public String getModelName(){
        return modelName;
    }

    /**
     * @return the current location
     */
    public PointDouble getLocation(){
        return location;
    }

    /**
     * @return the current direction
     */
    public int getDirection(){
        return direction.getDirection();
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return the turningRadius
     */
    public int getTurningRadius(){
        return turningRadius;
    }

    /**
     * @return the boolean indicating if engine is on or off
     */
    public boolean getEngineOn(){
        return engineOn;
    }

    /**
     * @param turningRadius
     */
    public void setTurningRadius(int turningRadius){
        this.turningRadius = turningRadius;
    }

    /**
     * @param clr the new color
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * @param location the new location
     */
    public void setPosition(PointDouble location){
        this.location = location;
    }

    /**
     * @param direction the new direction
     */
    public void setDirection(Direction direction){
        this.direction = direction;
    }

    /**
     * Method that turns on the engine.
     */
    public void startEngine() {
        engineOn = true;
    }

    /**
     * Method that turns off the engine.
     */
    public void stopEngine() {
        engineOn = false;
    }




    /**
     * An abstract method that generates a speedFactor.
     */
    abstract double speedFactor();


    //Increment- and DecrementSpeed increases or decreases the speed based on the current speed.
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - breakFactor * amount,0);
    }

    /**
     * Method that increases speed of vehicle. Throws IllegalArgumentException if amount is less than 0 or greater than 1.
     *
     * @param amount the throttle percentage
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
     * Method that decreases speed of vehicle. Throws IllegalArgumentException if amount is less than 0 or greater than 1.
     *
     * @param amount the brake percentage
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
     * Method that changes position of vehicle.
     */
    public void move(){
        double x;
        double y;

        x = location.getX() + Math.cos(Math.toRadians(direction.getDirection())) * currentSpeed;
        y = location.getY() + Math.sin(Math.toRadians(direction.getDirection())) * currentSpeed;

        location.setLocation(x, y);

    }


    /**
     * Method that changes the vehicle's direction.
     * */
    public void turnLeft(){
        direction.setDirection(direction.getDirection() + turningRadius);
    }

    /**
     * Method that changes the vehicle's direction.
     */
    public void turnRight(){
        direction.setDirection(direction.getDirection() - turningRadius);
    }


}
