package main_menu;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.InputMismatchException;
import java.util.Scanner;

import database_connector.JDBC;

public class SubMenu {
    protected void manageAccount() {
        String[] options = {
            "  Manage Account",
            "------------------",
            "1. Switch account",
            "2. Create Account",
            "3. Edit Account",
            "4. Return",
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
            LoginMenu l = new LoginMenu();
            try {
                option = answer.nextInt();
                Animations.border();
                switch (option) {
                    case 1:
                        l.getCred();
                        m.mainMenu();
                        break;
                    case 2:
                        l.enterCred();
                        Menu.enterContinue();
                        break;
                    case 3:
                        editCred();
                        m.mainMenu();
                        break;
                    case 4:
                        m.mainMenu();
                        break;
                }
                
            }
            catch (InputMismatchException e) {
                System.out.println("InputMismatchException in subMenu: " + e);
                Animations.border();
                Animations.menuExeption();
                manageAccount();
            }
            catch (Exception e) {
                System.out.println("Exeption in subMenu: " + e);
                Animations.border();
                Menu.enterReturn();
            }
        }
        
    }

    protected void editCred() {
        Scanner userCred = new Scanner(System.in);
        String[] options = {
            "     Account details",
            "-------------------------",
            "1. Username:  " + LoginMenu.getUsername(),
            "2. Birthdate: " + LoginMenu.getBirthdate(),
            "3. Password:  " + LoginMenu.getPassword(),
            "4. Return",
            " "
        };
        int option;
        for (String i : options) {
        System.out.println(i);
        }
        System.out.print("Choose your option: ");
        Scanner answer = new Scanner(System.in);
        JDBC j = new JDBC();
        try {
            option = answer.nextInt();
            Animations.border();
            switch (option) {
                case 1:
                    System.out.print("New username: ");
                    LoginMenu.setDbUsername(userCred.nextLine());
                    Animations.border();
                    try {
                        LoginMenu.setDbBirthdate(LoginMenu.getBirthdate());
                        LoginMenu.setDbPassword(LoginMenu.getPassword());
                        j.editUser();
                    }
                    catch (SQLIntegrityConstraintViolationException e) {
                        System.out.println("Username already taken." + "\r\n");
                        Menu.enterContinue();
                        editCred();
                    }
                    catch (Exception e) {
                        System.out.println("exeption in subMenu.editCred: " + e);
                        // e.printStackTrace();
                    }
                    LoginMenu.setUsername(LoginMenu.getDbUsername());
                    editCred();
                    break;
                case 2:
                    System.out.print("New birthdate: ");
                    LoginMenu.setDbBirthdate(userCred.nextLine());
                    Animations.border();
                    try {
                        LoginMenu.setDbUsername(LoginMenu.getUsername());
                        LoginMenu.setDbPassword(LoginMenu.getPassword());
                        j.editUser();
                    }
                    catch (Exception e) {
                        System.out.println("Incorrect date or format." + "\r\n" 
                                         + "Format: yyyy-mm-dd" + "\r\n" 
                                         + "   e.g: 2000-12-30" + "\r\n");
                        Menu.enterContinue();
                        editCred();
                    }
                    LoginMenu.setBirthdate(LoginMenu.getDbBirthdate());
                    editCred();
                    break;
                case 3:
                    System.out.print("\r\n" + "New password: ");
                    LoginMenu.setDbPassword(userCred.nextLine());
                    Animations.border();
                    try {
                        LoginMenu.setDbUsername(LoginMenu.getUsername());
                        LoginMenu.setDbBirthdate(LoginMenu.getBirthdate());
                        j.editUser();
                    }
                    finally {}
                    LoginMenu.setPassword(LoginMenu.getDbPassword());
                    editCred();
                    break;
                case 4:
                    manageAccount();
                    Animations.border();
                    break;
            }
        }
        catch (InputMismatchException e) {
            System.out.println("subMenu.editCred: " + e);
            Animations.border();
            Animations.menuExeption();
            editCred();
        }
        catch (Exception e) {
            System.out.println("subMenu.editCred: " + e);
            Animations.border();
            Menu.enterReturn();
            editCred();
        }
        
    }
}
