import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;


    public MyPlayer() {
        ArrayList<int[]> LB = new ArrayList<int[]>();
        int[] temp={1,0,0};
        LB.add(temp);
        for (int[] i : LB){
            System.out.println("Losing Boards");
            System.out.println(Arrays.toString(i));

        }

        columns = new int[10];

        String[] numbers = {"A", "B", "C"};
        for (int A = 1; A <= 3; A++) {
            for (int B = 0; B <= A; B++) {
                for (int C = 0; C <= B; C++) {
                    System.out.println(A + "," + B + "," + C);
                }
            }
        }
        System.out.println("Generating all possible boards");
        digits(3, 3, 0);
        }

    public void digits(int A, int B, int C) {
        int a = A;
        int c2 = C;
        int b2 = B;
        for (int c = C-1; c >= 0; c--){
                    System.out.println(a + "," + B + "," + c);
//        for (int a = A; a >= 1; a--) {
//            for (int b = B; b >= 0; b--) {
//                for (int c = C; c >= 0; c--) {
//                    System.out.println(a + "," + b + "," + c);
//                }
//            }
//        }
                }
        for (int b = B-1; b >= 0; b--) {
            if(c2 >= b) {
                c2 =b;
            }
            System.out.println(a + "," + b + "," + c2);
        }
        c2 = C;
        for (a = A-1; a >= 1; a--) {
            if(b2 >= a) {
                b2 = a;
            }
            if(c2 > a){
                c2 = a;
            }
            System.out.println(a + "," + b2 + "," + c2);
        }



            }




        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */


    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 1;
        int row = 1;

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
