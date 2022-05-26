package run_game;

import main_menu.Menu;
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        try {
            menu.mainMenu();
        } 
        catch (Exception e) {
            System.out.println("Exeption main: " + e);
            // e.printStackTrace();
        }
    }
}
