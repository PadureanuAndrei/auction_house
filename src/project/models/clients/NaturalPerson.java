package project.models.clients;

public class NaturalPerson extends Client {
    private String birthday;

    public NaturalPerson(String name, String address, String birthday) {
        super(name, address);
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "NaturalPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", total=" + total +
                ", wined=" + wined +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
