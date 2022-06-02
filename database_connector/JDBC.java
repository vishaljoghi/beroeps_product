package database_connector;

import java.sql.*;

import game_code.gameCode;
import main_menu.LoginMenu;

public class JDBC {
    public void getUser() throws Exception {
        Connection conn = getConnection();
        try {
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT id_players, username, birthdate, password FROM players "
            + "WHERE username = '" + LoginMenu.getUsername() + "' AND password = '" + LoginMenu.getPassword() + "';");
            
            while (results.next()) {
                LoginMenu.setDbPlayerId(results.getString("id_players"));
                LoginMenu.setDbUsername(results.getString("username"));
                LoginMenu.setDbBirthdate(results.getString("birthdate"));
                LoginMenu.setDbPassword(results.getString("password"));
            }
        }
        finally {}
        conn.close();
    }

    public void insertUsers() throws Exception {
        Connection conn = getConnection();
        try {
            Statement statement = conn.createStatement();
            String query = ("INSERT INTO players (username, birthdate, password) "
            + "VALUES ('"+ LoginMenu.getDbUsername() + "', '" + LoginMenu.getDbBirthdate() + "', '" + LoginMenu.getDbPassword() +"');");
            statement.executeUpdate(query);
        }
        finally {}
        conn.close();
    }

    public void editUser() throws Exception {
        Connection conn = getConnection();
        try {
            Statement statement = conn.createStatement();
            String query = ("UPDATE players SET username = '" + LoginMenu.getDbUsername() + "', birthdate = '" + LoginMenu.getDbBirthdate() 
                                + "', password = '" + LoginMenu.getDbPassword() + "' WHERE username = '" + LoginMenu.getUsername() + "';");
            statement.executeUpdate(query);
        }
        finally {}
        conn.close();
    }

    public void printUsers() throws SQLException {
        Connection conn = getConnection();
        try {
            Statement statement = conn.createStatement();
            ResultSet results =  statement.executeQuery("SELECT username, score FROM scoreboard " 
            + "INNER JOIN players ON scoreboard.id_players=players.id_players ORDER BY score DESC LIMIT 10;");

            while (results.next()) {
                String username = results.getString("username");
                String score = results.getString("score");
                // System.out.printf("%-14s%-5s\n","Player","Score");
                System.out.printf("%-16s%-8s\n",username, score);
            }
        }
        catch (SQLException e) {
            System.out.println("Could not retrieve data from the database " + e.getMessage());
        }
        conn.close();
    }

    public void insertScore() {
        Connection conn = getConnection();
        try {
            Statement statement = conn.createStatement();
            String query = ("INSERT INTO scoreboard (id_players, time, score) "
            + "VALUES (" + LoginMenu.getDbPlayerId() + ", '" + gameCode.getDateTime() + "', " + gameCode.getScore() + ");");
            statement.executeUpdate(query);
        }
        catch (Exception e) {
            System.out.println("Exception in insertScore: " + e);
        }
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
