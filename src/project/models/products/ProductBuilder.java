package project.models.products;

import project.models.products.exceptions.UndefinedProductTypeException;

public class ProductBuilder {
    private String name;
    private double minPrice;
    private double soldPrice;
    private int year;

    private Class<? extends Product> productType;

    private String authorName;
    private Color color;

    private String type;
    private String material;

    private boolean valued;

    public ProductBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder minPrice(double minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    public ProductBuilder soldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
        return this;
    }

    public ProductBuilder year(int year) {
        this.year = year;
        return this;
    }

    public ProductBuilder productType(Class<? extends Product> productType) {
        this.productType = productType;
        return this;
    }

    public ProductBuilder authorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public ProductBuilder color(Color color) {
        this.color = color;
        return this;
    }

    public ProductBuilder type(String type) {
        this.type = type;
        return this;
    }

    public ProductBuilder material(String material) {
        this.material = material;
        return this;
    }

    public ProductBuilder valued(boolean valued) {
        this.valued = valued;
        return this;
    }

    public Product build() {
        if (Painting.class == productType) {
            return new Painting(name,  minPrice, year, authorName, color);
        }

        if (Furniture.class == productType) {
            return new Furniture(name,  minPrice, year, type, material);
        }

        if (Gem.class == productType) {
            return new Gem(name,  minPrice, year, material, valued);
        }

        throw new UndefinedProductTypeException(productType);
    }
}
