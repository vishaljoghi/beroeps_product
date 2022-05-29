package database_connector;

import java.sql.*;

import main_menu.LoginMenu;
import main_menu.Menu;
// import main_menu.SubMenu;
import main_menu.SubMenu;

public class JDBC {
    public void getUser() throws SQLException {
        Connection conn = getConnection();
        LoginMenu l = new LoginMenu();
        l.getCred();
        try {
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT username, password FROM players "
            + "WHERE username = '" + LoginMenu.getUsername() + "' AND password = '" + LoginMenu.getPassword() + "';");
            
            while (results.next()) {
                LoginMenu.setDbUsername(results.getString("username"));
                // cred.setBirthdate(results.getString("birthdate"));
                LoginMenu.setDbPassword(results.getString("password"));
            }
            if (LoginMenu.getUsername().equals(LoginMenu.getDbUsername()) && LoginMenu.getPassword().equals(LoginMenu.getDbPassword())) {
                System.out.println("\r\n" + "\r\n" + "Login succesfull" + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "\r\n");
                Menu.enterContinue();
            }
            else {
                System.out.println("\r\n" + "\r\n" + "Incorrect login credentials." + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "\r\n");
                Menu.enterReturn();
                l.loginMenu();
            }
        }
        catch (Exception e) {
            System.out.println("Exeption in JDBC.getUser: " + e);
        }
        conn.close();
    }

    public void insertUsers() throws SQLException {
        Connection conn = getConnection();
        LoginMenu cred = new LoginMenu();
        cred.enterCred();
        try {
            Statement statement = conn.createStatement();
            String query = ("INSERT INTO players (username, birthdate, password) "
            + "VALUES ('"+ LoginMenu.getDbUsername() + "', '" + LoginMenu.getDbBirthdate() + "', '" + LoginMenu.getDbPassword() +"');");
            statement.executeUpdate(query);
            System.out.println("\r\n"+ "\r\n" + "Registration successful."+ "\r\n"+ "\r\n"+ "\r\n"+ "\r\n"+ "\r\n");
        }
        catch (Exception e) {
            System.out.println("\r\n" + "Please try another username.");
        }
        conn.close();
    }

    public void editUser() throws SQLException {
        Connection conn = getConnection();
        SubMenu s = new SubMenu();
        s.editCred();
        try {
            Statement statement = conn.createStatement();
            String query = ("UPDATE players SET username = '" + LoginMenu.getDbUsername() + "', birthdate = '" + LoginMenu.getDbBirthdate() 
                                + "', password = '" + LoginMenu.getDbPassword() + "' WHERE username = '" + LoginMenu.getUsername() + "'");
            statement.executeUpdate(query);
            System.out.println("\r\n"+ "\r\n" + "Change successful."+ "\r\n"+ "\r\n"+ "\r\n"+ "\r\n"+ "\r\n"+ "\r\n");
            Menu.enterContinue();
        }
        catch (Exception e) {
            System.out.println(e);
            System.out.println("\r\n" + "Please try another username.");
        }
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
