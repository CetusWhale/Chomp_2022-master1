import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    public ArrayList<int[]> LB;
    public ArrayList<Board> CB;


    public MyPlayer() {
        LB = new ArrayList<int[]>();
        CB = new ArrayList<Board>();
        int[] temp = {1, 0, 0, 0};
        LB.add(temp);
        for (int[] i : LB) {
            System.out.println("Losing Boards");
            System.out.println(Arrays.toString(i));
        }

        columns = new int[10];

        String[] numbers = {"A", "B", "C", "D"};
        for (int A = 1; A <= 4; A++) {
            for (int B = 0; B <= A; B++) {
                for (int C = 0; C <= B; C++) {
                    for (int D = 0; D <= C; D++) {
                        System.out.println("board");
                        System.out.println(A + "," + B + "," + C + "," + D);
                        System.out.println("Generating all possible boards");
                        digits(A, B, C, D);
                    }
                }
            }
            for (int[] i : LB) {
                System.out.println("Losing Boards");
                System.out.println(Arrays.toString(i));
            }
        }
    }

    public void digits(int A, int B, int C, int D) {
        int La = A;
        int Lb = B;
        int Lc = C;
        int Ld = D;
        int Column = 0;
        int Row = 0;
        int[] tempboard = {A, B, C, D};
        Board CurrentBoard = new Board(tempboard);

        boolean check = false;
        int a = A;
        int c2 = C;
        int b2 = B;
        int d2 = D;
        for (int d = D - 1; d >= 0; d--) {
            System.out.println(a + "," + B + "," + C + "," + d);
            for (int x = 0; x <= LB.size() - 1; x++) {
                if (a == LB.get(x)[0] && B == LB.get(x)[1] && C == LB.get(x)[2] && d == LB.get(x)[3]) {
                    System.out.println("Winning Board");
                    check = true;
                    La = a;
                    Lb = B;
                    Lc = C;
                    Ld = d;
                    int[] templb = {La, Lb, Lc, Ld};
                    CurrentBoard.LCB = templb;
                }
            }
        }
        a = A;
        c2 = C;
        b2 = B;
        d2 = D;
        for (int c = C - 1; c >= 0; c--) {
            //System.out.println("d2" +d2);

            if (d2 > c) {
                System.out.println("hi");

                d2 = c;
            }
            System.out.println(a + "," + B + "," + c + "," + d2);
            for (int x = 0; x <= LB.size() - 1; x++) {
                if (a == LB.get(x)[0] && B == LB.get(x)[1] && c == LB.get(x)[2] && d2 == LB.get(x)[3]) {
                    System.out.println("Winning Board");
                    check = true;
                    La = a;
                    Lb = B;
                    Lc = c;
                    Ld = D;
                    int[] templb = {La, Lb, Lc, Ld};
                    CurrentBoard.LCB = templb;
                }
            }

//        for (int a = A; a >= 1; a--) {
//            for (int b = B; b >= 0; b--) {
//                for (int c = C; c >= 0; c--) {
//                    System.out.println(a + "," + b + "," + c);
//                }
//            }
//        }
        }
        a = A;
        c2 = C;
        b2 = B;
        d2 = D;

        for (int b = B - 1; b >= 0; b--) {
            if (d2 >= b) {
                d2 = b;
            }
            if (c2 >= b) {
                c2 = b;
            }


            System.out.println(a + "," + b + "," + c2 + "," + d2);
            for (int x = 0; x <= LB.size() - 1; x++) {
                if (a == LB.get(x)[0] && b == LB.get(x)[1] && c2 == LB.get(x)[2] && d2 == LB.get(x)[3]) {
                    System.out.println("Winning Board");
                    check = true;
                    La = a;
                    Lb = b;
                    Lc = c2;
                    Ld = D;
                    int[] templb = {La, Lb, Lc, Ld};
                    CurrentBoard.LCB = templb;
                }
            }
        }
        c2 = C;
        a = A;
        //c2 = C;
        b2 = B;
        d2 = D;

        for (a = A - 1; a >= 1; a--) {
            if (b2 >= a) {
                b2 = a;
            }
            if (c2 > a) {
                c2 = a;
            }
            if (d2 > a) {
                d2 = a;
            }
            System.out.println(a + "," + b2 + "," + c2 + "," + d2);
            for (int x = 0; x <= LB.size() - 1; x++) {
                if (a == LB.get(x)[0] && b2 == LB.get(x)[1] && c2 == LB.get(x)[2] && d2 == LB.get(x)[3]) {
                    System.out.println("Winning Board");
                    La = a;
                    Lb = b2;
                    Lc = c2;
                    Ld = D;
                    check = true;
                    int[] templb = {La, Lb, Lc, Ld};
                    CurrentBoard.LCB = templb;
                }

            }
        }


        if (A - La == 0) {
            if (B - Lb == 0) {
                if (C - Lc == 0) {
                    if (D - Ld != 0) {

                    }
                    CurrentBoard.column = 3;
                    CurrentBoard.row = Ld;
                } else {
                    CurrentBoard.column = 2;
                    CurrentBoard.row = Lc;
                }

            } else {
                CurrentBoard.column = 1;
                CurrentBoard.row = Lb;
            }

        } else {
            CurrentBoard.column = 0;
            CurrentBoard.row = La;
        }
        System.out.println("C:" + CurrentBoard.column + "R:" + CurrentBoard.row);


        if (check == false) {
            System.out.println("Losing Board");
            int[] temp = {A, B, C, D};

            LB.add(temp);

            if (D > 0) {
                CurrentBoard.column = 3;
                CurrentBoard.row = D - 1;
            } else if (C > 0) {
                CurrentBoard.column = 2;
                CurrentBoard.row = C - 1;
            } else if (B > 0) {
                CurrentBoard.column = 1;
                CurrentBoard.row = B - 1;
            } else if (A > 0) {
                CurrentBoard.column = 0;
                CurrentBoard.row = A - 1;
            }
        }

        CB.add(CurrentBoard);
    }


    /***
     * This code will run just once, when the game opens.
     * Add your code here.
     */

    public Point move(Chip[][] pBoard) {
        int t1 = 0;
        int t2 = 0;
        int t3 = 0;
        int t4 = 0;

        System.out.println("MyPlayer Move");
        int column = 1;
        int row = 1;
        gameBoard = pBoard;
        if (gameBoard[2][2].isAlive == true) { //This board is 333
            column = 1;
            row = 1;
        }
        if (gameBoard[2][1].isAlive == true && gameBoard[1][2].isAlive == true && gameBoard[2][2].isAlive == false) {
            column = 1;
            row = 1;
        }
        for (int R = 0; R < gameBoard.length; R++) {
//                System.out.println(R+" "+C+" Gameboard"+ gameBoard[R][C].isAlive);
            if (gameBoard[R][0].isAlive == true) {
                t1 += 1;
            }
            if (gameBoard[R][1].isAlive == true) {
                t2 += 1;
            }
            if (gameBoard[R][2].isAlive == true) {
                t3 += 1;
            }
            if (gameBoard[R][3].isAlive == true) {
                t4 += 1;
            }

        }

//            System.out.println(t1+ " "+t2+" "+t3);


        System.out.println(t1 + " " + t2 + " " + t3 + " " + t4);
        for (int x = 0; x <= CB.size() - 1; x++) {
            System.out.println(Arrays.toString(CB.get(x).CB));
            if (t1 == CB.get(x).CB[0] && t2 == CB.get(x).CB[1] && t3 == CB.get(x).CB[2] && t4 == CB.get(x).CB[3]) {
                row = CB.get(x).row;
                column = CB.get(x).column;
                System.out.println("c: " + column + " r: " + row);
            }

        }


        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        Point myMove = new Point(row, column);
        return myMove;

    }

}
