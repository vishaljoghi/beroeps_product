package database_connector;

import java.sql.*;

import main_menu.Menu;
import main_menu.SubMenu;

public class JDBC {
    public void getUser(String username, String password) throws SQLException {
        Connection conn = getConnection();
        SubMenu cred = new SubMenu();
        try {
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT username, password FROM players "
                        + "WHERE username = '" + username + "' AND password = '" + password + "';");
            
            while (results.next()) {
                String getUsername = results.getString("username");
                // String getBirthdate = results.getString("birthdate");
                String getPassword = results.getString("password");

                // cred.getCred(getUsername, getPassword);

                if (username.equals(getUsername) && password.equals(getPassword)) {
                    System.out.println("login succesfull");
                    Menu.enterReturn();
                }
                else {
                    System.out.println("Incorrect login credentials.");
                    Menu.enterReturn();
                }
            }
        }
        catch (Exception e) {
            System.out.println();
        }
        conn.close();
    }

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
                + "VALUES ('"+ username + "', '" + birthdate + "', '" + password +"');");
            statement.executeUpdate(query);
            System.out.println("Registration successful.");
        }
        catch (Exception e) {
            System.out.println();
            System.out.println("Please try another username.");
        }
        conn.close();
    }

    public void editUser(String newUsername, String newBirthdate, String newPassword, String username) throws SQLException {
        Connection conn = getConnection();
        try {
            Statement statement = conn.createStatement();
            // String newUsername = "_MOW_";
            // String newUsername = "TestUserEdit";
            // String newBirthdate = "0000-00-00";
            // String newPassword = "PaswEdit";
            // String username = "TestUserEdit";
            // String username = "_MOW_";
            String query = ("UPDATE players SET username = '" + newUsername + "', birthdate = '" + newBirthdate 
                                + "', password = '" + newPassword + "' WHERE username = '" + username + "'");
            statement.executeUpdate(query);
            System.out.println("Change successful.");
        }
        catch (Exception e) {
            System.out.println(e);
            System.out.println("Please try another username.");
        }
        conn.close();
    }

    public void printUsers() throws SQLException {
        Connection conn = getConnection();
        try {
            Statement statement = conn.createStatement();
            ResultSet results =  statement.executeQuery("SELECT username, score FROM scoreboard " 
                            + "INNER JOIN players ON scoreboard.id_players=players.id_players LIMIT 10;");

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
