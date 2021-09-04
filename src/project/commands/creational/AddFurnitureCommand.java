package project.commands.creational;

import project.commands.Command;
import project.models.products.Furniture;
import project.models.products.Product;
import project.models.products.ProductBuilder;
import project.services.AdminsService;

/**
 * add_furniture "{name}" "{minPrice}" "{year}" "{type}" "{material}"
 */
public class AddFurnitureCommand implements Command {
    private static final AddFurnitureCommand INSTANCE = new AddFurnitureCommand();

    public static AddFurnitureCommand getInstance() {
        return INSTANCE;
    }

    private AddFurnitureCommand() {}

    private final AdminsService admins = AdminsService.getInstance();

    @Override
    public void execute() {
        String[] params = params();

        Product product = new ProductBuilder()
                .productType(Furniture.class)
                .name(params[1])
                .minPrice(Double.parseDouble(params[3]))
                .year(Integer.parseInt(params[5]))
                .type(params[7])
                .material(params[9])
                .build();

        admins.addProduct(product);
    }
}
