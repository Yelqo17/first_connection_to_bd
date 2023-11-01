package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
public class MyConnect {
    private final String url;
    private final String user;
    private final String password;
    public MyConnect(){
        url = "jdbc:postgresql://localhost:5432/postgres";
        user = "postgres";
        password = "pig51423";
    }
    public void executeSelect(String select){
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            System.out.printf("%-20s%-20s%-20s\n", "Ревизионный номер", "Тип изделия", "Адрес расположения");

            while (resultSet.next()) {
                String num = resultSet.getString("Ревизионный номер");
                String type = resultSet.getString("Тип изделия");
                String address = resultSet.getString("Адрес расположения");

                System.out.printf("%-20s%-20s%-20s\n", num, type, address);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            System.out.println("Cannot connect to DB: " + ex.getMessage());
        }
    }
}
