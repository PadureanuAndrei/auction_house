package project.services;

import project.config.AuctionsConfig;
import project.config.LoggerConfig;
import project.models.auctions.Commission;
import project.models.clients.Client;
import project.models.products.Product;
import project.repositories.ClientsRepository;
import project.repositories.ProductsRepository;

import java.io.PrintStream;
import java.util.List;


public class ClientsService {
    private static final ClientsService INSTANCE = new ClientsService();
    private static final PrintStream LOGGER = LoggerConfig.out;

    public static ClientsService getInstance() {
        return INSTANCE;
    }

    private final ProductsRepository products = ProductsRepository.getInstance();
    private final ClientsRepository clients = ClientsRepository.getInstance();
    // Lazy loading. Circular dependency
    private HostService host;

    private ClientsService() {}

    public List<Product> getProducts() {
        return products.all();
    }

    public void entryInAuction(int clientId, int productId, double maxPrice) {
        if (host == null) {
            host = HostService.getInstance();
        }

        Client client = clients.get(clientId);
        client.setMaxProductPrice(productId, maxPrice);

        host.entryInAuction(productId, client);

        client.setTotal(client.getTotal() + 1);
    }

    public double nextAuctionStep(Client client, int productId, int auctionStep, double minPrice) {
        double maxPrice = client.getMaxProductPrice(productId);
        double price = maxPrice <= minPrice ? minPrice :
                                              minPrice + (maxPrice - minPrice) / (AuctionsConfig.MAX_STEPS - auctionStep);

        LOGGER.println("[LICITATIE produs:" + productId + " | pas:" + auctionStep + " ] clientul id:" +
                        client.getId() + " plateste " + price);

        return price;
    }

    public void auctionEndsSuccess(Client client, int productId, double totalPrice) {
        LOGGER.println("[LICITATIE SUCCES] clientul id:" + client.getId() +
                       " a castigat licitatia pentru produsul id:" + productId);

        LOGGER.println("[BROKER COMMISSION]" + " suma totala = " + totalPrice);
    }

    public void auctionEndsFail(int productId) {
        LOGGER.println("[LICITATIE ESEC] produsul id:" + productId + " nu a fost vandut");
    }
}
