package com.iress.robot.model;

import lombok.Getter;

@Getter
public enum Direction {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    private int directionIndex;

    Direction(int directionIndex) {
        this.directionIndex = directionIndex;
    }

    public Direction getLeftDirection() {
        if (directionIndex == 0) {
            return Direction.values()[Direction.values().length - 1];
        } else {
            return Direction.values()[directionIndex - 1];
        }
    }

    public Direction getRightDirection() {
        if (directionIndex == Direction.values().length - 1) {
            return Direction.values()[0];
        } else {
            return Direction.values()[directionIndex + 1];
        }
    }


}
