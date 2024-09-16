package br.com.alura.bytebank;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection recuperarConexao(){
        try {
            return createDataSource().getConnection();
        } catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    private HikariDataSource createDataSource(){
        String userDB = System.getenv("MYSQL_USERNAME");
        String passwordDB = System.getenv("MYSQL_PASSWORD");

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/byte_bank");
        config.setUsername(userDB);
        config.setPassword(passwordDB);
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }
}
