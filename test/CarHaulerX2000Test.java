import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.core.ColumnOrderDependent;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CarHaulerX2000Test {
    //We randomly choose one car to be the subject of our conducted test.
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
    void lowering_platform_should_not_work_while_moveing(){
        tesCarHaulerX2000.startEngine();
        tesCarHaulerX2000.gas(0.5);
        tesCarHaulerX2000.lowerPlatform();
        assertEquals(false, tesCarHaulerX2000.isPlatformFullyOpen());
    }

}