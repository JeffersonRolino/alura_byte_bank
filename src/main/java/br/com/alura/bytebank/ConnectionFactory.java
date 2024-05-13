package br.com.alura.bytebank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection recuperarConexao(){
        String userDB = System.getenv("MYSQL_USERNAME");
        String passwordDB = System.getenv("MYSQL_PASSWORD");

        try {
            return DriverManager.getConnection(
                    String.format( "jdbc:mysql://localhost:3306/byte_bank?user=%s&password=%s", userDB, passwordDB)
            );
        } catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }
}
