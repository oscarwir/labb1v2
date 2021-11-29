import Cars.Saab95;
import Cars.Volvo240;
import HelperClasses.PointDouble;
import Trucks.CarHaulerX2000;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarHaulerX2000CargoPlatformTest {

    CarHaulerX2000 testCarHaulerX2000 = new CarHaulerX2000();
    Saab95 testSaab = new Saab95();
    Volvo240 testVolvo = new Volvo240();

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

        //They are within the correct distance of each other
        testCarHaulerX2000.setPosition(new PointDouble(100, 100));
        testSaab.setPosition(new PointDouble(99,99));

        testCarHaulerX2000.lowerPlatform();

        testCarHaulerX2000.loadCargo(testSaab);
        testCarHaulerX2000.unloadCargo();

        assertEquals(0, testCarHaulerX2000.getCargo().size());
        assertEquals(80, testSaab.getLocation().getX());
    }

    @Test
    void unload_cargo_should_not_operate_during_incorrect_circumstances(){
        testCarHaulerX2000.setPosition(new PointDouble(100, 100));
        testSaab.setPosition(new PointDouble(99,99));

        testCarHaulerX2000.raisePlatform();

        testCarHaulerX2000.loadCargo(testSaab);
        testCarHaulerX2000.unloadCargo();

        assertEquals(0, testCarHaulerX2000.getCargo().size());
        assertEquals(99, testSaab.getLocation().getX());

    }

    @Test
    void load_cargo_should_load_given_object_type_car(){
        testCarHaulerX2000.setPosition(new PointDouble(100, 100));
        testSaab.setPosition(new PointDouble(99,99));

        testCarHaulerX2000.lowerPlatform();

        testCarHaulerX2000.loadCargo(testSaab);

        assertEquals(1, testCarHaulerX2000.getCargo().size());

    }

    @Test
    void load_cargo_should_not_given_object_type_truck(){
        testCarHaulerX2000.setPosition(new PointDouble(100, 100));
        testSaab.setPosition(new PointDouble(99,99));

        testCarHaulerX2000.lowerPlatform();

        testCarHaulerX2000.loadCargo(testCarHaulerX2000);

        assertEquals(0, testCarHaulerX2000.getCargo().size());


    }

    @Test
    void objects_on_platform_should_have_same_position_as_truck(){
        testCarHaulerX2000.setPosition(new PointDouble(100, 100));
        testSaab.setPosition(new PointDouble(99, 99));
        testVolvo.setPosition((new PointDouble(101, 101)));

        testCarHaulerX2000.lowerPlatform();
        testCarHaulerX2000.loadCargo(testSaab);
        testCarHaulerX2000.loadCargo(testVolvo);

        testCarHaulerX2000.turnRight();
        testCarHaulerX2000.turnLeft();
        testCarHaulerX2000.turnRight();
        testCarHaulerX2000.move();

        assertEquals(testCarHaulerX2000.getLocation(), testSaab.getLocation());
        assertEquals(testCarHaulerX2000.getLocation(), testVolvo.getLocation());

    }

    @Test
    void objects_on_platform_should_have_same_direction_as_truck(){
        testCarHaulerX2000.setPosition(new PointDouble(100, 100));
        testSaab.setPosition(new PointDouble(99, 99));
        testVolvo.setPosition(new PointDouble(101, 101));

        testCarHaulerX2000.lowerPlatform();
        testCarHaulerX2000.loadCargo(testSaab);
        testCarHaulerX2000.loadCargo(testVolvo);

        testCarHaulerX2000.turnRight();
        testCarHaulerX2000.turnLeft();
        testCarHaulerX2000.turnRight();
        testCarHaulerX2000.move();

        assertEquals(testCarHaulerX2000.getDirection(), testSaab.getDirection());
        assertEquals(testCarHaulerX2000.getDirection(), testVolvo.getDirection());

    }

    @Test
    void method_load_car_should_operate_correctly_given_the_right_circumstances(){
        testCarHaulerX2000.setPosition(new PointDouble(100, 100));
        testSaab.setPosition(new PointDouble(99, 99));
        testVolvo.setPosition(new PointDouble(101, 101));

        testCarHaulerX2000.lowerPlatform();
        testCarHaulerX2000.loadCargo(testSaab);
        testCarHaulerX2000.loadCargo(testVolvo);
        testCarHaulerX2000.loadCargo(testVolvo);

        assertEquals(3, testCarHaulerX2000.getCargo().size());
    }

    @Test
    void method_load_car_should_not_operate_given_too_many_objects(){
        testCarHaulerX2000.setPosition(new PointDouble(100, 100));
        testSaab.setPosition(new PointDouble(100, 100));

        testCarHaulerX2000.lowerPlatform();
        testCarHaulerX2000.loadCargo(testSaab);
        testCarHaulerX2000.loadCargo(testSaab);
        testCarHaulerX2000.loadCargo(testSaab);
        testCarHaulerX2000.loadCargo(testSaab);
        testCarHaulerX2000.loadCargo(testSaab);
        testCarHaulerX2000.loadCargo(testSaab);
        testCarHaulerX2000.loadCargo(testSaab);

        assertEquals(6, testCarHaulerX2000.getCargo().size());

    }

    @Test
    void method_load_car_should_not_operate_if_distance_between_objects_is_too_great(){
        testCarHaulerX2000.setPosition(new PointDouble(100, 100));
        testSaab.setPosition(new PointDouble(200, 100));

        testCarHaulerX2000.lowerPlatform();
        testCarHaulerX2000.loadCargo(testSaab);
        assertEquals(0, testCarHaulerX2000.getCargo().size());

    }

    @Test
    void get_unloaded_position_after_movement_should_result_in_the_right_position(){
        testCarHaulerX2000.setPosition(new PointDouble(100, 100));
        testSaab.setPosition(new PointDouble(101, 101));

        testCarHaulerX2000.lowerPlatform();
        testCarHaulerX2000.loadCargo(testSaab);

        testCarHaulerX2000.move();
        testCarHaulerX2000.move();

        testCarHaulerX2000.unloadCargo();

        assertEquals(100 + (Math.cos(Math.toRadians(testCarHaulerX2000.getDirection() + 180)) * 20), testSaab.getLocation().getX());
        assertEquals(100 + (Math.sin(Math.toRadians(testCarHaulerX2000.getDirection() + 180)) * 20), testSaab.getLocation().getY());
    }

    @Test
    void get_unloaded_position_should_result_in_the_right_position_with_angle(){
        testCarHaulerX2000.setPosition(new PointDouble(100, 100));
        testSaab.setPosition(new PointDouble(101, 101));

        testCarHaulerX2000.lowerPlatform();
        testCarHaulerX2000.loadCargo(testSaab);

        testCarHaulerX2000.turnRight();
        testCarHaulerX2000.turnLeft();
        testCarHaulerX2000.turnLeft();

        testCarHaulerX2000.unloadCargo();

        assertEquals(100 + (Math.cos(Math.toRadians(testCarHaulerX2000.getDirection() + 180)) * 20), testSaab.getLocation().getX());
        assertEquals(100 + (Math.sin(Math.toRadians(testCarHaulerX2000.getDirection() + 180)) * 20), testSaab.getLocation().getY());
    }
}
