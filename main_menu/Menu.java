package main_menu;

import java.util.Scanner;

import database_connector.JDBC;

public class Menu {
    public void mainMenu() {
        String[] options = {"1. Login & Play",
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
                        insertCredits();
                        break;
                    case 5:
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
    static void insertCredits() {
        System.out.println();
        System.out.println("          Developers           ");
        System.out.println("-------------------------------");
        System.out.println("Cheung   Shahrukh   SE/1121/062");
        System.out.println("Vishal   Joghi      BI/1121/019");
        System.out.println("Kevin    Bonoo      BI/1121/004");
        System.out.println();
    }
}