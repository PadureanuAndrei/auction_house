package project.commands.creational;

import project.commands.Command;
import project.models.products.*;
import project.services.AdminsService;

/**
 * add_painting "{name}" "{minPrice}" "{year}" "{authorName}" "{color}"
 */
public class AddPaintingCommand implements Command {
    private static final AddPaintingCommand INSTANCE = new AddPaintingCommand();

    public static AddPaintingCommand getInstance() {
        return INSTANCE;
    }

    private AddPaintingCommand() {}

    private final AdminsService admins = AdminsService.getInstance();

    @Override
    public void execute() {
        String[] params = params();

        Product product = new ProductBuilder()
                .productType(Painting.class)
                .name(params[1])
                .minPrice(Double.parseDouble(params[3]))
                .year(Integer.parseInt(params[7]))
                .authorName(params[9])
                .color(Color.valueOf(params[11]))
                .build();

        admins.addProduct(product);
    }
}
