package project.services;

import project.models.auctions.Auction;
import project.models.clients.Client;
import project.models.employees.Broker;
import project.repositories.AuctionsRepository;
import project.repositories.BrokersRepository;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HostService {
    private static final HostService INSTANCE = new HostService();

    public static HostService getInstance() {
        return HostService.INSTANCE;
    }

    private final Logger logger = Logger.getAnonymousLogger();
    private final AuctionsRepository allAuctions = AuctionsRepository.getInstance();
    private final BrokersRepository allBrokers = BrokersRepository.getInstance();

    private final BrokersService brokers = BrokersService.getInstance();

    public void entryInAuction(int productId, Client client) {
        Broker broker = allBrokers.getRandomBroker();
        Auction auction = allAuctions.getByProductId(productId);

        brokers.registerClientInAuction(broker, client, auction);

        if (auction.getRegisteredClients() == auction.getMinClients()) {
            startAuction(auction);
        }
    }

    private void startAuction(Auction auction) {
        logger.log(Level.INFO, "Licitatia pentru produsul id:" + auction.getId() + " a inceput");
        this.brokers.startAuction(auction);
    }
}
