package database_connector;

import java.sql.*;

public class JDBC {
    // public void getUser() {
    //     Connection conn2 = getConnection();
    //     try {
    //         Statement statement = conn.createStatement();
    //         ResultSet results = statement.executeQuery(sql)
    //     }
    //     catch (Exception e) {
    //         System.out.println();
    //     }
    // }

    // public void writeUser() {
    //     Connection conn = getConnection();
    //     try {
            
    //     }
    //     catch (Exception e) {
    //         System.out.println();
    //     }
    // }

    public void insertUsers(String username, String birthdate, String password) throws SQLException {
        Connection conn = getConnection();
        try {
            Statement statement = conn.createStatement();
            // Menu dat = new Menu();
            // Menu.userData();
            // String password = "h345433u";
            // String username = "wfd5434";
            // String birthdate = "2000-01-01";
            String query = ("INSERT INTO players (username, birthdate, password) "
                + "VALUES ('"+ username + "', '" + birthdate + "', '" + password +"')");
            statement.executeUpdate(query);
            System.out.println("Registration successful.");
        }
        catch (Exception e) {
            System.out.println();
            System.out.println("Please try another username.");
        }
        conn.close();
    }

    public void printUsers() throws SQLException {
        Connection conn = getConnection();
        try {
            Statement statement = conn.createStatement();
            ResultSet results =  statement.executeQuery("SELECT username, score FROM scoreboard " 
                            + "INNER JOIN players ON scoreboard.id_players=players.id_players;");

            while(results.next()) {
                //String id = results.getString("id_players");
                String username = results.getString("username");
                String score = results.getString("score");
                System.out.println(username + " - " + score);
            }
            System.out.println();
        }
        catch (SQLException e) {
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
