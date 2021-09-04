package project.models.products;

public class Gem extends Product {
    private String material;
    private boolean valued;

    public Gem(String name, double minPrice, int year, String material, boolean valued) {
        super(name, minPrice, year);
        this.material = material;
        this.valued = valued;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isValued() {
        return valued;
    }

    public void setValued(boolean valued) {
        this.valued = valued;
    }

    @Override
    public String toString() {
        return "Gem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minPrice=" + minPrice +
                ", soldPrice=" + soldPrice +
                ", year=" + year +
                ", material='" + material + '\'' +
                ", valued=" + valued +
                '}';
    }
}
