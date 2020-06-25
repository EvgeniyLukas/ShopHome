package company.lukas.model;

import java.util.Set;

public class Department extends BaseEntity{
    String name;
    String type;

    Set<Seller> sellers;

    public Department(Long id) {
        super(id);
    }

    public Department(Long id, String name, String type, Set<Seller> sellers) {
        super(id);
        this.name = name;
        this.type = type;
        this.sellers = sellers;
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

    public Set<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(Set<Seller> sellers) {
        this.sellers = sellers;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", sellers=" + sellers +
                '}';
    }
}
