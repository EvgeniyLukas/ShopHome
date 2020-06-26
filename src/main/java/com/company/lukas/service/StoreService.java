package company.lukas.service;

public interface StoreService<T, ID>{
    void save(T entity);

    void update(T entity);

    void remove(T entity);

    T getById(ID id);
}
