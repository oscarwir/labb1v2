import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CarGetTest {
    //We randomly choose one car to be the subject of our conducted test.
    Saab95 testSaab = new Saab95();

    @Test
    void get_number_doors_should_return_4(){
        assertEquals(4, testSaab.getNrDoors());
    }

    @Test
    void get_engine_power_should_return_170(){
        assertEquals(170, testSaab.getEnginePower());
    }

    @Test
    void get_current_speed_should_return_0(){
        assertEquals(0, testSaab.getCurrentSpeed());
    }

    @Test
    void get_ModelName_should_return_Saab95(){
        assertEquals("Saab95", testSaab.getModelName());
    }

    @Test
    void get_location_of_x_should_return_start_point_which_is_a_double_with_value_100(){
        assertEquals(100,testSaab.getLocation().getX());
    }

    @Test
    void get_location_of_y_should_return_start_point_which_is_a_double_with_value_100(){
        assertEquals(100,testSaab.getLocation().getY());
    }

    @Test
    void get_direction_should_return_0_degrees(){
        assertEquals(0, testSaab.getDirection());
    }

    @Test
    void get_color_should_return_white(){
        assertEquals(Color.white, testSaab.getColor());
    }

    @Test
    void get_turning_radius_should_return_10(){
        assertEquals(10, testSaab.getTurningRadius());
    }

    @Test
    void get_engine_on_should_return_false(){
        assertFalse(testSaab.getEngineOn());
    }

    //AfterEach uncertain if we must add these, but asked another group and they said
    //it was mandatory...

    //AfterAll

}
