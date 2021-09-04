package project.models.clients;

public class LegalPerson extends Client {
    private double jointStock;
    private Company type;

    public LegalPerson(String name, String address, double jointStock, Company type) {
        super(name, address);
        this.jointStock = jointStock;
        this.type = type;
    }

    public double getJointStock() {
        return jointStock;
    }

    public void setJointStock(double jointStock) {
        this.jointStock = jointStock;
    }

    public Company getType() {
        return type;
    }

    public void setType(Company type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "LegalPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", total=" + total +
                ", wined=" + wined +
                ", jointStock=" + jointStock +
                ", type=" + type +
                '}';
    }
}
