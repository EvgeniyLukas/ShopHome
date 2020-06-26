package company.lukas.model;

public class BaseEntity {

    private Long id;

    public BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isNew() {
        return (this.id == null);
    }
}
