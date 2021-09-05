package project.commands.display;

import project.commands.Command;
import project.config.LoggerConfig;
import project.repositories.BrokersRepository;

public class ShowBrokersCommand implements Command {
    private static final ShowBrokersCommand INSTANCE = new ShowBrokersCommand();

    public static ShowBrokersCommand getInstance() {
        return INSTANCE;
    }

    private ShowBrokersCommand() {}

    private final BrokersRepository brokers = BrokersRepository.getInstance();

    @Override
    public void execute() {
        LoggerConfig.out.println("Lista de brokeri:");
        brokers.all().forEach(LoggerConfig.out::println);
        LoggerConfig.out.println("--------------------------------------------------------------------------------");
    }
}
