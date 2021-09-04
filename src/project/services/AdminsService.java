package project.services;

import project.models.products.Product;
import project.repositories.ProductsRepository;

public class AdminsService {
    private static final AdminsService INSTANCE = new AdminsService();

    public static AdminsService getInstance() {
        return AdminsService.INSTANCE;
    }

    private final ProductsRepository products = ProductsRepository.getInstance();

    public void addProduct(Product product) {
        products.add(product);
    }
}
