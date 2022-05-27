package game_code;

import java.util.Random;

// import java.util.Random;
// import java.util.Scanner;

public class gameCode {

    static String[][] cardsUp = new String[4][5];
    static String[][] cardsDown = new String[4][5];



// public static void printBord()



    public static String[][] shuffle() {
        String letters[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String cards[][] = new String[4][5];
        Random random =  new Random();
        for (int i = 0; i < 19; ) {
            int rnd = random.nextInt(letters.length);
            System.out.println(letters[rnd]);
        }
        return cards;
    }
}