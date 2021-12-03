package Head;

import HelperClasses.Direction;
import HelperClasses.PointDouble;

/**
 * Interface of all movable objects
 */
public interface IMovable {

    /**
     * Method to move this.
     */
    void move();

    /**
     * Method to turn this to the left.
     */
    void turnLeft();

    /**
     * Method to turn this to the right.
     */
    void turnRight();

    /**
     * Method to set this' position.
     * @param location new coordinates of this
     */
    void setPosition(PointDouble location);

    /**
     * Method to set direction of this.
     * @param direction new direction of this
     */
    void setDirection(Direction direction);

}
