package project.commands.flow;

import project.commands.Command;
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
