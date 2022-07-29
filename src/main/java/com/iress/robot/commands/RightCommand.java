package com.iress.robot.commands;

import com.iress.robot.model.Robot;

public class RightCommand implements Command {

    @Override
    public void execute(Robot robot) {
        if (robot.isOnTable()) {
            robot.setDirection(robot.getDirection().getRightDirection());
        } else {
            System.out.println("Robot must be on table. Command ignored.");
        }
    }
}
