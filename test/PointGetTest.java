import HelperClasses.PointDouble;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PointGetTest {

    //We have to insert start values since we don't have constructor inside class.
    PointDouble testPoint = new PointDouble(100, 100);
    PointDouble testPoint2 = new PointDouble(200, 100);
    PointDouble testPoint3 = new PointDouble(100, 200);
    PointDouble testPoint4 = new PointDouble(200, 200);

    @Test
    void get_x_should_return_value_100(){
        assertEquals(100, testPoint.getX());
    }

    @Test
    void get_y_should_return_value_100(){
        assertEquals(100, testPoint.getY());
    }

    @Test
    void get_distance_between_points_should_return_correct_value() {
        assertEquals(100,testPoint.getDistanceBetweenPoints(testPoint2));
        assertEquals(100,testPoint.getDistanceBetweenPoints(testPoint3));
        assertEquals(Math.sqrt(20000),testPoint.getDistanceBetweenPoints(testPoint4));
    }

}
