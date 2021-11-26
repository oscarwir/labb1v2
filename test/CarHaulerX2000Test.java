import Trucks.CarHaulerX2000;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarHaulerX2000Test {
    //A new object that serves as a subject for our tests
    CarHaulerX2000 testCarHaulerX2000= new CarHaulerX2000();

    @Test
    void move_should_change_position_if_car_has_a_speed() {
        testCarHaulerX2000.startEngine();
        testCarHaulerX2000.gas(0.5);
        testCarHaulerX2000.move();
        assertEquals(202,testCarHaulerX2000.getLocation().getX());
        assertEquals(100.0, testCarHaulerX2000.getLocation().getY());
    }

    @Test
    void lowering_platform_should_not_work_while_moving(){
        testCarHaulerX2000.startEngine();
        testCarHaulerX2000.gas(0.5);
        testCarHaulerX2000.lowerPlatform();
        assertFalse(testCarHaulerX2000.isPlatformFullyOpen());
    }

    @Test
    void lowering_platform_then_using_gas_should_not_move_Car(){
        testCarHaulerX2000.startEngine();
        testCarHaulerX2000.lowerPlatform();
        testCarHaulerX2000.gas(0.5);
        assertEquals(200.0,testCarHaulerX2000.getLocation().getX());
        assertEquals(100.0, testCarHaulerX2000.getLocation().getY());
    }



}