import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Saab95Test {
    Car testSaab = new Saab95();

    @Test
    void increment_speed_should_increase_car_speed() {
        testSaab.incrementSpeed(0.5);
        assertEquals(0.85, testSaab.getCurrentSpeed());
    }


    @Test
    void increment_speed_should_not_decrease_car_speed() {
        double oldspeed = testSaab.getCurrentSpeed();
        testSaab.incrementSpeed(0.5);
        assertEquals( true,oldspeed < testSaab.getCurrentSpeed());
    }

    @Test
    void increment_speed_should_not_increase_car_speed_if_given_amount_is_zero() {
        testSaab.incrementSpeed(0);
        assertEquals(0, testSaab.getCurrentSpeed());
    }

    @Test
    void decrement_speed_should_decrease_speed() {
        testSaab.decrementSpeed(0.5);
        assertEquals(-0.85, testSaab.getCurrentSpeed());
    }

    @Test
    void decrement_speed_should_not_increase_speed() {
        double oldSpeed = testSaab.getCurrentSpeed();
        testSaab.decrementSpeed(0.5);
        assertEquals(true, oldSpeed > testSaab.getCurrentSpeed());
    }

    @Test
    void decrement_speed_should_not_decrease_speed_if_given_amount_is_zero() {
        testSaab.decrementSpeed(0);
        assertEquals(0, testSaab.getCurrentSpeed());
    }


}
