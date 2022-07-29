package com.iress.robot.commands;

import com.iress.robot.model.Robot;

public class LeftCommand implements Command {

    @Override
    public void execute(Robot robot) {
        if (robot.isOnTable()) {
            robot.setDirection(robot.getDirection().getLeftDirection());
        } else {
            System.out.println("Robot must be on table. Command ignored.");
        }
    }
}
