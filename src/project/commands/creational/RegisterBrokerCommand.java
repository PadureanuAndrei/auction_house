package project.commands.creational;

import project.commands.Command;
import project.models.employees.Broker;
import project.repositories.BrokersRepository;

public class RegisterBrokerCommand implements Command {
    private static final RegisterBrokerCommand INSTANCE = new RegisterBrokerCommand();

    public static RegisterBrokerCommand getInstance() {
        return INSTANCE;
    }

    private RegisterBrokerCommand() {}

    private final BrokersRepository brokers = BrokersRepository.getInstance();

    @Override
    public void execute() {
        Broker broker = new Broker();

        brokers.add(broker);
    }
}
