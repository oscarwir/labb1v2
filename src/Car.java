import java.awt.*;

public abstract class Car implements Movable{


    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Point location;
    private Direction direction;
    private int turningRadius; //The turning radius of the car

    public Car(String modelName, int turningRadius, Point location, Direction direction, int nrDoors, Color color, int enginePower){
        this.modelName = modelName;
        this.turningRadius = turningRadius;
        this.location = location;
        this.direction = direction;
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        stopEngine();
    }



    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void setCurrentSpeed(double currentSpeed){
        this.currentSpeed = currentSpeed;
    }

    public int getTurningRadius(){
        return turningRadius;
    }

    public void setTurningRadius(int trn){
        turningRadius = trn;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }


    abstract void incrementSpeed(double amount);


    abstract void decrementSpeed(double amount);

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        incrementSpeed(amount);

    }


    // TODO fix this method according to lab pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }

    public void move(){
        double x;
        double y;

        x = location.getX() + Math.cos(direction.getDirection()) * currentSpeed;
        y = location.getY() + Math.sin(direction.getDirection()) * currentSpeed;
        location.setLocation(x, y);

        //Vi kanske borde konstruera en class för koordinater?
    }

    public void turnLeft(){
        if (currentSpeed > 0){
            direction.setDirection(direction.getDirection() + turningRadius);
        }

    }

    public void turnRight(){
        if (currentSpeed > 0){
            direction.setDirection(direction.getDirection() - turningRadius);
        }
    }


}

