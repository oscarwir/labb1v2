import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class PointSetTest {

    PointDouble testPoint = new PointDouble(100, 100);


    @Test
    void if_we_set_the_locations_x_axis_to_125_and_y_axis_to_115_it_should_return_125_in_x_axis(){
        testPoint.setLocation(125, 115);
        assertEquals(125, testPoint.getX());
    }

    @Test
    void if_we_set_the_locations_x_axis_to_125_and_y_axis_to_115_it_should_return_125_in_y_axis(){
        testPoint.setLocation(130, 140);
        assertEquals(140, testPoint.getY());
    }



}
