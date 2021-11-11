import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Saab95Test {
    Saab95 testSaab = new Saab95();

    @Test
    void setTurboOn_should_enable_turbo() {
        testSaab.setTurboOn();
        assertTrue(testSaab.turboOn);
    }

    @Test
    void setTurboOff_should_disable_turbo() {
        testSaab.setTurboOn();
        testSaab.setTurboOff();
        assertFalse(testSaab.turboOn);
    }

    @Test
    void increment_speed_should_increase_car_speed() {
        testSaab.incrementSpeed(0.5);
        assertEquals(0.85, testSaab.getCurrentSpeed());
    }

    @Test
    void increment_speed_should_not_decrease_car_speed() {
        double oldSpeed = testSaab.getCurrentSpeed();
        testSaab.incrementSpeed(0.5);
        assertTrue(oldSpeed < testSaab.getCurrentSpeed());
    }

    @Test
    void increment_speed_should_not_increase_car_speed_if_given_amount_is_zero() {
        testSaab.incrementSpeed(0);
        assertEquals(0, testSaab.getCurrentSpeed());
    }

    @Test
    void decrement_speed_should_decrease_speed() {
        testSaab.decrementSpeed(0.5);
        assertEquals(0, testSaab.getCurrentSpeed());
    }

    @Test
    void decrement_speed_should_not_increase_speed() {
        double oldSpeed = testSaab.getCurrentSpeed();
        testSaab.decrementSpeed(0.5);
        assertTrue(oldSpeed >= testSaab.getCurrentSpeed());
    }

    @Test
    void decrement_speed_should_not_decrease_speed_if_given_amount_is_zero() {
        testSaab.decrementSpeed(0);
        assertEquals(0, testSaab.getCurrentSpeed());
    }

    // Same tests as above but with turbo enabled

    @Test
    void increment_speed_should_increase_car_speed_with_turbo() {
        testSaab.setTurboOn();
        testSaab.incrementSpeed(0.5);
        assertEquals(1.105, testSaab.getCurrentSpeed());
    }

    @Test
    void increment_speed_should_not_decrease_car_speed_with_turbo() {
        testSaab.setTurboOn();
        double oldspeed = testSaab.getCurrentSpeed();
        testSaab.incrementSpeed(0.5);
        assertTrue(oldspeed < testSaab.getCurrentSpeed());
    }

    @Test
    void increment_speed_should_not_increase_car_speed_if_given_amount_is_zero_with_turbo() {
        testSaab.setTurboOn();
        testSaab.incrementSpeed(0);
        assertEquals(0, testSaab.getCurrentSpeed());
    }

    @Test
    void decrement_speed_should_decrease_speed_with_turbo() {
        testSaab.setTurboOn();
        testSaab.decrementSpeed(0.5);
        assertEquals(0, testSaab.getCurrentSpeed());
    }

    @Test
    void decrement_speed_should_not_increase_speed_with_turbo() {
        testSaab.setTurboOn();
        double oldSpeed = testSaab.getCurrentSpeed();
        testSaab.decrementSpeed(0.5);
        assertTrue(oldSpeed >= testSaab.getCurrentSpeed());
    }

    @Test
    void decrement_speed_should_not_decrease_speed_if_given_amount_is_zero_with_turbo() {
        testSaab.setTurboOn();
        testSaab.decrementSpeed(0);
        assertEquals(0, testSaab.getCurrentSpeed());
    }

}
