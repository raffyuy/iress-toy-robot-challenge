package com.iress.robot.model;

import lombok.Data;

@Data
public class Robot {
    private Integer posX;
    private Integer posY;
    private Direction direction;
}
