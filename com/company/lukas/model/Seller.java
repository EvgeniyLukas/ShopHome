package company.lukas.model;

public class Seller extends BaseEntity {
    String name;
    String lastName;
    String data;
    int salary;

    Department department;

    public Seller(Long id) {
        super(id);
    }

    public Seller(Long id, String name, String lastName, String data, int salary, Department department) {
        super(id);
        this.name = name;
        this.lastName = lastName;
        this.data = data;
        this.salary = salary;
        this.department = department;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", data='" + data + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
