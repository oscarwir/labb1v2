package Trucks;

import HelperClasses.Direction;
import HelperClasses.PointDouble;

interface Movable {

    void move();

    void turnLeft();

    void turnRight();

    void setPosition(PointDouble location);

    void setDirection(Direction direction);

}
