package project.commands;

import project.commands.auctions.EnterInAuctionCommand;
import project.commands.creational.*;
import project.commands.display.ShowBrokersCommand;
import project.commands.display.ShowClientsCommand;
import project.commands.display.ShowProductsCommand;
import project.commands.flow.BreakCommand;
import project.config.ScannerConfig;
import project.commands.exceptions.IllegalCommandTypeException;

import java.util.Scanner;

public class CommandsParser {
    private static final Scanner scanner = ScannerConfig.SCANNER;
    private static final CommandsParser INSTANCE = new CommandsParser();

    public static CommandsParser getInstance() {
        return INSTANCE;
    }


    private CommandsParser() {}

    public Command parse() {
        String command = scanner.next();

        switch (command) {
            case "register_natural_person": return RegisterNaturalPersonCommand.getInstance();
            case "register_legal_person": return RegisterLegalPersonCommand.getInstance();

            case "register_broker": return RegisterBrokerCommand.getInstance();
            case "register_admin": return RegisterAdminCommand.getInstance();

            case "add_gem": return AddGemCommand.getInstance();
            case "add_furniture": return AddFurnitureCommand.getInstance();
            case "add_painting": return AddPaintingCommand.getInstance();

            case "enter_auction": return EnterInAuctionCommand.getInstance();

            case "show_products": return ShowProductsCommand.getInstance();
            case "show_brokers": return ShowBrokersCommand.getInstance();
            case "show_clients": return ShowClientsCommand.getInstance();


            case "break": return BreakCommand.getInstance();

            default: throw new IllegalCommandTypeException(command);
        }
    }

}
