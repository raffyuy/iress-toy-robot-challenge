package com.iress.robot;

import com.iress.robot.commands.Command;
import com.iress.robot.commands.CommandFactory;
import com.iress.robot.commands.ExitCommand;
import com.iress.robot.commands.ParameterisedCommand;
import com.iress.robot.model.Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ToyRobotApplication {

    public static void main(String[] args) throws IOException {
        Robot robot = new Robot();

        System.out.println("Please input a command");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Command command = null;
            while (command == null || command.getClass() != ExitCommand.class) {
                command = getValidCommand(reader);
                if (command != null) {
                    command.execute(robot);
                } else {
                    System.out.println("Invalid command. Valid commands are: ");
                    CommandFactory.COMMANDS.keySet().forEach(System.out::println);
                }
            }
        }
    }

    private static Command getValidCommand(BufferedReader reader) throws IOException {
        String[] input = reader.readLine().split(" ");
        Command command = null;
        while (command == null) {
            try {
                command = CommandFactory.getCommand(input[0]);
                if (command != null && input.length > 1) {
                    ((ParameterisedCommand) command).setParameters(input[1]);
                }
                return command;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please try again.");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid direction. Please use NORTH, EAST, SOUTH, WEST");
            } catch (Exception e) {
                throw e;
            }
        }
        return null;
    }

}
