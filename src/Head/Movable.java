package Head;

import HelperClasses.Direction;
import HelperClasses.PointDouble;

public interface Movable {

    void move();

    void turnLeft();

    void turnRight();

    void setPosition(PointDouble location);

    void setDirection(Direction direction);

}
