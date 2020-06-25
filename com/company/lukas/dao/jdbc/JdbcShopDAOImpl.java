package company.lukas.dao.jdbc;

import company.lukas.dao.ShopDAO;
import company.lukas.model.Shop;
import company.lukas.util.ConnectionJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcShopDAOImpl implements ShopDAO {
    private static final String INSERT_NEW = "INSERT INTO shop (id, name_shop, type_shop) VALUE (?,?,?)";
    private static final String UPDATE_ROW = "UPDATE shop SET name_shop =?, type_shop = ? where id = ?";
    private static final String GET_BY_ID = "SELECT * FROM shop WHERE id=?";


    public JdbcShopDAOImpl() {
        try {
            ConnectionJDBC.createConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Shop shop) {
        try {
            ConnectionJDBC.preparedStatement = ConnectionJDBC.conn.prepareStatement(INSERT_NEW);
            ConnectionJDBC.preparedStatement.setLong(1, shop.getId());
            ConnectionJDBC.preparedStatement.setString(2, shop.getName());
            ConnectionJDBC.preparedStatement.setString(3, shop.getType());
            ConnectionJDBC.preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Shop shop) {
        try {
            ConnectionJDBC.preparedStatement = ConnectionJDBC.conn.prepareStatement(UPDATE_ROW);
            ConnectionJDBC.preparedStatement.setString(1, shop.getName());
            ConnectionJDBC.preparedStatement.setString(2, shop.getType());
            ConnectionJDBC.preparedStatement.setLong(3, shop.getId());
            ConnectionJDBC.preparedStatement.executeUpdate();
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
            ConnectionJDBC.preparedStatement = ConnectionJDBC.conn.prepareStatement(GET_BY_ID);
            ConnectionJDBC.preparedStatement.setLong(1, longId);
            try (ResultSet resultSet = ConnectionJDBC.preparedStatement.executeQuery();) {
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
