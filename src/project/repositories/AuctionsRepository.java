package project.repositories;

import project.models.auctions.Auction;

public class AuctionsRepository extends Repository<Auction> {
    private static final AuctionsRepository INSTANCE = new AuctionsRepository();

    public static AuctionsRepository getInstance() {
        return AuctionsRepository.INSTANCE;
    }

    private final ProductsRepository products = ProductsRepository.getInstance();
    private final BrokersRepository brokers = BrokersRepository.getInstance();

    public void remove(Auction auction) {
        products.remove(auction.getId());
        brokers.all().forEach(broker -> broker.remove(auction.getId()));

        super.remove(auction.getId());
    }

    public void reset(Auction auction) {
        auction.setRegisteredClients(0);
    }

    public Auction getByProductId(int productId) {
        return all()
                .stream()
                .filter(auction -> auction.getProductId() == productId)
                .findAny()
                .orElseThrow(() -> new RuntimeException("The auction is not init"));
    }
}
