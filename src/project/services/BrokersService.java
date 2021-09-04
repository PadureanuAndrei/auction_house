package project.services;

import project.models.auctions.Auction;
import project.models.clients.Client;
import project.models.employees.Broker;
import project.repositories.AuctionsRepository;
import project.repositories.BrokersRepository;

public class BrokersService {
    private static final BrokersService INSTANCE = new BrokersService();

    public static BrokersService getInstance() {
        return BrokersService.INSTANCE;
    }

    private final BrokersRepository brokers = BrokersRepository.getInstance();
    private final AuctionsRepository auctions = AuctionsRepository.getInstance();
    private final ClientsService clients = ClientsService.getInstance();


    public void registerClientInAuction(Broker broker, Client client, Auction auction) {
        broker.addClient(auction.getId(), client);
        auction.setRegisteredClients(auction.getRegisteredClients() + 1);
    }


    public void startAuction(Auction auction) {
        brokers.all().forEach(broker -> {
            broker.getClients(auction.getId()).forEach(client -> clients.auctionStarts(client, auction));
        });
    }

    public void sellProduct(Auction auction, Client winner) {
        brokers.all().stream()
                .flatMap(broker -> broker.getClients(auction.getId()).stream())
                .filter(client -> !client.equals(winner))
                .forEach(client -> clients.auctionEndsFail(client, auction));

        clients.auctionEndsSuccess(winner, auction);

        auctions.remove(auction);
    }

    private void restartAuction(Auction auction) {
        brokers.all().stream()
                .flatMap(broker -> broker.getClients(auction.getId()).stream())
                .forEach(client -> clients.auctionEndsFail(client, auction));

        auction.setRegisteredClients(0);
    }

    private void removeAuction(Auction auction) {
        auctions.remove(auction);
    }
}
