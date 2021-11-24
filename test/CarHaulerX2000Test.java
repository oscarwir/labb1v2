import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.core.ColumnOrderDependent;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CarHaulerX2000Test {
    //A new object that serves as a subject for our tests
    CarHaulerX2000 tesCarHaulerX2000= new CarHaulerX2000();

    @Test
    void move_should_change_position_if_car_has_a_speed() {
        tesCarHaulerX2000.startEngine();
        tesCarHaulerX2000.gas(0.5);
        tesCarHaulerX2000.move();
        assertEquals(202,tesCarHaulerX2000.getLocation().getX());
        assertEquals(100.0, tesCarHaulerX2000.getLocation().getY());
    }

    @Test
    void lowering_platform_should_not_work_while_moving(){
        tesCarHaulerX2000.startEngine();
        tesCarHaulerX2000.gas(0.5);
        tesCarHaulerX2000.lowerPlatform();
        assertFalse(tesCarHaulerX2000.isPlatformFullyOpen());
    }

    @Test
    void lowering_platform_then_using_gas_should_not_move_Car(){
        tesCarHaulerX2000.startEngine();
        tesCarHaulerX2000.lowerPlatform();
        tesCarHaulerX2000.gas(0.5);
        assertEquals(100.0,tesCarHaulerX2000.getLocation().getX());
        assertEquals(100.0, tesCarHaulerX2000.getLocation().getY());
    }



}