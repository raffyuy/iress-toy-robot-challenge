package com.iress.robot.model;

import lombok.Data;

@Data
public class Robot {
    public static Integer MAX_X = 4;
    public static Integer MAX_Y = 4;

    private Integer xPos;
    private Integer yPos;
    private Direction direction;

    public boolean isOnTable() {
        return xPos != null && yPos != null && direction != null;
    }

    public void moveX(int x) {
        xPos += x;
    }

    public void moveY(int y) {
        yPos += y;
    }

    public void moveLeft() {
        direction = direction.getLeftDirection();
    }

    public void moveRight() {
        direction = direction.getRightDirection();
    }
}
