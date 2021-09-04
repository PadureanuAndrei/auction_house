package project.commands;

import project.config.ScannerConfig;

import java.util.Scanner;

public interface Command {
    Scanner SCANNER = ScannerConfig.SCANNER;

    void execute();
}
