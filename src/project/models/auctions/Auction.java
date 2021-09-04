package project.models.auctions;

public class Auction {
    private static int auctionId = 0;

    private final int id;
    private int minClients;
    private int registeredClients;
    private int productId;
    private int maxSteps;

    public Auction(int minClients, int productId, int maxSteps) {
        this.id = auctionId++;
        this.minClients = minClients;
        this.productId = productId;
        this.maxSteps = maxSteps;
    }

    public int getId() {
        return id;
    }

    public int getMinClients() {
        return minClients;
    }

    public void setMinClients(int minClients) {
        this.minClients = minClients;
    }

    public int getRegisteredClients() {
        return registeredClients;
    }

    public void setRegisteredClients(int registeredClients) {
        this.registeredClients = registeredClients;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getMaxSteps() {
        return maxSteps;
    }

    public void setMaxSteps(int maxSteps) {
        this.maxSteps = maxSteps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auction auction = (Auction) o;

        return id == auction.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "id=" + id +
                ", minClients=" + minClients +
                ", registeredClients=" + registeredClients +
                ", productId=" + productId +
                ", maxSteps=" + maxSteps +
                '}';
    }
}
