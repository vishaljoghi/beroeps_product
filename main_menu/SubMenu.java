package main_menu;

import database_connector.*;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SubMenu {
    public void manageAccount() {
        String[] options = {
            " ",
            "   Manage Account",
            "-------------------",
            "1. Create Account",
            "2. Edit Account",
            "3. Forgot Acc",
            "4. Return",
            " ",
            " "
        };
        int option;
        for (String subMenu : options) {
            System.out.println(subMenu);
        }
        System.out.print("Choose your option: ");
        Scanner answer = new Scanner(System.in);
        try {
            option = answer.nextInt();
            switch (option) {
                case 1:
                    enterCred();
                    Menu.enterReturn();
                    manageAccount();
                    // Menu i = new Menu(); //NoElement test
                    // i.mainMenu();
                    break;
                case 2:
                    System.out.println("Work in progress!!");
                    getCred();
                    editCred();
                    Menu.enterReturn();
                    manageAccount();
                    break;
                case 3:
                    lostAcc();
                    Menu.enterReturn();
                    manageAccount();
                    break;
                case 4:
                    System.out.println();
                    break;
            }
            
        }
        catch (InputMismatchException e) {
            System.out.println("Exeption: " + e);
            Menu.menuExeption();
            manageAccount();
        }
        catch (Exception e) {
            System.out.println("Exeption in subMenu: " + e);
            Menu.enterReturn();
        }
    }

    public static void enterCred() {
        Scanner userCred = new Scanner(System.in);
        JDBC cred = new JDBC();
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
            " "
        };
        try {
            System.out.println(i[9] + "\r\n" + i[9] + "\r\n" +i[9]);
            System.out.print(i[0] + "\r\n" + i[1] + "\r\n" + i[9] + "\r\n" 
                            + i[9] + "\r\n" + i[9] + "\r\n" + i[9] + i[2]);
            String username = userCred.nextLine();

            System.out.println(i[9] + "\r\n" + i[9] + "\r\n" +i[9]);
            System.out.print(i[3] + "\r\n" + i[4] + "\r\n" + i[9] + "\r\n" 
                            + i[9] + "\r\n" + i[9] + "\r\n" + i[9] + i[5]);
            String birthdate = userCred.nextLine();
            
            System.out.println(i[9] + "\r\n" + i[9] + "\r\n" +i[9]);
            System.out.print(i[6] + "\r\n" + i[7] + "\r\n" + i[9] + "\r\n" 
                            + i[9] + "\r\n" + i[9] + "\r\n" + i[9] + i[8]);
            String password = userCred.nextLine();
    
            cred.insertUsers(username, birthdate, password);
        }
        catch (Exception e) {
            System.out.println("Exeption in submenu.enterData: " + e);
        }
    }

    public void getCred(/*String getUsername, String getPassword*/) {
        Scanner userCred = new Scanner(System.in);
        JDBC cred = new JDBC();
        String[] i = {
            "Username: ",
            "Password: ",
            "login succesfull",
            "Incorrect login credentials.",
            "Please try again.",
            " "
        };
        try {
            System.out.println(i[0]);
            String username = userCred.nextLine();
            System.out.println(i[1]);
            String password = userCred.nextLine();

            cred.getUser(username, password);

            // if (username.equals(getUsername) && password.equals(getPassword)) {
            //     System.out.println("login succesfull");
            //     Menu.enterReturn();
            // }
            // else {
            //     System.out.println("Incorrect login credentials." + "/r/n" + " " + "/r/n" + "Please try again.");
            // }
        }
        catch (Exception e) {
            System.out.println("Exeption in subMenu.getCred: " + e);
        }
    }

    public void editCred() {
        Scanner userCred = new Scanner(System.in);
        JDBC cred = new JDBC();
        String[] i = {
            "New username: ",
            "New birthdate: ",
            "New password: "
        };
        try {
            System.out.println(i[0]);
            String newUsername = userCred.nextLine();
            System.out.println(i[1]);
            String newBirthdate = userCred.nextLine();
            System.out.println(i[2]);
            String newPassword = userCred.nextLine();
            String username = "lo";

            cred.editUser(newUsername, newBirthdate, newPassword, username);
        }
        catch (SQLException e) {
            System.out.println("exeption in subMenu.editData: " + e);
            // e.printStackTrace();
        }
    }

    static void lostAcc() {
        String[] message = {
            " ",
            "       __",
            "  _   / /",
            " (_) | |   Pls make another",
            "  _  | |       account.",
            " (_) | |      ----------",
            "      \\_\\",
            " "
        };
        for (String i : message) {
            System.out.println(i);
        }
    }
}
