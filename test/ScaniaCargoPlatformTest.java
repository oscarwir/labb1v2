import Cars.Saab95;
import Cars.Volvo240;
import HelperClasses.PointDouble;
import Trucks.CarHaulerX2000;
import Trucks.Scania;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScaniaCargoPlatformTest {

    Scania testScania = new Scania();
    Saab95 testSaab = new Saab95();

    @Test
    void is_platform_closed_should_initially_return_true(){
        assertTrue(testScania.isPlatformClosed());
    }

    @Test
    void is_platform_fully_open_should_initially_return_false(){
        assertFalse(testScania.isPlatformFullyOpen());
    }

    @Test
    void lower_platform_should_give_angle_value_120_and_be_compatible_with_platform_closed_and_open(){
        testScania.lowerPlatform();
        assertFalse(testScania.isPlatformClosed());
        assertTrue(testScania.isPlatformFullyOpen());
    }

    @Test
    void raise_platform_should_give_angle_value_120_and_be_compatible_with_platform_closed_and_open(){
        testScania.raisePlatform();
        assertTrue(testScania.isPlatformClosed());
        assertFalse(testScania.isPlatformFullyOpen());
    }

}
