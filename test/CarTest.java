import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    Car testSaab = new Saab95();
    Car testVolvo = new Volvo240();

    @Test
    void increment_speed_should_increase_car_speed_saab_version() {
        assertEquals(0, testSaab.getCurrentSpeed());
        testSaab.incrementSpeed(0.5);
        assertEquals(0.625, testSaab.getCurrentSpeed());
    }

    @Test
    void increment_speed_should_not_decrease_car_speed_saab_version() {

    }

    @Test
    void increment_speed_should_not_increase_car_speed_if_not_accelerating_saab_version() {

    }


}
