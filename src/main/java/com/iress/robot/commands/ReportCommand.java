package com.iress.robot.commands;

import com.iress.robot.model.Robot;

public class ReportCommand implements Command {

    @Override
    public void execute(Robot robot) {
        System.out.printf("Robot position is at: [%s, %s], facing %s.\n",
                robot.getXPos(), robot.getYPos(), robot.getDirection());
    }
}
