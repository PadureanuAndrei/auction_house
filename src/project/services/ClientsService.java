package project.services;

import project.models.auctions.Auction;
import project.models.clients.Client;
import project.repositories.ClientsRepository;
import project.repositories.Repository;


public class ClientsService {
    private final static ClientsService INSTANCE = new ClientsService();

    public static ClientsService getInstance() {
        return ClientsService.INSTANCE;
    }

    private final Repository<Client> clients = ClientsRepository.getInstance();
    private final BrokersService brokers = BrokersService.getInstance();
    private final HostService host = HostService.getInstance();

    private ClientsService() {}

    public void entryInAuction(int clientId, int productId) {
        host.entryInAuction(productId, clients.get(clientId));
    }

    public void auctionStarts(Client client, Auction auction) {

    }

    public void auctionEndsSuccess(Client client, Auction auction) {

    }

    public void auctionEndsFail(Client client, Auction auction) {

    }
}
