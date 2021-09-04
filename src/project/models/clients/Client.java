package project.models.clients;

public abstract class Client {
    private static int clientId = 0;

    protected final int id;
    protected String name;
    protected String address;
    protected int total;
    protected int wined;

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
