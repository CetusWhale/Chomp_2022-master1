import java.awt.*;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;


    public MyPlayer() {
        columns = new int[10];
        String[]numbers = {"A", "B","C"};
        for(int A = 1; A <= 3; A++) {
            for (int B = 0; B <= A; B++) {
                    for (int C = 0; C <= B; C++) {
                            System.out.println(A + "," + B + "," + C);
                }
            }
        }

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 0;
        int row = 0;

        row = 1;
        column = 1;

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        Point myMove = new Point(row, column);
        return myMove;
    }

}
