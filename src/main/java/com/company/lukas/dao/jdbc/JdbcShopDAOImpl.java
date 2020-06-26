package company.lukas.dao.jdbc;

import company.lukas.dao.ShopDAO;
import company.lukas.model.Shop;
import java.sql.ResultSet;
import java.sql.SQLException;

import static company.lukas.util.ConnectionJDBC.*;

public class JdbcShopDAOImpl implements ShopDAO {
    private static final String INSERT_NEW = "INSERT INTO shop (id, name_shop, type_shop) VALUE (?,?,?)";
    private static final String UPDATE_ROW = "UPDATE shop SET name_shop =?, type_shop = ? where id = ?";
    private static final String GET_BY_ID = "SELECT * FROM shop WHERE id=?";


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
}
