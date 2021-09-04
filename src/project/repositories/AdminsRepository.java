package project.repositories;

import project.models.employees.Admin;
import project.models.products.Product;

public class AdminsRepository extends Repository<Admin> {
    private static final AdminsRepository INSTANCE = new AdminsRepository();

    public static AdminsRepository getInstance() {
        return AdminsRepository.INSTANCE;
    }

    public void add(Admin admin) {
        super.add(admin.getId(), admin);
    }

    public void remove(Admin admin) {
        super.remove(admin.getId());
    }
}
