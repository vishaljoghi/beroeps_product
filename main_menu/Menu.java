package main_menu;

import java.util.Scanner;

import database_connector.JDBC;

public class Menu {
    public void mainMenu() {
        String[] options = {
            " ",
            "1. Login & Play",
            "2. Register",
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
                        System.out.println("Coming soon...");
                        break;
                    case 2:
                        System.out.println("test 2");
                        break;
                    case 3:
                        JDBC conn1 = new JDBC();
                        conn1.printUsers();
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
        Scanner scan = new Scanner(System.in);
        for (String i : credits) {
            System.out.println(i);
        }
        System.out.print("Press 'Enter' to return.");
        scan.nextLine();
    }
    static void exitMenu() {
        System.out.println();
        System.out.println("Thank you for playing!");
        System.out.println();
        //Thread.sleep(2000);
        System.exit(0);
    }
}