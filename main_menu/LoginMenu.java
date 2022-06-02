package main_menu;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import database_connector.JDBC;

public class LoginMenu {
    public void loginMenu() {
        String[] menu = {
            "  ~ Welcome ~",
            " ",
            "1. Login",
            "2. Register",
            "3. Help",
            "4. Exit",
            " ",
            " "
        };
        int option;
        while (true) {
            for (String i : menu) {
            System.out.println(i);
            }
            System.out.print("Your option: ");
            Scanner answer = new Scanner(System.in);
            try {
                option = answer.nextInt();
                switch (option) {
                    case 1:
                        getCred();
                        Animations.welcomeMessage();
                        Menu m = new Menu();
                        m.mainMenu();
                        break;
                    case 2:
                        enterCred();
                        Menu.enterReturn();
                        break;
                    case 3:
                        help();
                        Menu.enterReturn();
                        break;
                    case 4:
                        Menu.exitMenu();
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("Exeption loginMenu: " + e);
                Animations.menuExeption();
                loginMenu();
            }
        }
        
    }

    public void getCred() {
        Scanner userCred = new Scanner(System.in);
        String[] i = {
            "Username: ",
            "Password: ",
            "login succesfull",
            "Incorrect login credentials.",
            "Please try again.",
            " "
        };
        try {
            System.out.println("\r\n" + "\r\n" + "\r\n" 
                             + "\r\n" + "\r\n" + "\r\n");
            System.out.print("\r\n" + i[0]);
            setUsername(userCred.nextLine());
            System.out.print("\r\n" + i[1]);
            setPassword(userCred.nextLine());

            JDBC j = new JDBC();
            j.getUser();

            if (LoginMenu.getUsername().equals(LoginMenu.getDbUsername()) && LoginMenu.getPassword().equals(LoginMenu.getDbPassword())) {
                System.out.println("\r\n" + "\r\n" + "Login succesfull" + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "\r\n");
                setBirthdate(getDbBirthdate());
                Menu.enterContinue();
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
        String[] i = {
            "Usernames need to be unique,",
            "so be creative.",
            "Username: ",
            "Please use the following",
            "  format: yyyy-mm-dd",
            "Birthdate: ",
            "Tips for making a stong password:",
            "use Caps, Numbers & Symbols.",
            "Password: ",
            "Max 15 characters."
        };
        try {
            System.out.print("\r\n" + "\r\n" + i[0] + "\r\n" + i[1] + "\r\n" + i[9] + "\r\n" + "\r\n" + "\r\n" + "\r\n" + i[2]);
            setDbUsername(userCred.nextLine());
            System.out.print("\r\n" + "\r\n" + "\r\n" + "\r\n" + i[3] + "\r\n" + i[4] + "\r\n" + "\r\n" + "\r\n" + "\r\n" + i[5]);
            setDbBirthdate(userCred.nextLine());
            System.out.print("\r\n" + "\r\n" + i[6] + "\r\n" + i[7] + "\r\n" + i[9] + "\r\n" + "\r\n" + "\r\n" + "\r\n" + i[8]);
            setDbPassword(userCred.nextLine());

            JDBC j = new JDBC();
            j.insertUsers();

            System.out.println("\r\n"+ "\r\n" + "Registration successful."+ "\r\n"+ "\r\n"+ "\r\n"+ "\r\n"+ "\r\n");
        }
        catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("\r\n" + "Please try another username." + "\r\n");
            Menu.enterContinue();
            enterCred();
        }
        catch (MysqlDataTruncation e) {
            System.out.println("\r\n" + "\r\n" + "Incorrect date or format." + "\r\n" 
                    + "Format: yyyy-mm-dd" + "\r\n" + "   e.g: 2000-12-30" + "\r\n");
            Menu.enterContinue();
            enterCred();
        }
        catch (Exception e) {
            System.out.println("Exeption in LoginMenu.enterCred: " + e);
        }
    }
    
    public void help() {
        String[] help = {
            "~ Login instructions ~",
            " ",
            "'Login' to continue and play.",
            " ",
            "'Register' if you do not have an account,",
            " then login",
            " ",
            " "
        };
        for (String i : help) {
            System.out.println(i);
        }
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
