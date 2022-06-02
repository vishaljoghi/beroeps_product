package game_code;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Scanner;

import database_connector.JDBC;
import main_menu.Menu;

public class gameCode {
    // public static void main(String[] args) {
    //     Menu m = new Menu();
    //     try {
    //         m.mainMenu();
    //     }
    //     catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    // }

    static boolean[][] down = new boolean[4][5];
    static String[][] open = new String[4][5];
    static String[][] letters = {{"A", "B", "C", "D", "E"},
                                 {"F", "G", "H", "I", "J"},
                                 {"A", "B", "C", "D", "E"},
                                 {"F", "G", "H", "I", "J"}
    };

    public void game() throws InterruptedException {
        JDBC j = new JDBC();
        try {
            setScore(score = 0);
            setLives(lives = 10);
            randomizer();
            runGame();
            calcScore();
            j.insertScore();
        }
        catch (NumberFormatException e) {
            System.out.println("NumberFormatException in gameCode: " + e);
            runGame();
        }
        catch (Exception e) {
            System.out.println("Exeption in gameCode:" + e);
            runGame();
        }
    }

    public static void randomizer() {
        for (int r = 0; r < letters.length; r++) {
            for (int c = 0; c < letters[r].length; c++) {
                down[r][c] = false;
                int rs = (int)(Math.random() * letters.length);
                int cs = (int)(Math.random() * letters[r].length);

                String temp = letters[r][c];
                letters[r][c] = letters[rs][cs];
                letters[rs][cs] = temp;
            }
        }
    }

    public static void displayBoard() {
        System.out.println("\r\n" + "    ~ Memory Imposible ~" + "\r\n");
        System.out.println("  | 1 2 3 4 5" + "     lives: " + getLives());
        System.out.println("--+-----------" + "    points: " + getScore());
        for (int r = 0; r < letters.length; r++) {
            System.out.print((r + 1) + " | ");
            for (int c = 0; c < letters[r].length; c++) {
                if (down[r][c]) {
                    System.out.print(letters[r][c] + " ");
                }
                else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void runGame() throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        int totalDown = 20;
        while (totalDown > 0 && getLives() > 0) {
            displayBoard();
            System.out.print("Cord one: ");
            String c1 = scan.next();
            int c1x = Integer.valueOf(c1.substring(0, 1))-1;
            int c1y = Integer.valueOf(c1.substring(1, 2))-1;
            if (letters[c1x][c1y] == open[c1x][c1y]) {
                System.out.println("Can't open already open card!!");
                Menu.enterContinue();
                runGame();
            }
            down[c1x][c1y] = true;
            displayBoard();

            System.out.print("Cord two: ");
            String c2 = scan.next();
            int c2x = Integer.valueOf(c2.substring(0, 1))-1;
            int c2y = Integer.valueOf(c2.substring(1, 2))-1;
            if ((c1x == c2x) && (c1y == c2y)) {
                System.out.println("Can't open the same card!!");
                Menu.enterContinue();
                down[c1x][c1y] = false;
                runGame();
            }
            if (letters[c2x][c2y] == open[c2x][c2y]) {
                System.out.println("Can't open already open card!!");
                Menu.enterContinue();
                runGame();
            }
            down[c2x][c2y] = true;
            displayBoard();

            Thread.sleep(1000);
            if (letters[c1x][c1y] == letters[c2x][c2y]) {
                System.out.println("You found a match!!");
                Thread.sleep(1000);
                totalDown -= 2;
                setScore(score += 2);
                open[c1x][c1y] = letters[c1x][c1y];
                open[c2x][c2y] = letters[c2x][c2y];
            }
            else {
                System.out.println("Incorrect!!");
                Thread.sleep(1000);
                lives -= 1;
                down[c1x][c1y] = false;
                down[c2x][c2y] = false;
            }
        }
        if (getLives() < 1) {
            System.out.println("Out of lives");
            // System.out.println("You're score: " + getScore());
            Menu.enterContinue();
        }
        else {
            System.out.println("You win!!");
            // System.out.println("You're score: " + getScore());
            Menu.enterContinue();
        }
    }

    public static void calcScore() {
        setScore(score += ((10 - (10 - getLives())) * 3));
        System.out.println("You're score: " + getScore());
        formTime();
        Menu.enterContinue();
    }

    public static void formTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd hh:mm:ss");
        gameCode.setDateTime(formatter.format(LocalDateTime.now()));
    }

    private static int score;
    private static int lives;
    private static String dateTime;

    public static int getScore() {
        return score;
    }

    public static void setScore(int newScore) {
        score = newScore;
    }

    public static int getLives() {
        return lives;
    }

    public static void setLives(int newLives) {
        lives = newLives;
    }

    public static String getDateTime() {
        return dateTime;
    }

    public static void setDateTime(String newDateTime) {
        dateTime = newDateTime;
    }
}