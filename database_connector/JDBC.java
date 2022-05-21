package database_connector;

import java.sql.*;

public class JDBC {
    public void printUsers() throws SQLException {
        Connection conn = getConnection();
        try {
            Statement statement = conn.createStatement();
            ResultSet results =  statement.executeQuery("SELECT * FROM players;");
            //System.out.println();
            while(results.next()) {
                String id = results.getString("id_players");
                String username = results.getString("username");
                String password = results.getString("password");
                System.out.println(id + " - " + username + " - " + password);
            }
        } catch (SQLException e) {
            System.out.println("Could not retrieve data from the database " + e.getMessage());
        }
        conn.close();
    }
    static Connection getConnection() {
        try {
            String serverName = "localhost";
            String schema = "game";       //database naam invullen 
            String url = "jdbc:mysql://" + serverName +  "/" + schema;
            String username = "user";       // username invullen
            String password = "user";       // password invullen
            return DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e) {
            System.out.println("Could not connect to the database " + e.getMessage());
        }
        return null;
    }
}
