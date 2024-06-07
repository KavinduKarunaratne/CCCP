package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ItemDAOImpl implements DAOInterface<ItemDTO> {

    @Override
    public ItemDTO get(String code) throws SQLException {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        Connection connection = dbConnection.getConnection();

        ItemDTO item = null;

        String sql = "select id, code, name, quantity, price from shelf where code= ?";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1,code);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int oid = rs.getInt("id");
            String itemCode = rs.getString("code");
            String itemName = rs.getString("name");
            int itemQuantity = rs.getInt("quantity");
            int itemPrice = rs.getInt("price");

            item = new ItemDTO(oid, itemCode, itemName, itemQuantity, itemPrice);


        }

        return item;
    }

    @Override
    public List<ItemDTO> getAll() throws SQLException {
        return null;
    }

    @Override
    public int save(ItemDTO itemDTO) throws SQLException {
        return 0;
    }

    @Override
    public int insert(ItemDTO itemDTO) throws SQLException {
        return 0;
    }

    @Override
    public int update(ItemDTO itemDTO) throws SQLException {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        Connection connection = dbConnection.getConnection();

        String sql = "update shelf set id = ?, code = ?, name = ?, quantity = ?, price = ? where id = ?";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1,itemDTO.getId());
        ps.setString(2,itemDTO.getCode());
        ps.setString(3,itemDTO.getName());
        ps.setInt(4, itemDTO.getQuantity());
        ps.setInt(5, itemDTO.getPrice());
        ps.setInt(6, itemDTO.getId());

        int result = ps.executeUpdate();

        dbConnection.closeConnection();
        return result;
    }

    @Override
    public int delete(ItemDTO itemDTO) throws SQLException {
        return 0;
    }
}
