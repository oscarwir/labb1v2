import Trucks.Scania;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScaniaCargoPlatformTest {

    //The platform is attached to the truck
    Scania testScania = new Scania();


    @Test
    void is_platform_closed_should_initially_return_true(){
        assertTrue(testScania.isPlatformClosed());
    }

    @Test
    void is_platform_fully_open_should_initially_return_false(){
        assertFalse(testScania.isPlatformFullyOpen());
    }

    @Test
    void raise_platform_should_in_14_steps_result_in_a_fully_opened(){
        for(int i = 0; i < 14; i++){
            testScania.raisePlatform();
        }

        assertFalse(testScania.isPlatformClosed());
        assertTrue(testScania.isPlatformFullyOpen());
    }

    @Test
    void raise_platform_should_in_14_steps_followed_by_lowered_14_steps_should_result_in_fully_closed(){
        for(int i = 0; i < 14; i++){
            testScania.raisePlatform();
        }

        for(int i = 0; i < 14; i++){
            testScania.lowerPlatform();
        }


        assertTrue(testScania.isPlatformClosed());
        assertFalse(testScania.isPlatformFullyOpen());
    }

    @Test
    void raise_platform_halfway_should_return_false_in_both_platform_closed_and_open(){

        testScania.raisePlatform();
        testScania.raisePlatform();

        assertFalse(testScania.isPlatformClosed());
        assertFalse(testScania.isPlatformFullyOpen());

    }


    @Test
    void raise_platform_during_movement_should_result_in_closed(){

        testScania.startEngine();
        testScania.gas(1);
        for(int i = 0; i < 14; i++){
            testScania.raisePlatform();
        }

        assertTrue(testScania.isPlatformClosed());
        assertFalse(testScania.isPlatformFullyOpen());


    }

    @Test
    void raise_platform_14_times_during_movement_followed_by_one_lower_should_result_in_fully_closed(){
        testScania.startEngine();
        testScania.gas(1);

        for(int i = 0; i < 14; i++){
            testScania.raisePlatform();
        }

        testScania.lowerPlatform();

        assertTrue(testScania.isPlatformClosed());
        assertFalse(testScania.isPlatformFullyOpen());

    }

    @Test
    void raise_platform_more_than_14_times_should_still_result_in_70_degrees(){
        testScania.startEngine();

        for(int i = 0; i < 17; i++){
            testScania.raisePlatform();
        }

        assertTrue(testScania.isPlatformFullyOpen());
    }

    @Test
    void get_cargo_should_return_empty_array(){
        assertEquals(0, testScania.getCargo().size());
    }

}
