package com.inno.mobiles.service;

import com.inno.mobiles.exception.InternalServerErrorException;
import com.inno.mobiles.pojo.Mobile;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MobileService {

    private DataSource dataSource;

    public MobileService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void updateMobileByID(Mobile mobile) {
        try (Connection c = dataSource.getConnection()) {

            String sql = "UPDATE mobile SET model=?, price=?, manufacturer=? WHERE id=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, mobile.getModel());
            ps.setInt(2, mobile.getPrice());
            ps.setString(3, mobile.getManufacturer());
            ps.setInt(4, mobile.getId());
            ps.executeUpdate();
            c.commit();
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }
    }

    public Mobile getMobileById(int id) {
        try (Connection c = dataSource.getConnection()) {
            Statement st = c.createStatement();
            String sql = "SELECT * FROM mobile WHERE id=" + id;
            ResultSet resultSet = st.executeQuery(sql);
            if (resultSet.next()) {
                return new Mobile(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4));
            }
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }
        return null;
    }

    public List<Mobile> listAllProducts() {
        List<Mobile> result = new ArrayList<>();
        try (Connection c = dataSource.getConnection()) {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM mobile");
            while (resultSet.next()) {
                result.add(new Mobile(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4)));
            }
            return result;
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }

    }


}
