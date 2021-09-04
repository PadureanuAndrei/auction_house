package project.commands;

import project.models.clients.Client;
import project.models.clients.Company;
import project.models.clients.LegalPerson;
import project.repositories.ClientsRepository;

/**
 * register_legal_person "{name}" "{address}" "{jointStock}" "{SRL/SA}"
 */
public class RegisterLegalPersonCommand implements Command {
    private static final RegisterLegalPersonCommand INSTANCE = new RegisterLegalPersonCommand();

    public static RegisterLegalPersonCommand getInstance() {
        return INSTANCE;
    }

    private RegisterLegalPersonCommand() {}

    private final ClientsRepository clients = ClientsRepository.getInstance();

    @Override
    public void execute() {
        String[] params = SCANNER.nextLine().trim().split("\"");

        Client client = new LegalPerson(params[1], params[3], Double.parseDouble(params[5].trim()), Company.valueOf(params[7]));
        clients.add(client);
    }
}