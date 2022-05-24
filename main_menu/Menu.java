package main_menu;

import java.sql.SQLException;
import java.util.Scanner;
import database_connector.JDBC;

public class Menu {
    public void mainMenu() {
        String[] options = {
            "Memory",
            " ",
            "1. Login & Play",
            "2. Account",
            "3. Leaderboard",
            "4. Credits",
            "5. Exit"
        };
        int option;
        while (true) {
            Scanner answer = new Scanner(System.in);
            for (String menu : options)
            System.out.println(menu);

            System.out.print("Choose your option: ");
            try {option = answer.nextInt();
                switch (option) {
                    case 1:
                        playGame();
                        break;
                    case 2:
                        manageAccount();
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
                
            } catch (Exception e) {
                System.out.println("Pls enter an option number.");
            }
        }
    }
    static void playGame () {
        System.out.println("Coming soon...");
        System.out.println();

        Scanner scan = new Scanner(System.in);
        System.out.print("Press 'Enter' to return.");
        scan.nextLine();
    }

    static void manageAccount() {
        String[] subMenu = {
            " ",
            "1. Create Account",
            "2. Edit Account",
            " "
        };
        for (String i : subMenu) {
            System.out.println(i);
        }
        // System.out.println("Work in progress...");
        // System.out.println();

        Scanner scan = new Scanner(System.in);
        System.out.print("Press 'Enter' to return.");
        scan.nextLine();
    }

    static void printScoreboard() throws SQLException {
        System.out.println("  ~ Leaderboard ~");

        JDBC conn1 = new JDBC();
        conn1.printUsers();

        Scanner scan = new Scanner(System.in);
        System.out.print("Press 'Enter' to return.");
        scan.nextLine();
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
        Scanner scan = new Scanner(System.in);
        System.out.print("Press 'Enter' to return.");
        scan.nextLine();
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
        //Thread.sleep(2000);
        System.exit(0);
    }
}
