package project.services;

import project.models.auctions.Auction;
import project.models.auctions.Commission;
import project.models.auctions.CommissionFactory;
import project.models.clients.Client;
import project.models.employees.Broker;
import project.models.products.Product;
import project.repositories.AuctionsRepository;
import project.repositories.ProductsRepository;

public class BrokersService {
    private static final BrokersService INSTANCE = new BrokersService();

    public static BrokersService getInstance() {
        return BrokersService.INSTANCE;
    }

    private BrokersService() {}

    private final ProductsRepository products = ProductsRepository.getInstance();
    private final AuctionsRepository auctions = AuctionsRepository.getInstance();
    private final ClientsService clients = ClientsService.getInstance();
    private final CommissionFactory commissions = CommissionFactory.getInstance();


    public void registerClientInAuction(Broker broker, Client client, Auction auction) {
        broker.addClient(auction.getId(), client);
        auction.setRegisteredClients(auction.getRegisteredClients() + 1);
    }

    public double nextAuctionStep(Broker broker, Auction auction) {
        Product product = products.get(auction.getId());

        Client maxClient = null;
        double maxPrice = -1;

        for (Client client : broker.getClients(auction.getId())) {
            double price = clients.nextAuctionStep(client, product.getId(), auction.getActualStep(), auction.getActualMaxPrice());

            if (maxClient == null || price > maxPrice || (price == maxPrice && client.getTotal() > maxClient.getTotal())) {
                maxClient = client;
                maxPrice = price;
            }
        }

        if (maxClient != null) {
            broker.setMaxClientInAuction(auction.getId(), maxClient);
        }

        return maxPrice;
    }

    public void sellProduct(Auction auction, Broker broker) {
        Client client = broker.getMaxClientInAuction(auction.getId());

        Commission commission = commissions.getCommission(client);
        double priceWithCommission = commission.addCommission(auction.getActualMaxPrice());

        clients.auctionEndsSuccess(client, auction.getProductId(), priceWithCommission);

        auctions.remove(auction);
    }

    public void resetAuction(Auction auction) {
        clients.auctionEndsFail(auction.getProductId());

        auctions.reset(auction);
    }
}
