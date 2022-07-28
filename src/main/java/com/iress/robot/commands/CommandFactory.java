
package com.iress.robot.commands;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class CommandFactory {
    public static final Map<String, Class<? extends Command>> COMMANDS = Map.of(
            "PLACE", PlaceCommand.class,
            "LEFT", LeftCommand.class,
            "RIGHT", RightCommand.class,
            "MOVE", MoveCommand.class,
            "REPORT", ReportCommand.class,
            "EXIT", ExitCommand.class
    );

    public static Command getCommand(String input) {
        try {
            return COMMANDS.get(input).getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException |
                InvocationTargetException | NoSuchMethodException |
                NullPointerException e) {
            return null;
        }
    }
}
