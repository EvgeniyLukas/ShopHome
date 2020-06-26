package company.lukas.model;

import java.util.Set;

public class Shop extends BaseEntity {
    String name;
    String type;

    Set<Department> departments;

    public Shop(Long id) {
        super(id);
    }

    public Shop(Long id, String name, String type, Set<Department> departments) {
        super(id);
        this.name = name;
        this.type = type;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", departments=" + departments +
                '}';
    }
}
