package project.commands.auctions;

import project.commands.Command;
import project.services.ClientsService;

/**
 * enter_auction "{clientId}" "{productId}" "{maxPrice}"
 */
public class EnterInAuctionCommand implements Command {
    private static final EnterInAuctionCommand INSTANCE = new EnterInAuctionCommand();

    public static EnterInAuctionCommand getInstance() {
        return INSTANCE;
    }

    private EnterInAuctionCommand() {}

    private final ClientsService clients = ClientsService.getInstance();

    @Override
    public void execute() {
        String[] params = params();

        clients.entryInAuction(Integer.parseInt(params[1]), Integer.parseInt(params[3]), Integer.parseInt(params[5]));
    }
}
