package main_menu;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import database_connector.JDBC;

public class Menu {
    public void mainMenu() throws InterruptedException {
        String[] menu = {
            "      Menu ",
            " --------------",
            "1. Play as " + LoginMenu.getUsername(),
            "2. Account",
            "3. Leaderboard",
            "4. Credits",
            "5. Exit",
            " "
        };
        int option;
        while (true) {
            for (String i : menu) {
                System.out.println(i);
            }
            System.out.print("Choose your option: ");
            Scanner answer = new Scanner(System.in);
            try {
                option = answer.nextInt();
                switch (option) {
                    case 1:
                        playGame();
                        break;
                    case 2:
                        SubMenu a = new SubMenu();
                        a.manageAccount();
                        break;
                    case 3:
                        printScoreboard();
                        break;
                    case 4:
                        printCredits();
                        break;
                    case 5:
                        exitMenu();
                        break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Exeption: " + e);
                Animations.menuExeption();
            }
            // catch (NoSuchElementException e) {
            //     System.out.println("Exeption: " + e);  //NoElement test
            //     exitMenu();
            // }
            catch (Exception e) {
                System.out.println("Exeption in mainMenu: " + e);
                enterReturn();
            }
        }
    }
    static void playGame () {
        String[] message = {
            "Coming soon..."
        };
        for (String i : message) {
            System.out.println(i);
        }
        enterReturn();
    }

    static void printScoreboard() throws SQLException {
        String[] scoreboard = {
            " ",
            "  ~ Leaderboard ~",
            " "
        };
        for (String i : scoreboard) {
            System.out.println(i);
        }
        JDBC conn = new JDBC();
        conn.printUsers();
        enterReturn();
    }

    static void printCredits() {
        String[] credits = {
            " ",
            "        ~ Developers ~        ",
            "                              ",
            "Cheung  Shahrukh   SE/1121/062",
            "Joghi   Vishal     BI/1121/019",
            "Bonoo   Kevin      BI/1121/004",
            "Kaman   Keano      BI/1121/---",
            " "
        };
        for (String i : credits) {
            System.out.println(i);
        }
        enterReturn();
    }

    static void exitMenu() {
        String[] exitMessage = {
            " ",
            "Thank you for playing!",
            " "
        };
        for (String i : exitMessage) {
            System.out.println(i);
        }
        System.exit(0);
    }

    public static void enterReturn() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Press 'Enter' to return.");
        scan.nextLine();
        // scan.close();
    }

    public static void enterContinue() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Press 'Enter' to continue.");
        scan.nextLine();
        // scan.close();
    }
}
