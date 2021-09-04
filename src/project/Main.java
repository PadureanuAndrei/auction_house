package project;

import project.commands.BreakCommand;
import project.commands.Command;
import project.commands.CommandsParser;

public class Main {
    private static final CommandsParser commands = CommandsParser.getInstance();

    private Main() {}

    public static void main(String[] args) {
        Command command;

        do {
            command = commands.parse();
            command.execute();
        } while (command != BreakCommand.getInstance());
    }
}
