package com.inno.mobiles.service;

import com.inno.mobiles.exception.InternalServerErrorException;
import com.inno.mobiles.pojo.Mobile;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MobileServiceImpl implements MobileService {

    private DataSource dataSource;

    public MobileServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
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
            ResultSet resultSet = st.executeQuery("SELECT * FROM mobile ORDER BY\n" +
                    "   id ASC;");
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

    public void updateMobileByID(Mobile mobile) {
        try (Connection c = dataSource.getConnection()) {

            String sql = "UPDATE mobile SET model='" + mobile.getModel() + "', price='" +
                    mobile.getPrice() + "', manufacturer='" + mobile.getManufacturer() +
                    "' WHERE id=" + mobile.getId();
            Statement st = c.createStatement();
            st.execute(sql);
            c.commit();
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }
    }

    public void addMobile(Mobile mobile) {
        try (Connection c = dataSource.getConnection()) {
            String sql = "INSERT INTO mobile VALUES (default ,'" + mobile.getModel() + "','" +
                    mobile.getPrice() + "', '" + mobile.getManufacturer() +
                    "')";
            Statement st = c.createStatement();
            st.execute(sql);
            c.commit();
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute sql query: " + e.getMessage(), e);
        }
    }


}
