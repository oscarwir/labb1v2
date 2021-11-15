import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class PointGetTest {

    //We have to insert start values since we don't have constructor inside class.
    PointDouble testPoint = new PointDouble(100, 100);

    @Test
    void get_x_should_return_value_100(){
        assertEquals(100, testPoint.getX());
    }

    @Test
    void get_y_should_return_value_100(){
        assertEquals(100, testPoint.getY());
    }


}
