package project.repositories;

import project.models.employees.Broker;

import java.util.List;
import java.util.Random;

public class BrokersRepository extends Repository<Broker> {
    private static final BrokersRepository INSTANCE = new BrokersRepository();

    public static BrokersRepository getInstance() {
        return BrokersRepository.INSTANCE;
    }

    private BrokersRepository() {}

    public void add(Broker broker) {
        super.add(broker.getId(), broker);
    }

    public void remove(Broker broker) {
        super.remove(broker.getId());
    }

    public Broker getRandomBroker() {
        List<Broker> brokers = all();
        int brokersLen = brokers.size();

        return brokers.get(new Random().nextInt(brokersLen));
    }
}
