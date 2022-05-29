package game_code;

// import java.util.Random;

// import java.util.Random;
// import java.util.Scanner;

public class gameCode {

    // static String[][] cardsUp = new String[4][5];
    // static boolean[][] cardsDown = new boolean[4][5];

    // public static void printBord() {
    //     for (int r = 0; r < 4; r++) {
    //         for (int c = 0; c < 5; c++) {
    //             cardsDown[r][c] = false;
    //         }
    //     }
    //     cardsUp = shuffle();
    // }

    // public static String[][] shuffle() {
    //     String letters[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
    //                         "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    //     String cardsUp[][] = new String[4][5];
    //     Random random =  new Random();
    //     int temp, t;
    //     for (int i = 0; i <= 24; i++) {
    //         for (x = 0; x < 20; x++) {
    //             t = random.next
    //         }
    //     }
    //     return cards;
    // }

    static boolean[][] down = new boolean[4][5];
    static String[][] letters = {{"A", "B", "C", "D", "E"},
                                 {"F", "G", "H", "I", "J"},
                                 {"A", "B", "C", "D", "E"},
                                 {"F", "G", "H", "I", "J"}
    };

    public static void main(String[] args) {
        displayBoard();
    }

    public static void displayBoard() {
        System.out.println("\r\n");
        for (int r = 0; r < letters.length; r++) {
            for (int c = 0; c < letters[r].length; c++) {
                int r1 = (int)(Math.random() * letters.length);
                int c1 = (int)(Math.random() * letters[r].length);

                String temp = letters[r][c];
                letters[r][c] = letters[r1][c1];
                letters[r1][c1] = temp;
            }
        }
        System.out.println("10| 1 2 3 4 5");
        System.out.println("--+-----------");
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

    public static void runGame(boolean[][] down, String[][] letters) {
        int totalDown = 20;
        while (totalDown > 0) {
            
        }
    }
}