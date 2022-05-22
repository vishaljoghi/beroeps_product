package main_menu;

import java.util.Scanner;

import database_connector.JDBC;

public class Menu {
    public void mainMenu() {
        String[] options = {"1. Login & Play",
                            "2. Register",
                            "3. Leaderboard",
                            "4. Exit"
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
                        System.out.println("test 1");
                        break;
                    case 2:
                        System.out.println("test 2");
                        break;
                    case 3:
                        JDBC conn1 = new JDBC();
                        conn1.printUsers();
                        break;
                    case 4:
                        System.out.println();
                        System.out.println("Thank you for playing!");
                        Thread.sleep(5000);
                        System.out.println();
                        System.exit(option);
                        break;
                }
                
            } catch (Exception e) {
                System.out.println("Pls try again");
            }
        }
    }
}