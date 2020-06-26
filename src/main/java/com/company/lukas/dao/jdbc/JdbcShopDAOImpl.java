package company.lukas.dao.jdbc;

import company.lukas.dao.ShopDAO;
import company.lukas.model.Department;
import company.lukas.model.Shop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static company.lukas.util.ConnectionJDBC.*;


public class JdbcShopDAOImpl implements ShopDAO {
    private static final String INSERT_NEW = "INSERT INTO shop (id, name_shop, type_shop) VALUE (?,?,?)";
    private static final String UPDATE_ROW = "UPDATE shop SET name_shop =?, type_shop = ? where id = ?";
    private static final String GET_BY_ID = "SELECT * FROM shop WHERE id=?";
    private static final String ALL_SHOPS = "SELECT * FROM shop";


    public JdbcShopDAOImpl() {
        try {
            createConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Shop shop) {
        try {
            preparedStatement = conn.prepareStatement(INSERT_NEW);
            preparedStatement.setLong(1, shop.getId());
            preparedStatement.setString(2, shop.getName());
            preparedStatement.setString(3, shop.getType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Shop shop) {
        try {
            preparedStatement = conn.prepareStatement(UPDATE_ROW);
            preparedStatement.setString(1, shop.getName());
            preparedStatement.setString(2, shop.getType());
            preparedStatement.setLong(3, shop.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Shop entity) {

    }

    @Override
    public Shop getById(Long longId) {
        Shop shop = new Shop(longId);

        try {
            preparedStatement = conn.prepareStatement(GET_BY_ID);
            preparedStatement.setLong(1, longId);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                if (resultSet.next()) {
                    shop.setId(resultSet.getLong(1));
                    shop.setName(resultSet.getString(2));
                    shop.setType(resultSet.getString(3));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shop;
    }


    public List<Shop> showAllShops(Shop shop) {
        List<Shop> shops = new ArrayList<>();
        try {
            preparedStatement = conn.prepareStatement(ALL_SHOPS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                shop.setId(resultSet.getLong("id"));
                shop.setName(resultSet.getString("name_shop"));
                shop.setName(resultSet.getString("type_shop"));
                shops.add(shop);
                System.out.println("shop = " + shop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shops;
    }

    public List<String> showDepartmentAndShop(Long id) {
        List<String> departments = new ArrayList<>();
        try {
            preparedStatement = conn.prepareStatement(
                    "SELECT department.name_dep, department.type_dep FROM department " +
                            "JOIN shop ON shop.id = department.shop_id" +
                            "WHERE shop.id = ?"

            );
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                departments.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!departments.isEmpty()) {
            return departments;
        }

        return null;
    }

}
