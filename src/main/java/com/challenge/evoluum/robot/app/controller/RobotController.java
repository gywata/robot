package com.challenge.evoluum.robot.app.controller;

import com.challenge.evoluum.robot.app.domain.Robot;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class RobotController {

    @PostMapping("/mars")
    String move(@RequestBody String movement) {
        Robot robot = new Robot();
        return robot.move(movement);
    }
}
