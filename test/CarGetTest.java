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
    void get_color_should_return_white(){
        assertEquals(Color.white, testSaab.getColor());
    }

    @Test
    void get_turning_radius_should_return_10(){
        assertEquals(10, testSaab.getTurningRadius());
    }

}
