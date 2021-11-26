import Trucks.CarHaulerX2000;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarHaulerX2000CargoPlatformTest {

    CarHaulerX2000 testCarHaulerX2000= new CarHaulerX2000();

    @Test
    void is_platform_closed_should_initially_return_true(){
        assertTrue(testCarHaulerX2000.isPlatformClosed());
    }

    @Test
    void is_platform_fully_open_should_initially_return_false(){
        assertFalse(testCarHaulerX2000.isPlatformFullyOpen());
    }

    @Test
    void lower_platform_should_give_angle_value_120_and_be_compatible_with_platform_closed_and_open(){
        testCarHaulerX2000.lowerPlatform();
        assertFalse(testCarHaulerX2000.isPlatformClosed());
        assertTrue(testCarHaulerX2000.isPlatformFullyOpen());
    }

    @Test
    void raise_platform_should_give_angle_value_120_and_be_compatible_with_platform_closed_and_open(){
        testCarHaulerX2000.raisePlatform();
        assertTrue(testCarHaulerX2000.isPlatformClosed());
        assertFalse(testCarHaulerX2000.isPlatformFullyOpen());
    }
}
