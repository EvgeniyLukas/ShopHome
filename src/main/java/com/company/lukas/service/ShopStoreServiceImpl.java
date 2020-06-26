package company.lukas.service;

import company.lukas.dao.ShopDAO;
import company.lukas.dao.jdbc.JdbcShopDAOImpl;
import company.lukas.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ShopStoreServiceImpl<T, ID> implements StoreService<Shop, Long> {

    @Autowired
    JdbcShopDAOImpl jdbcShopDAO = new JdbcShopDAOImpl();


    @Override
    public void save(Shop shop) {
        jdbcShopDAO.save(shop);
    }

    @Override
    public void update(Shop shop) {
        jdbcShopDAO.update(shop);
    }

    @Override
    public void remove(Shop entity) {

    }

    @Override
    public Shop getById(Long id) {
        return jdbcShopDAO.getById(id);
    }

    public Collection<Shop> getAll() {
        Shop shop = new Shop();
        Collection<Shop> list = new ArrayList<>();
        return list = jdbcShopDAO.showAllShops(shop);
    }
}
