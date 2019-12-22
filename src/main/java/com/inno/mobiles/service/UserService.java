package com.inno.mobiles.service;

import com.inno.mobiles.exception.InternalServerErrorException;
import com.inno.mobiles.pojo.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {
    private DataSource dataSource;

    public UserService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User getUserByNamePassword(String name, String password) {
        try (Connection c = dataSource.getConnection()) {
            Statement st = c.createStatement();
            String sql = "SELECT * FROM users WHERE name ='" + name + "' AND password ='" + password + "'";
            ResultSet resultSet = st.executeQuery(sql);
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5));
            }
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }
        return null;
    }
}
