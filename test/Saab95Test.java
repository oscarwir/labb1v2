import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.*;

public class Saab95Test {
    Saab95 testSaab = new Saab95();

    @Test
    void engine_should_be_off_as_default(){
        assertFalse(testSaab.getEngineOn());
    }

    @Test
    void startEngine_should_start_the_engine(){
        testSaab.startEngine();
        assertTrue(testSaab.getEngineOn());
    }

    @Test
    void engineStop_should_stop_engine_if_on(){
        testSaab.startEngine();
        testSaab.stopEngine();
        assertFalse(testSaab.getEngineOn());
    }

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
        testSaab.startEngine();
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
        testSaab.startEngine();
        testSaab.gas(0);
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

    @Test
    void move_should_change_position_if_car_has_a_speed() {
        testSaab.startEngine();
        testSaab.gas(0.5);
        testSaab.move();
        assertEquals(100.85,testSaab.getLocation().getX());
        assertEquals(100.0, testSaab.getLocation().getY());
    }

    @Test
    void move_should_not_change_position_if_car_has_no_speed() {
        PointDouble oldPoint = testSaab.getLocation();
        testSaab.move();
        assertEquals(oldPoint, testSaab.getLocation());
    }

    @Test
    void turnLeft_should_change_direction(){
        Direction testDirection = new Direction(10);
        testSaab.turnLeft();
        assertEquals(testDirection.getDirection(), testSaab.getDirection());
    }

    @Test
    void turnRight_should_change_direction(){
        Direction testDirection = new Direction(-10);
        testSaab.turnRight();
        assertEquals(testDirection.getDirection(), testSaab.getDirection());
    }

    @Test
    void move_after_turnLeft_should_move_correctly() {
        //Setup
        testSaab.startEngine();
        //Save the old coordinates in two variables.
        double old_x = testSaab.getLocation().getX();
        double old_y = testSaab.getLocation().getY();

        //Turn left and then turn with the
        testSaab.turnLeft();
        testSaab.move();

        //Then we load the new variables after the movement in two new variables.
        double new_x = testSaab.getLocation().getX();
        double new_y = testSaab.getLocation().getY();

        //With trigonometry the new coordinates are manually calculated.
        double deltaY = Math.sin(Math.toRadians(testSaab.getDirection())) * testSaab.getCurrentSpeed();
        double deltaX = Math.cos(Math.toRadians(testSaab.getDirection())) * testSaab.getCurrentSpeed();

        //The comparison between the coordinates that our program calculated vs the manually calculated coordinates.
        assertEquals(old_x + deltaX, new_x);
        assertEquals(old_y + deltaY, new_y);
    }

    @Test
    void move_after_turnRight_should_move_correctly() {
        testSaab.startEngine();
        double old_x = testSaab.getLocation().getX();
        double old_y = testSaab.getLocation().getY();

        testSaab.turnRight();
        testSaab.move();

        double new_x = testSaab.getLocation().getX();
        double new_y = testSaab.getLocation().getY();

        double deltaY = Math.sin(Math.toRadians(testSaab.getDirection())) * testSaab.getCurrentSpeed();
        double deltaX = Math.cos(Math.toRadians(testSaab.getDirection())) * testSaab.getCurrentSpeed();

        assertEquals(old_x + deltaX, new_x);
        assertEquals(old_y + deltaY, new_y);
    }

    @Test
    void move_after_turnRight_and_turnLeft_should_cancel_out_direction_without_turbo(){

        testSaab.startEngine();

        double old_x = testSaab.getLocation().getX();
        double old_y = testSaab.getLocation().getY();

        testSaab.turnRight();
        testSaab.turnLeft();
        testSaab.move();

        double new_x = testSaab.getLocation().getX();
        double new_y = testSaab.getLocation().getY();

        double deltaY = Math.sin(Math.toRadians(testSaab.getDirection())) * testSaab.getCurrentSpeed();
        double deltaX = Math.cos(Math.toRadians(testSaab.getDirection())) * testSaab.getCurrentSpeed();

        assertEquals(old_x + deltaX, new_x);
        assertEquals(old_y + deltaY, new_y);
    }


    // Same tests as above but with turbo enabled

    @Test
    void gas_should_increase_car_speed_with_turbo() {
        testSaab.startEngine();
        testSaab.setTurboOn();
        testSaab.gas(0.5);
        assertEquals(1.105, testSaab.getCurrentSpeed());
    }

    @Test
    void gas_should_not_decrease_car_speed_with_turbo() {
        testSaab.startEngine();
        testSaab.setTurboOn();
        double oldspeed = testSaab.getCurrentSpeed();
        testSaab.gas(0.5);
        assertTrue(oldspeed <= testSaab.getCurrentSpeed());
    }

    @Test
    void gas_should_not_increase_car_speed_if_given_amount_is_zero_with_turbo() {
        testSaab.startEngine();
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

    @Test
    void move_should_change_position_if_car_has_a_speed_with_turbo() {
        testSaab.startEngine();
        testSaab.setTurboOn();
        testSaab.gas(0.5);
        testSaab.move();
        assertEquals(101.105,testSaab.getLocation().getX());
        assertEquals(100.0, testSaab.getLocation().getY());
    }

    @Test
    void move_after_turnLeft_should_move_correctly_with_turbo() {
        //Setup for the test
        testSaab.startEngine();
        testSaab.setTurboOn();

        //We save both the old coordinates before using the method from the interface.
        double old_x = testSaab.getLocation().getX();
        double old_y = testSaab.getLocation().getY();

        testSaab.turnLeft();
        testSaab.move();

        double new_x = testSaab.getLocation().getX();
        double new_y = testSaab.getLocation().getY();

        double deltaY = Math.sin(Math.toRadians(testSaab.getDirection())) * testSaab.getCurrentSpeed();
        double deltaX = Math.cos(Math.toRadians(testSaab.getDirection())) * testSaab.getCurrentSpeed();

        assertEquals(old_x + deltaX, new_x);
        assertEquals(old_y + deltaY, new_y);
    }

    @Test
    void move_after_turnRight_should_move_correctly_with_turbo() {
        testSaab.startEngine();
        testSaab.setTurboOn();

        double old_x = testSaab.getLocation().getX();
        double old_y = testSaab.getLocation().getY();

        testSaab.turnRight();
        testSaab.move();

        double new_x = testSaab.getLocation().getX();
        double new_y = testSaab.getLocation().getY();

        double deltaY = Math.sin(Math.toRadians(testSaab.getDirection())) * testSaab.getCurrentSpeed();
        double deltaX = Math.cos(Math.toRadians(testSaab.getDirection())) * testSaab.getCurrentSpeed();

        assertEquals(old_x + deltaX, new_x);
        assertEquals(old_y + deltaY, new_y);
    }

    @Test
    void move_after_turnRight_and_turnLeft_should_cancel_out_direction_with_turbo(){

        testSaab.startEngine();
        testSaab.setTurboOn();

        double old_x = testSaab.getLocation().getX();
        double old_y = testSaab.getLocation().getY();

        testSaab.turnRight();
        testSaab.turnLeft();
        testSaab.move();

        double new_x = testSaab.getLocation().getX();
        double new_y = testSaab.getLocation().getY();

        double deltaY = Math.sin(Math.toRadians(testSaab.getDirection())) * testSaab.getCurrentSpeed();
        double deltaX = Math.cos(Math.toRadians(testSaab.getDirection())) * testSaab.getCurrentSpeed();

        assertEquals(old_x + deltaX, new_x);
        assertEquals(old_y + deltaY, new_y);
    }


}
