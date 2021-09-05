package project.models.employees;

import project.models.clients.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Broker extends Employee {
    private final Map<Integer, List<Client>> clientsInAuction = new HashMap<>();
    private final Map<Integer, Client> maxClientInAuction = new HashMap<>();

    public void addClient(int auctionId, Client client) {
        clientsInAuction
                .computeIfAbsent(auctionId, id -> new ArrayList<>())
                .add(client);
    }

    public List<Client> getClients(int auctionId) {
        return clientsInAuction.get(auctionId);
    }

    public void remove(int auctionId) {
        clientsInAuction.remove(auctionId);
        maxClientInAuction.remove(auctionId);
    }

    public void setMaxClientInAuction(int auctionId, Client client) {
        maxClientInAuction.put(auctionId, client);
    }

    public Client getMaxClientInAuction(int auctionId) {
        return maxClientInAuction.get(auctionId);
    }

    @Override
    public String toString() {
        return "Broker{" +
                "id=" + id +
                '}';
    }
}
