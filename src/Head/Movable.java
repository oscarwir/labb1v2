package Head;

import HelperClasses.Direction;
import HelperClasses.PointDouble;

/**
 *
 */
public interface Movable {

    /**
     *
     */
    void move();

    /**
     *
     */
    void turnLeft();

    /**
     *
     */
    void turnRight();

    /**
     * @param location
     */
    void setPosition(PointDouble location);

    /**
     * @param direction
     */
    void setDirection(Direction direction);

}
