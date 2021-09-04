package project.commands;

import project.models.products.Gem;
import project.models.products.Product;
import project.models.products.ProductBuilder;
import project.services.AdminsService;

/**
 * add_gem "{name}" "{minPrice}" "{year}" "{material}" "{valued}"
 */
public class AddGemCommand implements Command {
    private static final AddGemCommand INSTANCE = new AddGemCommand();

    public static AddGemCommand getInstance() {
        return INSTANCE;
    }

    private AddGemCommand() {}

    private final AdminsService admins = AdminsService.getInstance();

    @Override
    public void execute() {
        String[] params = SCANNER.nextLine().split("\"");

        Product product = new ProductBuilder()
                .productType(Gem.class)
                .name(params[1])
                .minPrice(Double.parseDouble(params[3]))
                .year(Integer.parseInt(params[5]))
                .material(params[7])
                .valued(Boolean.parseBoolean(params[9]))
                .build();

        admins.addProduct(product);
    }
}
