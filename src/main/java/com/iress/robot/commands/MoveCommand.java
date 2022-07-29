package com.iress.robot.commands;

import com.iress.robot.model.Robot;

public class MoveCommand implements Command {
    @Override
    public void execute(Robot robot) {
        if (robot.isOnTable()) {
            switch (robot.getDirection()) {
                case NORTH:
                    if (robot.getYPos() < Robot.MAX_Y) {
                        robot.moveY(1);
                    } else {
                        System.out.println("Robot will fall! Command ignored.");
                    }
                    break;
                case EAST:
                    if (robot.getXPos() < Robot.MAX_X) {
                        robot.moveX(1);
                    } else {
                        System.out.println("Robot will fall! Command ignored.");
                    }
                    break;
                case SOUTH:
                    if (robot.getYPos() > 0) {
                        robot.moveY(-1);
                    } else {
                        System.out.println("Robot will fall! Command ignored.");
                    }
                    break;
                case WEST:
                    if (robot.getXPos() > 0) {
                        robot.moveX(-1);
                    } else {
                        System.out.println("Robot will fall! Command ignored.");
                    }
                    break;
            }
        } else {
            System.out.println("Robot must be on table. Command ignored.");
        }
    }
}
