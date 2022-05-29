package test;

// import java.sql.SQLException;

// import database_connector.JDBC;
// import main_menu.LoginMenu;

// import java.sql.SQLException;

// import database_connector.JDBC;
// import main_menu.SubMenu;
// import game_code.gameCode;

public class test {
    public static void main(String[] args) {

        double[][] matrixLeft = {{1,5,2,8,4,70,55,80},{3,7,4,2,6,60,30,70}};
        double[][] matrixRight = {{8,1,6,4,2,10,40,60},{1,5,2,8,4,70,50,80},{3,7,4,2,6,60,30,70}};

        int endOfLoop = matrixLeft.length >  matrixRight.length ? matrixLeft.length : matrixRight.length;
        for(int i = 0; i < endOfLoop; i++){
            if(matrixLeft.length > i){
                printLine(matrixLeft[i]);
                System.out.print("     ");
            } else {
                printBlankLine(matrixLeft[0].length);
            }

            if(matrixRight.length > i){
                printLine(matrixRight[i]);
            }
            System.out.println();
        }
    }

    private static void printLine(double[] line){
        for(double number : line){
            System.out.print(number + " ");
        }
    }

    private static void printBlankLine(int lenght){
        for(int i=0; i < lenght; i++){
            System.out.print("     ");
        }
    }


        // JDBC o = new JDBC();
        // try {
        //     o.getUser();
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }

        // LoginMenu i = new LoginMenu();
        // i.loginMenu();

        // SubMenu i = new SubMenu();
        // i.getCred();

        // System.out.println("\u22A2");

        // JDBC i = new JDBC();
        // i.editUser();

        // iͫmͤpͫoͦsͬʸible

        // gameCode.shuffle();

        // int[][] i = {{43,43,434,53},
        //              {45,23423,5,54,54},
        //              {3,243,34,23,}};


        // {3,243,34,23,}
        // {45,23423,5,54,54}
        // // {43,43,434,53}
        // System.out.println(i[0][0]);

        // // SubMenu i = new SubMenu();
        // SubMenu.userData();


    //     JDBC i = new JDBC();
    //     try {
    //         i.insertUsers();
    //     } catch (SQLException e) {
    //         // print
    //         e.printStackTrace();
    //     }
        
        

        // int[][] mdarray = {{12,24,42},{56,43,73}};

        // System.out.println(mdarray[0][0]);
   
        // int[] array = {23,45,76,23,67};

        // for (int num : array) {
        //     System.out.print(num + " ");
        // }

        // int num = 0;
        // for (int i = 0;i < array.length;i++) {
        //     num += array[i];
        //     System.out.println("index " + i);
        //     System.out.println("array num = " + array[i]);
        //     System.out.println(num);
        // }
        // System.out.println("total = " + num);

        // int num = array[0];
        // for (int i = 0;i < array.length;i++) {
        //     if (array[i] > num) num = array[i];
        //     System.out.println(num);
        // }
        // System.out.println("max is: " + num);

                    
        // String[] message = {
        //     "              _",
        //     "__      _____| | ___ ___  _ __ ___   ___",
        //     "\\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\",
        //     " \\ V  V /  __/ | (_| (_) | | | | | |  __/",
        //     "  \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|",
        //     " "
        // };
        // for (String string : message) {
        //     System.out.println(string);
        // }

        // String[] message2 = {
        //     " ",
        //     "@@@  @@@  @@@  @@@@@@@@  @@@        @@@@@@@   @@@@@@   @@@@@@@@@@   @@@@@@@@",
        //     "@@@  @@@  @@@  @@@@@@@@  @@@       @@@@@@@@  @@@@@@@@  @@@@@@@@@@@  @@@@@@@@",
        //     "@@!  @@!  @@!  @@!       @@!       !@@       @@!  @@@  @@! @@! @@!  @@!",
        //     "!@!  !@!  !@!  !@!       !@!       !@!       !@!  @!@  !@! !@! !@!  !@!",
        //     "@!!  !!@  @!@  @!!!:!    @!!       !@!       @!@  !@!  @!! !!@ @!@  @!!!:!",
        //     "!@!  !!!  !@!  !!!!!:    !!!       !!!       !@!  !!!  !@!   ! !@!  !!!!!:",
        //     "!@!  !!!  !@!  !!!!!:    !!!       !!!       !@!  !!!  !@!   ! !@!  !!!!!:",
        //     ":!:  :!:  :!:  :!:        :!:      :!:       :!:  !:!  :!:     :!:  :!:",
        //     " :::: :: :::    :: ::::   :: ::::   ::: :::  ::::: ::  :::     ::    :: ::::",
        //     "  :: :  : :    : :: ::   : :: : :   :: :: :   : :  :    :      :    : :: ::",
        //     " "
        // };
        // for (String string : message2) {
        //     System.out.println(string);
        // }
    
}
