package main_menu;

import database_connector.*;

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
                    userData();
                    Menu.enterReturn();
                    // Menu i = new Menu(); //NoElement test
                    // i.mainMenu();
                    break;
                case 2:
                    System.out.println("Work in progress!!");
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

    public static void userData() {
        try (Scanner userData = new Scanner(System.in)) {
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
            System.out.println(i[9] + "\r\n" + i[9] + "\r\n" +i[9]);
            System.out.print(i[0] + "\r\n" + i[1] + "\r\n" + i[9] + "\r\n" 
                            + i[9] + "\r\n" + i[9] + "\r\n" + i[9] + i[2]);
            String username = userData.nextLine();

            System.out.println(i[9] + "\r\n" + i[9] + "\r\n" +i[9]);
            System.out.print(i[3] + "\r\n" + i[4] + "\r\n" + i[9] + "\r\n" 
                            + i[9] + "\r\n" + i[9] + "\r\n" + i[9] + i[5]);
            String birthdate = userData.nextLine();
            
            System.out.println(i[9] + "\r\n" + i[9] + "\r\n" +i[9]);
            System.out.print(i[6] + "\r\n" + i[7] + "\r\n" + i[9] + "\r\n" 
                            + i[9] + "\r\n" + i[9] + "\r\n" + i[9] + i[8]);
            String password = userData.nextLine();
    
            JDBC data = new JDBC();
            data.insertUsers(username, birthdate, password);
        }
        catch (Exception e) {
            System.out.println("Exeption: " + e.getMessage());
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
