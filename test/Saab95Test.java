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
    void gas_should_increase_car_speed() {
        testSaab.gas(0.5);
        assertEquals(0.85, testSaab.getCurrentSpeed());
    }

    @Test
    void gas_should_not_decrease_car_speed() {
        double oldSpeed = testSaab.getCurrentSpeed();
        testSaab.gas(0.5);
        assertTrue(oldSpeed <= testSaab.getCurrentSpeed());
    }

    @Test
    void gas_should_not_increase_car_speed_if_given_amount_is_zero() {
        testSaab.gas(0);
        System.out.println(testSaab.getCurrentSpeed());
        assertEquals(0, testSaab.getCurrentSpeed());
    }

    @Test
    void break_should_decrease_speed() {
        testSaab.brake(0.5);
        assertEquals(0, testSaab.getCurrentSpeed());
    }

    @Test
    void break_should_not_increase_speed() {
        double oldSpeed = testSaab.getCurrentSpeed();
        testSaab.brake(0.5);
        assertTrue(oldSpeed >= testSaab.getCurrentSpeed());
    }

    @Test
    void break_should_not_decrease_speed_if_given_amount_is_zero() {
        testSaab.brake(0);
        assertEquals(0, testSaab.getCurrentSpeed());
    }

    // Same tests as above but with turbo enabled

    @Test
    void gas_should_increase_car_speed_with_turbo() {
        testSaab.setTurboOn();
        testSaab.gas(0.5);
        assertEquals(1.105, testSaab.getCurrentSpeed());
    }

    @Test
    void gas_should_not_decrease_car_speed_with_turbo() {
        testSaab.setTurboOn();
        double oldspeed = testSaab.getCurrentSpeed();
        testSaab.gas(0.5);
        assertTrue(oldspeed <= testSaab.getCurrentSpeed());
    }

    @Test
    void gas_should_not_increase_car_speed_if_given_amount_is_zero_with_turbo() {
        testSaab.setTurboOn();
        testSaab.gas(0);
        assertEquals(0, testSaab.getCurrentSpeed());
    }

    @Test
    void break_should_decrease_speed_with_turbo() {
        testSaab.setTurboOn();
        testSaab.brake(0.5);
        assertEquals(0, testSaab.getCurrentSpeed());
    }

    @Test
    void break_should_not_increase_speed_with_turbo() {
        testSaab.setTurboOn();
        double oldSpeed = testSaab.getCurrentSpeed();
        testSaab.brake(0.5);
        assertTrue(oldSpeed >= testSaab.getCurrentSpeed());
    }

    @Test
    void break_should_not_decrease_speed_if_given_amount_is_zero_with_turbo() {
        testSaab.setTurboOn();
        testSaab.brake(0);
        assertEquals(0, testSaab.getCurrentSpeed());
    }

}
