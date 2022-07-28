package com.iress.robot.commands;

import com.iress.robot.model.Direction;
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
}
