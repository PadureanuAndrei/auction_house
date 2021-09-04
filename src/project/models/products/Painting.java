package project.models.products;

public class Painting extends Product {
    private String authorName;
    private Color color;

    public Painting(String name, double minPrice, int year, String authorName, Color color) {
        super(name, minPrice, year);
        this.authorName = authorName;
        this.color = color;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Painting{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minPrice=" + minPrice +
                ", soldPrice=" + soldPrice +
                ", year=" + year +
                ", authorName='" + authorName + '\'' +
                ", color=" + color +
                '}';
    }
}
