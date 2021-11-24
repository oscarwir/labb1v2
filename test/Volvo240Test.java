import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.geom.Point2D;

public class Volvo240Test {

    Volvo240 testVolvo = new Volvo240();


    @Test
    void gas_should_increase_car_speed() {
        testVolvo.startEngine();
        testVolvo.gas(0.5);
        assertEquals(0.9375, testVolvo.getCurrentSpeed());
    }

    @Test
    void gas_should_not_decrease_car_speed() {
        testVolvo.startEngine();
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
        testVolvo.startEngine();
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
        //This is the setup.
        testVolvo.startEngine();
        testVolvo.gas(1.0);
        double speed = testVolvo.getCurrentSpeed();

        //We save both old coordinates before using the interface.
        double old_x = testVolvo.getLocation().getX();
        double old_y = testVolvo.getLocation().getY();

        //By using the interface change the position of the vehicle
        testVolvo.move();

        //We save the new coordinates in two new variables.
        double new_x = testVolvo.getLocation().getX();
        double new_y = testVolvo.getLocation().getY();

        //Now we can compare the new with the old coordinates to see if the movement of the car matches
        //its new position. Since the car starts off in the direction of the x-coordinate the movement is
        //rather simple and we can exclude differences in the y-axis.
        assertEquals(old_x - speed, new_x);
        assertEquals(old_y, new_y);

        //Now we test out the interfaces turn left and turn right. By using one of them two times
        //we're able to simplify the test and try them both out at one instance.
        testVolvo.turnLeft();
        testVolvo.turnLeft();
        testVolvo.turnRight();

        old_x = testVolvo.getLocation().getX();
        old_y = testVolvo.getLocation().getY();

        testVolvo.move();

        new_x = testVolvo.getLocation().getX();
        new_y = testVolvo.getLocation().getY();

        //Since we used the turnLeft interface twice the resulting position is calculated
        //with trigonometry. In this instance both the x- and the y-axis is calculated, in
        //contrast with the earlier instance.
        double deltaY = Math.sin(Math.toRadians(testVolvo.getDirection())) * speed;
        double deltaX = Math.cos(Math.toRadians(testVolvo.getDirection())) * speed;

        assertEquals(old_x + deltaX, new_x);
        assertEquals(old_y + deltaY, new_y);

    }

    @Test
    void turnLeft_should_change_direction(){
        Direction testDirection = new Direction(200);
        testVolvo.turnLeft();
        assertEquals(testDirection.getDirection(), testVolvo.getDirection());
    }

    @Test
    void turnRight_should_change_direction(){
        Direction testDirection = new Direction(160);
        testVolvo.turnRight();
        assertEquals(testDirection.getDirection(), testVolvo.getDirection());
    }

    @Test
    void engine_off_should_not_be_able_to_increase_speed(){
        testVolvo.startEngine();
        testVolvo.gas(1.0);

        double oldSpeed = testVolvo.getCurrentSpeed();

        testVolvo.stopEngine();

        testVolvo.gas(1.0);

        double newSpeed = testVolvo.getCurrentSpeed();

        assertEquals(oldSpeed, newSpeed);

    }
}