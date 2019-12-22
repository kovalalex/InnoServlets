package com.inno.mobiles.service;

import com.inno.mobiles.pojo.Mobile;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MobileService {

    private DataSource dataSource;

    public MobileService(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Mobile> listAllProducts(){
        List<Mobile> result = new ArrayList<>();
        try (Connection c = dataSource.getConnection()) {
            Statement st = c.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM mobile");
            while (resultSet.next()){
                result.add(new Mobile(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4)));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
