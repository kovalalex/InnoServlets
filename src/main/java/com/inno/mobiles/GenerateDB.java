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
            statement.execute("DROP TABLE IF EXISTS mobile;" +
                    "create table mobile\n" +
                    "(\n" +
                    "    id           bigserial    not null\n" +
                    "        constraint mobile_pkey\n" +
                    "            primary key,\n" +
                    "    model        varchar(100) not null,\n" +
                    "    price        integer      not null,\n" +
                    "    manufacturer varchar(100) not null\n" +
                    ");\n" +
                    "INSERT INTO mobile (id, model, price, manufacturer) VALUES (default , 'ai-234', 700, 'Apple');\n" +
                    "INSERT INTO mobile (id, model, price, manufacturer) VALUES (default , 'ai-235', 300, 'SONY');\n" +
                    "INSERT INTO mobile (id, model, price, manufacturer) VALUES (default , 'vz-12', 200, 'SONY');" +
                    "\n" +
                    "alter table mobile\n" +
                    "    owner to postgres;\n" +
                    "\n" +
                    "DROP TABLE IF EXISTS users;" +
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
                    "    owner to postgres;" +
                    "INSERT INTO users (id, name, password, email, phone) VALUES (1, 'user', 'user', '1@1.ru', '+45435345');");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
