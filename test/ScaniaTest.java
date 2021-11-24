import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ScaniaTest {
    Scania testScania = new Scania();

    @Test
    void move_should_change_position_if_car_has_a_speed() {
        testScania.startEngine();
        testScania.gas(0.5);
        testScania.move();
        assertEquals(102,testScania.getLocation().getX());
        assertEquals(100.0, testScania.getLocation().getY());
    }

    @Test
    void lowering_platform_should_not_work_while_moving(){
        testScania.startEngine();
        testScania.gas(0.5);
        testScania.lowerPlatform();
        assertFalse(testScania.isPlatformFullyOpen());
    }

    @Test
    void lowering_platform_then_using_gas_should_not_move_Car(){
        testScania.startEngine();
        testScania.lowerPlatform();
        testScania.gas(0.5);
        assertEquals(100.0,testScania.getLocation().getX());
        assertEquals(100.0, testScania.getLocation().getY());
    }


}

