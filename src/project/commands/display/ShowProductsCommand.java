package project.commands.display;

import project.commands.Command;
import project.config.LoggerConfig;
import project.repositories.ProductsRepository;

public class ShowProductsCommand implements Command {
    private static final ShowProductsCommand INSTANCE = new ShowProductsCommand();

    public static ShowProductsCommand getInstance() {
        return INSTANCE;
    }

    private ShowProductsCommand() {}

    private final ProductsRepository products = ProductsRepository.getInstance();

    @Override
    public void execute() {
        LoggerConfig.out.println("Lista de produse:");
        products.all().forEach(LoggerConfig.out::println);
        LoggerConfig.out.println("--------------------------------------------------------------------------------");
    }
}
