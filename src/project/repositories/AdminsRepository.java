package project.repositories;

import project.models.employees.Admin;

public class AdminsRepository extends Repository<Admin> {
    private static final AdminsRepository INSTANCE = new AdminsRepository();

    public static AdminsRepository getInstance() {
        return AdminsRepository.INSTANCE;
    }

    private AdminsRepository() {}

    public void add(Admin admin) {
        super.add(admin.getId(), admin);
    }

    public void remove(Admin admin) {
        super.remove(admin.getId());
    }
}
