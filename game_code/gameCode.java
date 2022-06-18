package game_code;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Scanner;

import database_connector.JDBC;
import main_menu.Animations;
import main_menu.Menu;

public class gameCode {
    public static void main(String[] args) {
        Menu m = new Menu();
        try {
            m.mainMenu();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static boolean[][] down = new boolean[4][5];
    static String[][] open = new String[4][5];
    static String[][] letters = {{"A", "B", "C", "D", "E"},
                                 {"F", "G", "H", "I", "J"},
                                 {"A", "B", "C", "D", "E"},
                                 {"F", "G", "H", "I", "J"}
    };

    public void game() throws InterruptedException {
        JDBC j = new JDBC();
            setScore(score = 0);
            setLives(lives = 10);
            setCardsDown(cardsDown = 20);
            randomizer();
            runGame();
            calcScore();
            j.insertScore();
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
        System.out.println("    ~ Memory Imposible ~" + "\r\n");
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

    public static void runGame() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                displayBoard();
                System.out.print("Cord one: ");
                String c1 = scan.next();
                if (c1.length() != 2) {
                    System.out.println("Invalid cord!!");
                    Thread.sleep(1000);
                    runGame();
                }
                int c1x = Integer.valueOf(c1.substring(0, 1))-1;
                int c1y = Integer.valueOf(c1.substring(1, 2))-1;
                if ((c1x > 4) || (c1y > 5)) {
                    System.out.println("Invalid card!!");
                    Thread.sleep(1000);
                    runGame();
                }
                if (letters[c1x][c1y] == open[c1x][c1y]) {
                    System.out.println("Can't open already open card!!");
                    Menu.enterContinue();
                    runGame();
                }
                down[c1x][c1y] = true;
                displayBoard();

                System.out.print("Cord two: ");
                String c2 = scan.next();
                if (c2.length() != 2) {
                    System.out.println("Invalid cord!!");
                    Thread.sleep(1000);
                    runGame();
                }
                int c2x = Integer.valueOf(c2.substring(0, 1))-1;
                int c2y = Integer.valueOf(c2.substring(1, 2))-1;
                if ((c2x > 4) || (c2y > 5)) {
                    System.out.println("Invalid card!!");
                    Thread.sleep(1000);
                    runGame();
                }
                if ((c1x == c2x) && (c1y == c2y)) {
                    System.out.println("Can't open the same card!!");
                    Menu.enterContinue();
                    down[c1x][c1y] = false;
                    runGame();
                }
                if (letters[c2x][c2y] == open[c2x][c2y]) {
                    System.out.println("Can't open already open card!!");
                    Menu.enterContinue();
                    down[c1x][c1y] = false;
                    runGame();
                }
                down[c2x][c2y] = true;
                displayBoard();

                Thread.sleep(1000);
                if (letters[c1x][c1y] == letters[c2x][c2y]) {
                    System.out.println("You found a match!!");
                    Thread.sleep(1500);
                    setCardsDown(cardsDown -= 2);
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
                if (getLives() == 0) {
                    System.out.println("Out of lives");
                    Menu.enterContinue();
                    break;
                }
                if (getCardsDown() == 0) {
                    System.out.println("You win!!");
                    Menu.enterContinue();
                    break;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("gameCode: " + e);
                Animations.border();
                System.out.println("Enter cords!!" + "\r\n"
                                 + "e.g 11 or 45" + "\r\n");
                Menu.enterContinue();
            }
            catch (Exception e) {
                System.out.println(e);
                Menu.enterReturn();
                runGame();
            }
        }
    }

    public static void calcScore() {
        System.out.println("Score: " + getScore());
        int bonus = (getScore() * 3);
        System.out.println("Bonus: " + bonus);
        setScore(score += bonus);
        System.out.println("You're final score: " + getScore());
        formTime();
        Menu.enterContinue();
    }

    public static void formTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd hh:mm:ss");
        gameCode.setDateTime(formatter.format(LocalDateTime.now()));
    }

    private static int score;
    private static int lives;
    private static int cardsDown;
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
    
    public static int getCardsDown() {
        return cardsDown;
    }
    
    public static void setCardsDown(int newCardsDown) {
        cardsDown = newCardsDown;
    }

    public static String getDateTime() {
        return dateTime;
    }

    public static void setDateTime(String newDateTime) {
        dateTime = newDateTime;
    }
}