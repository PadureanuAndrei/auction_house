package project.repositories;

import project.models.clients.Client;

public class ClientsRepository extends Repository<Client> {
    private static final ClientsRepository INSTANCE = new ClientsRepository();

    public static ClientsRepository getInstance() {
        return ClientsRepository.INSTANCE;
    }

    public void add(Client client) {
        add(client.getId(), client);
    }

    public void remove(Client client) {
        remove(client.getId());
    }
}
