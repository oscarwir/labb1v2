import Trucks.CarHaulerX2000;

import Head.*;
import Cars.*;
import HelperClasses.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import Cars.Saab95;

import static org.junit.jupiter.api.Assertions.*;

public class CarHaulerX2000CargoPlatformTest {

    CarHaulerX2000 testCarHaulerX2000 = new CarHaulerX2000();
    Saab95 testSaab = new Saab95();

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

    @Test
    void unload_cargo_should_operate_correctly_given_the_right_circumstances(){
        testCarHaulerX2000.lowerPlatform();
        testCarHaulerX2000.loadCargo(testSaab);
        testCarHaulerX2000.unloadCargo();
        assertEquals(0, testCarHaulerX2000.getCargo().size());
        assertEquals(75, );
    }

    @Test
    void unload_cargo_should_not_operate_during_incorrect_circumstances(){

    }

    @Test
    void load_cargo_should_load_given_object_type_car(){

    }

    @Test
    void load_cargo_should_not_given_object_type_truck(){

    }

    @Test
    void objects_on_truck_should_have_same_position_as_truck(){

    }

    @Test
    void objects_on_truck_should_have_same_direction_as_truck(){

    }

    @Test
    void method_load_car_should_operate_correctly_given_the_right_circumstances(){

    }

    @Test
    void method_load_car_should_not_operate_at_all_given_wrong_circumstances(){

    }

    @Test
    void get_unloaded_position_should_result_in_the_right_position(){

    }
}
