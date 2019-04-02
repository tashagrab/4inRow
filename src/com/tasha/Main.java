package com.tasha;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Grid grid = new Grid();

    public static void main(String[] args) {
        System.out.println("Player 1 choose your letter: Press [X] or [O]");
        String p1 = scanner.nextLine().toUpperCase();
        String p2;

        if (p1.equals("X")) {
            System.out.println("Player 2 you are [O]");
            p2 = "O";
        } else {
            System.out.println("Player 2 you are [X]");
            p2 = "X";
        }


        grid.printGrid();
        start(p1, p2);



    }


    public static void start(String p1, String p2) {
        do {
                if (!add(p1)) {
                    add(p2);
                } else {
                    add(p1);
                }
            } while(!grid.winCheck());

        System.out.println("Want to play again? Press [Y] or [No]");
        String again = scanner.nextLine().toUpperCase();

        if (again.equals("Y")) {
            start(p1, p2);
        }
    }

    public static boolean add(String p) {
        System.out.println("Player " + p + " select a column to add " + p);
        int col = scanner.nextInt();

        if (col >= 1 && col <= 8) {
            grid.add(col, p);
        } else {
            System.out.println("Please choose a valid column.");
            add(p);
            return true;

        }
        return false;
    }


}
