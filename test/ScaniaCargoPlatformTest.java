import Cars.Saab95;
import Cars.Volvo240;
import HelperClasses.PointDouble;
import Trucks.CarHaulerX2000;
import Trucks.CargoPlatform;
import Trucks.Scania;
import Trucks.ScaniaCargoPlatform;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScaniaCargoPlatformTest {

    ScaniaCargoPlatform testPlatform = new ScaniaCargoPlatform();


    @Test
    void is_platform_closed_should_initially_return_true(){
        assertTrue(testPlatform.isPlatformClosed());
    }

    @Test
    void is_platform_fully_open_should_initially_return_false(){
        assertFalse(testPlatform.isPlatformFullyOpen());
    }

    @Test
    void lower_platform_should_in_14_steps_result_in_a_fully_opened(){
        for(int i = 0; i < 14; i++){
            testPlatform.lowerPlatform();
        }

        assertFalse(testPlatform.isPlatformClosed());
        assertTrue(testPlatform.isPlatformFullyOpen());
    }

    @Test
    void lower_platform_should_in_14_steps_followed_by_raised_14_steps_should_result_in_fully_closed(){
        for(int i = 0; i < 14; i++){
            testPlatform.lowerPlatform();
        }

        for(int i = 0; i < 14; i++){
            testPlatform.raisePlatform();
        }


        assertTrue(testPlatform.isPlatformClosed());
        assertFalse(testPlatform.isPlatformFullyOpen());
    }

    @Test
    void lower_platform_halfway_should_return_false_in_both_platform_closed_and_open(){

    }


    @Test
    void lower_platform_during_movement_should_not_in_14_steps_result_in_a_fully_opened(){

    }

    @Test
    void raise_platform_during_movement_should_not_in_14_steps_result_in_a_fully_opened(){

    }

}
