package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StockDAOImpl implements DAOInterface<StockDTO> {
    @Override
    public StockDTO get(String code) throws SQLException {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        Connection connection = dbConnection.getConnection();

        StockDTO item = null;

        String sql = "select id, code, name, quantity, price, expiry, purchase from stock where code= ?";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1,code);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int oid = rs.getInt("id");
            String itemCode = rs.getString("code");
            String itemName = rs.getString("name");
            int itemQuantity = rs.getInt("quantity");
            int itemPrice = rs.getInt("price");
            String itemExpiry = rs.getString("expiry");
            String itemPurchase = rs.getString("purchase");

            item = new StockDTO(oid, itemCode, itemName, itemQuantity, itemPrice, itemPurchase, itemExpiry);


        }

        return item;
    }

    @Override
    public List<StockDTO> getAll() throws SQLException {
        return null;
    }

    @Override
    public int save(StockDTO stockDTO) throws SQLException {
        return 0;
    }

    @Override
    public int insert(StockDTO stockDTO) throws SQLException {
        return 0;
    }

    @Override
    public int update(StockDTO stockDTO) throws SQLException {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        Connection connection = dbConnection.getConnection();

        String sql = "update stock set id = ?, code = ?, name = ?, quantity = ?, price = ?, expiry = ?, purchase = ? where id = ?";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1,stockDTO.getId());
        ps.setString(2,stockDTO.getCode());
        ps.setString(3,stockDTO.getName());
        ps.setInt(4, stockDTO.getQuantity());
        ps.setInt(5, stockDTO.getPrice());
        ps.setString(6, stockDTO.getExpiryDate());
        ps.setString(7, stockDTO.getPurchaseDate());
        ps.setInt(8, stockDTO.getId());

        int result = ps.executeUpdate();

        return result;
    }

    @Override
    public int delete(StockDTO stockDTO) throws SQLException {
        return 0;
    }
}
