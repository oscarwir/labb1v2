import Cars.Saab95;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoVehicleSetTest {
    //We randomly choose one car to be the subject of our conducted test.
    Saab95 testSaab = new Saab95();

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

}
