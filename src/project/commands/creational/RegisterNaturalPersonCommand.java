package project.commands.creational;

import project.commands.Command;
import project.models.clients.Client;
import project.models.clients.NaturalPerson;
import project.repositories.ClientsRepository;

/**
 * register_natural_person "{name}" "{address}" "{birthday}"
 */
public class RegisterNaturalPersonCommand implements Command {

    private static final RegisterNaturalPersonCommand INSTANCE = new RegisterNaturalPersonCommand();

    public static RegisterNaturalPersonCommand getInstance() {
        return INSTANCE;
    }

    private RegisterNaturalPersonCommand() {}

    private final ClientsRepository clients = ClientsRepository.getInstance();

    @Override
    public void execute() {
        String[] params = params();

        Client client = new NaturalPerson(params[1], params[3], params[5]);
        clients.add(client);
    }

}
