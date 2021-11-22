import javax.xml.stream.Location;
import java.awt.*;

interface Movable {

    void move();

    void turnLeft();

    void turnRight();

    void setPosition(PointDouble location);

    void setDirection(Direction direction);

}
