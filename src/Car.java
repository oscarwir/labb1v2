import java.awt.*;

public abstract class Car implements Movable{


    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Direction direction; //The direction the car has using degrees
    private PointDouble location;   // The position the car has using Java's built-in Point class
    private int turningRadius; //The turning radius of the car
    private double breakFactor; //A factor that determine an arbitrary car's breaking capability


    //A constructor for all the declared variables above
    public Car(String modelName, int turningRadius, PointDouble location, Direction direction, int nrDoors, Color color, int enginePower, double brakeFactor){
        this.modelName = modelName;
        this.turningRadius = turningRadius;
        this.location = location;
        this.direction = direction;
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.breakFactor = brakeFactor;
        stopEngine();
    }


    //All the getters and setters

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

    public void setColor(Color clr) {
        color = clr;
    }

    public int getTurningRadius(){
        return turningRadius;
    }

    public void setTurningRadius(int turningRadius){
        this.turningRadius = turningRadius;
    }


    //Methods for starting or stopping an engine by giving currentSpeed a value
    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    //An abstract concept of which both cars utilize in different ways
    abstract double speedFactor();




    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - breakFactor * amount,0);
    }



    public void gas(double amount) {
       if (amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        }
       else {
           throw new IllegalArgumentException("Gas amount is lower than 0 or higher than 1");
       }
    }



    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
        else {
            throw new IllegalArgumentException("break amount is lower than 0 or higer than 1");
        }
    }

    public void move(){
        double x;
        double y;

        x = location.getX() + Math.cos(Math.toRadians(direction.getDirection())) * currentSpeed;
        y = location.getY() + Math.sin(Math.toRadians(direction.getDirection())) * currentSpeed;


        location.setLocation(x, y);


    }

    public void turnLeft(){
        direction.setDirection(direction.getDirection() + turningRadius);
    }

    public void turnRight(){
        direction.setDirection(direction.getDirection() - turningRadius);
    }


}

