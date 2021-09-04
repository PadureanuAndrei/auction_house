package project.services;

import project.config.LoggerConfig;
import project.models.auctions.Auction;
import project.models.clients.Client;
import project.models.employees.Broker;
import project.models.products.Product;
import project.repositories.AuctionsRepository;
import project.repositories.BrokersRepository;
import project.repositories.ProductsRepository;

import java.io.PrintStream;

public class HostService {
    private static final PrintStream LOGGER = LoggerConfig.out;
    private static final HostService INSTANCE = new HostService();

    public static HostService getInstance() {
        return HostService.INSTANCE;
    }

    private final AuctionsRepository allAuctions = AuctionsRepository.getInstance();
    private final BrokersRepository allBrokers = BrokersRepository.getInstance();
    private final ProductsRepository products = ProductsRepository.getInstance();

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
        LOGGER.println("[START LICITATIE] Licitatia pentru produsul id:" + auction.getProductId() + " a inceput!");

        nextAuctionStep(auction);
    }

    private void nextAuctionStep(Auction auction) {
        Broker maxBroker = null;
        double maxPrice = -1;

        for (Broker broker : allBrokers.all()) {
            double price = brokers.nextAuctionStep(broker, auction);

            if (maxBroker == null || maxPrice < price ||
                (maxPrice == price &&
                        broker.getMaxClientInAuction(auction.getId()).getTotal() >
                        maxBroker.getMaxClientInAuction(auction.getId()).getTotal())
            ) {
                maxBroker = broker;
                maxPrice = price;
            }
        }

        auction.setActualStep(auction.getActualStep() + 1);
        auction.setActualMaxPrice(maxPrice);

        if (auction.getActualStep() == auction.getMaxSteps()) {
            finishAuction(auction, maxBroker);
        }
        else {
            nextAuctionStep(auction);
        }
    }

    private void finishAuction(Auction auction, Broker maxBroker) {
        Product product = products.get(auction.getProductId());

        if (auction.getActualMaxPrice() > product.getMinPrice()) {
            sellProduct(auction, maxBroker);
        }
        else {
            resetAuction(auction);
        }
    }

    private void sellProduct(Auction auction, Broker broker) {
        brokers.sellProduct(auction, broker);
    }

    private void resetAuction(Auction auction) {
        brokers.resetAuction(auction);
    }
}
