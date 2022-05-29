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
            "1. Switch account",
            "2. Create Account",
            "3. Edit Account",
            "4. Forgot Acc",
            "5. Return",
            " "
        };
        int option;
        while (true) {
            for (String subMenu : options) {
            System.out.println(subMenu);
            }
            System.out.print("Choose your option: ");
            Scanner answer = new Scanner(System.in);
            Menu m = new Menu();
            JDBC j = new JDBC();
            try {
                option = answer.nextInt();
                switch (option) {
                    case 1:
                        j.getUser();
                        m.mainMenu();
                        break;
                    case 2:
                        j.insertUsers();
                        Menu.enterContinue();
                        break;
                    case 3:
                        j.editUser();
                        j.getUser();
                        m.mainMenu();
                        break;
                    case 4:
                        lostAcc();
                        Menu.enterReturn();
                        break;
                    case 5:
                        m.mainMenu();
                        break;
                }
                
            }
            catch (InputMismatchException e) {
                System.out.println("Exeption: " + e);
                Animations.menuExeption();
                manageAccount();
            }
            catch (Exception e) {
                System.out.println("Exeption in subMenu: " + e);
                Menu.enterReturn();
            }
        }
        
    }

    public void editCred() {
        Scanner userCred = new Scanner(System.in);
        String[] i = {
            "New username: ",
            "New birthdate: ",
            "New password: "
        };
        try {
            System.out.println(i[0]);
            LoginMenu.setDbUsername(userCred.nextLine());
            System.out.println(i[1]);
            LoginMenu.setDbBirthdate(userCred.nextLine());
            System.out.println(i[2]);
            LoginMenu.setDbPassword(userCred.nextLine());
        }
        catch (Exception e) {
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
