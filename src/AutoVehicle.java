import java.awt.*;

public abstract class AutoVehicle implements Movable{

    private double enginePower; // Engine power of the vehicle
    private double currentSpeed; // The current speed of the vehicle
    private Color color; // Color of the vehicle
    private String modelName; // The model name of the vehicle
    private Direction direction; //The direction the vehicle has using degrees
    private PointDouble location;   // The position the vehicle has using Java's built-in Point class
    private int turningRadius; //The turning radius of the vehicle
    private double breakFactor; //A factor that determine an arbitrary vehicle's breaking capability
    private boolean engineOn; //A boolean that serves as condition to drive the car
    private int nrDoors;

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

    //All the getters and setters

    /**
     * @return number of doors
     */
    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }


    public double getCurrentSpeed() {
        return currentSpeed;
    }


    public String getModelName(){
        return modelName;
    }

    public PointDouble getLocation(){
        return location;
    }

    public int getDirection(){
        return direction.getDirection();
    }

    public Color getColor() {
        return color;
    }

    public int getTurningRadius(){
        return turningRadius;
    }

    public boolean getEngineOn(){
        return engineOn;
    }

    public void setTurningRadius(int turningRadius){
        this.turningRadius = turningRadius;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void setPosition(PointDouble location){
        this.location = location;
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

    /**
     * Methods for starting or stopping an engine by changing the boolean to true or false.
     */
    public void startEngine() {
        engineOn = true;
    }

    public void stopEngine() {
        engineOn = false;
    }




    /*An abstract concept of which both cars utilize in different ways. Inherited by Volvo
    and saab and its purpose is the implement Volvo's trim and Saab's turbo.*/
    abstract double speedFactor();


    //Increment- and DecrementSpeed increases or decreases the speed based on the current speed.
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - breakFactor * amount,0);
    }

    /**
     * The method gas calls the method incrementSpeed to increase the speed. It purposely sets up boundaries
     * for the amount that you can increaseSpeed and if the conditions are not met an Exception is raised
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
     * The method gas calls the method decrementSpeed to decrease the speed. It purposely sets up boundaries
     * for the amount that you can decreaseSpeed and if the conditions are not met an Exception is raised
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
     * The method move comes from the interface. In Car it uses trigonometry to calculate the new point which the vehicle travels to.
     * It implements currentSpeed combined with the angle of which the car's direction is in
     */
    public void move(){
        double x;
        double y;

        x = location.getX() + Math.cos(Math.toRadians(direction.getDirection())) * currentSpeed;
        y = location.getY() + Math.sin(Math.toRadians(direction.getDirection())) * currentSpeed;

        location.setLocation(x, y);

    }


    /*The methods turnLeft and turnRight is inherited from the interface Movable. They change the direction the car
    is directed in by using the old angle (the car's current direction) combined with the turning radius.
    Whether you turn left or right it is plus or minus. This is based on the unit circle due to the
    previous usage of radians.*/
    public void turnLeft(){
        direction.setDirection(direction.getDirection() + turningRadius);
    }

    public void turnRight(){
        direction.setDirection(direction.getDirection() - turningRadius);
    }


}
