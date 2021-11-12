import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Volvo240Test {

    Volvo240 testVolvo = new Volvo240();


    @Test
    void gas_should_increase_car_speed() {
        testVolvo.gas(0.5);
        assertEquals(0.9375, testVolvo.getCurrentSpeed());
    }

    @Test
    void gas_should_not_decrease_car_speed() {
        double oldSpeed = testVolvo.getCurrentSpeed();
        testVolvo.gas(0.5);
        assertTrue(oldSpeed < testVolvo.getCurrentSpeed());
    }

    @Test
    void gas_should_not_increase_car_speed_if_given_amount_is_zero() {
        testVolvo.gas(0);
        assertEquals(0, testVolvo.getCurrentSpeed());
    }

    @Test
    void brake_should_decrease_speed() {
        testVolvo.gas(0.5);
        testVolvo.brake(19.0/30);
        assertEquals(0, testVolvo.getCurrentSpeed());
    }

    @Test
    void brake_should_not_increase_speed() {
        double oldSpeed = testVolvo.getCurrentSpeed();
        testVolvo.brake(0.5);
        assertTrue(oldSpeed >= testVolvo.getCurrentSpeed());
    }

    @Test
    void brake_should_not_decrease_speed_if_given_amount_is_zero() {
        testVolvo.brake(0);
        assertEquals(0, testVolvo.getCurrentSpeed());
    }

    @Test
    void move_should_chance_position_according_to_dir_and_speed(){

        testVolvo.gas(1.0);
        double speed = testVolvo.getCurrentSpeed();

        double old_x = testVolvo.getLocation().getX();
        double old_y = testVolvo.getLocation().getY();

        testVolvo.move();

        double new_x = testVolvo.getLocation().getX();
        double new_y = testVolvo.getLocation().getY();


        assertEquals(old_x - speed, new_x);
        assertEquals(old_y, new_y);

    }

    @Test
    void turnLeft_should_change_direction(){
        Direction testDirection = new Direction(200);
        testVolvo.turnLeft();
        assertEquals(testDirection.getDirection(), testVolvo.getDirection().getDirection());
    }

    @Test
    void turnRight_should_change_direction(){
        Direction testDirection = new Direction(160);
        testVolvo.turnRight();
        assertEquals(testDirection.getDirection(), testVolvo.getDirection().getDirection());
    }
}