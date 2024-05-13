package br.com.alura.bytebank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    public static void main(String[] args) {
        String userDB = System.getenv("MYSQL_USERNAME");
        String passwordDB = System.getenv("MYSQL_PASSWORD");

        try {
            Connection connection = DriverManager.getConnection(
                    String.format( "jdbc:mysql://localhost:3306/byte_bank?user=%s&password=%s", userDB, passwordDB)
            );

            System.out.println("Connection with the Database OPEN");

            connection.close();

        } catch (SQLException exception){
            System.out.println("Failure to connect with the Database: " + exception);
        }

    }
}
