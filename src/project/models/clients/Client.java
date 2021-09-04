package project.models.clients;

import java.util.HashMap;
import java.util.Map;

public abstract class Client {
    private static int clientId = 0;

    protected final int id;
    protected String name;
    protected String address;
    protected int total;
    protected int wined;

    private final Map<Integer, Double> maxProductPrice = new HashMap<>();

    protected Client(String name, String address) {
        this.id = clientId++;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getWined() {
        return wined;
    }

    public void setWined(int wined) {
        this.wined = wined;
    }

    public void setMaxProductPrice(int productId, double price) {
        maxProductPrice.put(productId, price);
    }

    public double getMaxProductPrice(int productId) {
        return maxProductPrice.get(productId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return id == client.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
