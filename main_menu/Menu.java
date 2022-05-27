package main_menu;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import database_connector.JDBC;

public class Menu {
    public void mainMenu() throws InterruptedException {
        welcomeMessage();
        String[] options = {
            "      Menu ",
            " --------------",
            "1. Login & Play",
            "2. Account",
            "3. Leaderboard",
            "4. Credits",
            "5. Exit",
            " "
        };
        int option;
        while (true) {
            for (String menu : options) {
                System.out.println(menu);
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
                menuExeption();
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

    static void exitMenu() throws InterruptedException {
        String[] exitMessage = {
            " ",
            "Thank you for playing!",
            " "
        };
        for (String i : exitMessage) {
            System.out.println(i);
        }
        Thread.sleep(2000);
        System.exit(0);
    }

    static void welcomeMessage() throws InterruptedException {
        // String[] welcome = {
        //     " ",
        //     "              _",
        //     "__      _____| | ___ ___  _ __ ___   ___",
        //     "\\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\",
        //     " \\ V  V /  __/ | (_| (_) | | | | | |  __/",
        //     "  \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|",
        //     " ",
        //     " "
        // };
        // for (String a : welcome) {
        //     System.out.println(a);
        // }
        // Thread.sleep(5000);

        String[] memory = {
            " ",
            " ",
            " _ __ ___   ___ _ __ ___   ___  _ __ _   _",
            "| '_ ` _ \\ / _ \\ '_ ` _ \\ / _ \\| '__| | | |",
            "| | | | | |  __/ | | | | | (_) | |  | |_| | ",
            "|_| |_| |_|\\___|_| |_| |_|\\___/|_|   \\__, |",
            "                                     |___/",
            " ",
            " "
        };
        for (String b : memory) {
            System.out.println(b);
        }
        Thread.sleep(2000);
        String[] impossible = {
            " _                               _ _     _",
            "(_)_ __ ___  _ __   ___  ___ ___(_) |__ | | ___",
            "| | '_ ` _ \\| '_ \\ / _ \\/ __/ __| | '_ \\| |/ _ \\",
            "| | | | | | | |_) | (_) \\__ \\__ \\ | |_) | |  __/ ",
            "|_|_| |_| |_| .__/ \\___/|___/___/_|_.__/|_|\\___|",
            "            |_|",
            " "
        };
        for (String c : impossible) {
            System.out.println(c);
        }
        Thread.sleep(2000);
    }

    static void menuExeption() {
        String[] error = {
            "       _   ___   _ ",
            "      | | |__ \\ | |",
            "      | |   / / | |",
            "      |_|  |_|  |_|",
            "      (_)  (_)  (_)",
            " ",
            "Pls enter an option number.",
            " "
        };
        for (String i : error) {
            System.out.println(i);
        }
        enterReturn();
    }

    public static void enterReturn() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Press 'Enter' to return.");
        scan.nextLine();
        // scan.close();
    }
}
