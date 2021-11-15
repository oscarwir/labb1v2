import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.core.ColumnOrderDependent;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CarSetTest {
    //We randomly choose one car to be the subject of our conducted test.
    Saab95 testSaab = new Saab95();
    PointDouble testPoint = new PointDouble(100, 100);

    @Test
    void if_we_set_color_to_black_getter_should_return_color_black(){
        testSaab.setColor(Color.black);
        assertEquals(Color.black, testSaab.getColor());
    }

    @Test
    void if_we_set_turning_radius_to_15_getter_should_return_15(){
        testSaab.setTurningRadius(15);
        assertEquals(15, testSaab.getTurningRadius());
    }

    @Test
    void if_we_set_the_locations_x_axis_to_125_and_y_axis_to_115_it_should_return_125_in_x_axis(){
        testPoint.setLocation(125, 115);
        assertEquals(125, testPoint.getX());
    }

    @Test
    void if_we_set_the_locations_x_axis_to_125_and_y_axis_to_115_it_should_return_125_in_y_axis(){
        testPoint.setLocation(125, 115);
        assertEquals(115, testPoint.getY());
    }

}
