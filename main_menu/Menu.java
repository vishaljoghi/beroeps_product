package main_menu;

import java.util.InputMismatchException;
import java.sql.SQLException;
import java.util.Scanner;

import database_connector.JDBC;
import game_code.gameCode;

public class Menu {
    public void mainMenu() throws InterruptedException {
        String[] menu = {
            "      Menu ",
            "----------------",
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
                Animations.border();
                switch (option) {
                    case 1:
                        gameCode g = new gameCode();
                        g.game();
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
                System.out.println("InputMismatchException in mainMenu: " + e);
                Animations.menuExeption();
            }
            catch (Exception e) {
                System.out.println("Exeption in mainMenu: " + e);
                enterReturn();
            }
        }
    }

    private void printScoreboard() throws SQLException {
        String[] scoreboard = {
            "  ~ Leaderboard ~",
            " "
        };
        for (String i : scoreboard) {
            System.out.println(i);
        }
        JDBC j = new JDBC();
        j.printUsers();
        System.out.println();
        enterReturn();
    }

    private void printCredits() {
        String[] credits = {
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
        Animations.border();
        // scan.close();
    }

    public static void enterContinue() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Press 'Enter' to continue.");
        scan.nextLine();
        Animations.border();
        // scan.close();
    }
}
