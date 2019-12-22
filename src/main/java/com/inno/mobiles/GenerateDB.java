package com.inno.mobiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GenerateDB {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/mobile_servlets";
    private static final String JDBC_USERNAME = "postgres";
    private static final String JDBC_PASSWORD = "postgres";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeQuery("create table if not exists mobile\n" +
                    "(\n" +
                    "    id           bigserial    not null\n" +
                    "        constraint mobile_pkey\n" +
                    "            primary key,\n" +
                    "    model        varchar(100) not null,\n" +
                    "    price        integer      not null,\n" +
                    "    manufacturer varchar(100) not null\n" +
                    ");\n" +
                    "\n" +
                    "alter table mobile\n" +
                    "    owner to postgres;\n" +
                    "\n" +
                    "create table if not exists users\n" +
                    "(\n" +
                    "    id       serial  not null\n" +
                    "        constraint users_pk\n" +
                    "            primary key,\n" +
                    "    name     varchar not null,\n" +
                    "    password text    not null,\n" +
                    "    email    varchar,\n" +
                    "    phone    varchar\n" +
                    ");\n" +
                    "\n" +
                    "alter table users\n" +
                    "    owner to postgres;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
