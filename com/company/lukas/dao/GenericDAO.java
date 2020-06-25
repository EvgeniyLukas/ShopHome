package company.lukas.dao;

public interface GenericDAO<T, ID> {

    void save(T entity);

    void update(T entity);

    void remove(T entity);

    T getById(ID id);
}
