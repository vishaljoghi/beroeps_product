package main_menu;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import database_connector.JDBC;

public class LoginMenu {
    public void loginMenu() {
        String[] menu = {
            "   Welcome",
            "-------------",
            "1. Login",
            "2. Register",
            "3. Help",
            "4. Exit",
            " "
        };
        int option;
        Animations.border();
        while (true) {
            for (String i : menu) {
            System.out.println(i);
            }
            System.out.print("Your option: ");
            Scanner answer = new Scanner(System.in);
            try {
                option = answer.nextInt();
                Animations.border();
                switch (option) {
                    case 1:
                        getCred();
                        break;
                    case 2:
                        enterCred();
                        break;
                    case 3:
                        help();
                        break;
                    case 4:
                        Menu.exitMenu();
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("Exeption loginMenu: " + e);
                Animations.border();
                Animations.menuExeption();
                loginMenu();
            }
        }
        
    }

    public void getCred() {
        Scanner userCred = new Scanner(System.in);
        try {
            System.out.println("       ~ Login ~" + "\r\n");
            System.out.print("Username: ");
            setUsername(userCred.nextLine());
            System.out.print("Password: ");
            setPassword(userCred.nextLine());

            JDBC j = new JDBC();
            j.getUser();

            if (LoginMenu.getUsername().equals(LoginMenu.getDbUsername()) && LoginMenu.getPassword().equals(LoginMenu.getDbPassword())) {
                System.out.println("\r\n" + "Login succesfull" + "\r\n");
                setBirthdate(getDbBirthdate());
                Menu.enterContinue();
                Animations.welcomeMessage();
                Menu m = new Menu();
                m.mainMenu();
            }
            else {
                System.out.println("\r\n" + "\r\n" + "Incorrect login credentials." + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "\r\n");
                Menu.enterReturn();
                loginMenu();
            }
        }
        catch (Exception e) {
            System.out.println("Exeption in loginMenu.getCred: " + e);
        }
    }

    public void enterCred() {
        Scanner userCred = new Scanner(System.in);
        try {
            System.out.println("        ~ register ~" + "\r\n");
            System.out.print("Usernames need to be unique," + "\r\n" 
                           + "so be creative." + "\r\n" 
                           + "Max 15 characters." + "\r\n" + "\r\n"
                           + "Username: ");
            setDbUsername(userCred.nextLine());
            System.out.print("-----------------------------" + "\r\n" + "\r\n" 
                           + "Please use the following" + "\r\n" 
                           + "  format: yyyy-mm-dd" + "\r\n" + "\r\n"
                           + "Birthdate: ");
            setDbBirthdate(userCred.nextLine());
            System.out.print("-----------------------------" + "\r\n" + "\r\n" 
                           + "To make a stong password:" + "\r\n" 
                           + "use Caps, Numbers & Symbols." + "\r\n" + "\r\n"
                           + "Password: ");
            setDbPassword(userCred.nextLine());

            JDBC j = new JDBC();
            j.insertUsers();

            System.out.println("\r\n" + "Registration successful."+ "\r\n");
            Menu.enterContinue();
        }
        catch (SQLIntegrityConstraintViolationException e) {
            Animations.border();
            System.out.println("Please try another username." + "\r\n");
            Menu.enterReturn();
        }
        catch (MysqlDataTruncation e) {
            Animations.border();
            System.out.println("Incorrect date or format." + "\r\n" 
                             + "Format: yyyy-mm-dd" + "\r\n" 
                             + "   e.g: 2000-12-30" + "\r\n");
            Menu.enterReturn();
        }
        catch (Exception e) {
            Animations.border();
            System.out.println("Exeption in LoginMenu.enterCred: " + e);
        }
    }
    
    public void help() {
        String[] help = {
            "~ Login instructions ~",
            " ",
            "'Login' to continue and play.",
            " ",
            "'Register' to ceate an account,",
            " then login",
            " ",
            " "
        };
        for (String i : help) {
            System.out.println(i);
        }
        Menu.enterReturn();
    }

    private static String username;
    private static String birthdate;
    private static String password;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String newUsername) {
        username = newUsername;
    }

    public static String getBirthdate() {
        return birthdate;
    }

    public static void setBirthdate(String newBirthdate) {
        birthdate = newBirthdate;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String newPassword) {
        password = newPassword;
    }

    private static String dbUsername;
    private static String dbBirthdate;
    private static String dbPassword;
    private static String dbPlayerId;

    public static String getDbUsername() {
        return dbUsername;
    }

    public static void setDbUsername(String newDbUsername) {
        dbUsername = newDbUsername;
    }

    public static String getDbBirthdate() {
        return dbBirthdate;
    }

    public static void setDbBirthdate(String newDbBirthdate) {
        dbBirthdate = newDbBirthdate;
    }

    public static String getDbPassword() {
        return dbPassword;
    }

    public static void setDbPassword(String newDbPassword) {
        dbPassword = newDbPassword;
    }

    public static String getDbPlayerId() {
        return dbPlayerId;
    }

    public static void setDbPlayerId(String newDbPlayerId) {
        dbPlayerId = newDbPlayerId;
    }
}
