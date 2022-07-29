package com.iress.robot.commands;

import com.iress.robot.model.Direction;
import com.iress.robot.model.Robot;
import lombok.Getter;

@Getter
public class PlaceCommand implements ParameterisedCommand {
    private Integer xPos;
    private Integer yPos;
    private Direction direction;

    @Override
    public void setParameters(String params) {
        String[] split = params.split(",");

        xPos = Integer.valueOf(split[0]);
        yPos = Integer.valueOf(split[1]);
        direction = Direction.valueOf(split[2]);
    }

    @Override
    public void execute(Robot robot) {
        if (xPos > Robot.MAX_X || yPos > Robot.MAX_Y || xPos < 0 || yPos < 0) {
            System.out.println("Robot will fall! Command ignored.");
        } else {
            robot.setXPos(xPos);
            robot.setYPos(yPos);
            robot.setDirection(direction);
        }

    }
}
