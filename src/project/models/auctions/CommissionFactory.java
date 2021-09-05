package project.models.auctions;

import project.models.clients.Client;
import project.models.clients.NaturalPerson;

public class CommissionFactory {
    private static final CommissionFactory INSTANCE = new CommissionFactory();

    public static CommissionFactory getInstance() {
        return INSTANCE;
    }

    private CommissionFactory() {}

    private final Commission c1 = new Commission() {
        @Override
        public double addCommission(double price) {
            return price * 1.2;
        }
    };

    private final Commission c2 = new Commission() {
        @Override
        public double addCommission(double price) {
            return price * 1.15;
        }
    };

    private final Commission c3 = new Commission() {
        @Override
        public double addCommission(double price) {
            return price * 1.25;
        }
    };

    private final Commission c4 = new Commission() {
        @Override
        public double addCommission(double price) {
            return price * 1.1;
        }
    };

    public Commission getCommission(Client client) {
        if (client instanceof NaturalPerson) {
            return client.getTotal() < 5 ? c1 : c2;
        }

        return  client.getTotal() < 25 ? c3 : c4;
    }

}
