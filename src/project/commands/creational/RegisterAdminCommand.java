package project.commands.creational;

import project.commands.Command;
import project.models.employees.Admin;
import project.repositories.AdminsRepository;

public class RegisterAdminCommand implements Command {
    private static final RegisterAdminCommand INSTANCE = new RegisterAdminCommand();

    public static RegisterAdminCommand getInstance() {
        return INSTANCE;
    }

    private RegisterAdminCommand() {}

    private final AdminsRepository admins = AdminsRepository.getInstance();

    @Override
    public void execute() {
        Admin admin = new Admin();

        admins.add(admin);
    }
}
