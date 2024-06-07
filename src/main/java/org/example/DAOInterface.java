package org.example;

import java.util.List;
import java.sql.SQLException;

public interface DAOInterface<T> {
    // Get item
    T get(String code) throws SQLException;
    // Get items
    List<T> getAll() throws SQLException;
    // Save
    int save(T t) throws SQLException;
    // Insert
    int insert(T t) throws SQLException;
    // Update
    int update(T t) throws SQLException;
    //Delete
    int delete(T t) throws SQLException;

}
