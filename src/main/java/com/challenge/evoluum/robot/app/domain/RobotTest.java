package com.challenge.evoluum.robot.app.domain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RobotTest {

    @Test
    public void robotTestValidPostion1() {
        Robot robot = new Robot();
        assertEquals(robot.move("MMRMMRMM"), "(2, 0, S)");
    }

    @Test
    public void robotTestValidPosition2() {
        Robot robot = new Robot();
        assertEquals(robot.move("MML"), "(0, 2, W)");
    }

    @Test
    public void robotInvalidInput() {
        Robot robot = new Robot();
        assertEquals(robot.move("AAA"), "400 Bad Request");
    }

    @Test
    public void robotInvalidPosition() {
        Robot robot = new Robot();
        assertEquals(robot.move("MMMMMMMMMMMMMMMMM"), "400 Bad Request");
    }


}
