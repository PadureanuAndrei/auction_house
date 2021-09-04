package project.commands;

import project.config.ScannerConfig;

public interface Command {

    void execute();

    default String[] params() {
        return ScannerConfig.SCANNER.nextLine().split("\"");
    }
}
