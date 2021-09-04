package project.models.products;

public abstract class Product {
    private static int productId = 0;

    protected final int id;
    protected String name;
    protected double minPrice;
    protected double soldPrice;
    protected int year;

    protected Product(String name, double minPrice, int year) {
        this.id = productId++;
        this.name = name;
        this.minPrice = minPrice;
        this.year = year;

        this.soldPrice = -1;
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

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id == product.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
