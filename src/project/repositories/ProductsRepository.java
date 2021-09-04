package project.repositories;

import project.config.AuctionsConfig;
import project.models.auctions.Auction;
import project.models.products.Product;

public class ProductsRepository extends Repository<Product> {
    private static final ProductsRepository INSTANCE = new ProductsRepository();

    public static ProductsRepository getInstance() {
        return ProductsRepository.INSTANCE;
    }

    private final AuctionsRepository auctions = AuctionsRepository.getInstance();

    public void add(Product product) {
        super.add(product.getId(), product);

        Auction auction = new Auction(AuctionsConfig.MIN_CLIENTS, product.getId(), AuctionsConfig.MAX_STEPS);

        auctions.add(auction.getId(), auction);
    }

    public void remove(Product product) {
        remove(product.getId());
    }
}
