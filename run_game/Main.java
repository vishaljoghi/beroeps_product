package run_game;

import java.sql.SQLException;
import main_menu.Menu;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        Menu menu = new Menu();
        menu.mainMenu();
    }
}
