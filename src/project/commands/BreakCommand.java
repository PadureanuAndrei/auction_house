package project.commands;

import project.config.LoggerConfig;

public class BreakCommand implements Command {
    private static final BreakCommand INSTANCE = new BreakCommand();

    public static BreakCommand getInstance() {
        return INSTANCE;
    }

    private BreakCommand() {}

    @Override
    public void execute() {
        LoggerConfig.out.println("Programul se inchide )");
    }
}
