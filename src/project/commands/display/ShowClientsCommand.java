package project.commands.display;

import project.commands.Command;
import project.config.LoggerConfig;
import project.repositories.ClientsRepository;

public class ShowClientsCommand implements Command {
    private static final ShowClientsCommand INSTANCE = new ShowClientsCommand();

    public static ShowClientsCommand getInstance() {
        return INSTANCE;
    }

    private ShowClientsCommand() {}

    private final ClientsRepository clients = ClientsRepository.getInstance();

    @Override
    public void execute() {
        LoggerConfig.out.println("Lista de clienti:");
        clients.all().forEach(LoggerConfig.out::println);
        LoggerConfig.out.println("--------------------------------------------------------------------------------");
    }
}
