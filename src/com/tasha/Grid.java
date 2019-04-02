package com.tasha;

public class Grid {
    private String[][] array = new String[8][8];
    private final int[] colNums = {1, 2, 3, 4, 5, 6, 7, 8};

    public Grid() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = "_";

            }
        }
    }

    public void printGrid() {
        for (String[] inner : array) {
            for (String s : inner) {
                System.out.print(s + "\t");
            }
            System.out.println();
        }
        for (int i : colNums) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println();
    }

    public void add(int col, String s) {
        int row = 0;
        s = s.toUpperCase();
        if (s.equals("O") || s.equals("X")) {
            if ((col > 0 && col < 9)) {
                for (int i = 7; i >= 0; i--) {
                    if (array[i][col - 1].equals("_")) {
                        array[i][col - 1] = s;
                        row = i;
                        break;
                    }
                }
            }

        }
        printGrid();

    }

    public boolean winCheck() {
        String s = checkWin(array);
        if (!s.equals("_")) {
            System.out.println("Player " + s + " won!");
            return true;
        }
        return false;
    }

    public static String checkWin(String[][] array) {
        final int HEIGHT = array.length;
        final int WIDTH = array[0].length;
        final String EMPTY_SLOT = "_";

        for (int r = 0; r < HEIGHT; r++) {    // iterate rows, bottom to top
            for (int c = 0; c < WIDTH; c++) {   // iterate columns, left to right
                String s = array[r][c];
                if (s.equals(EMPTY_SLOT))
                    continue;                // don't check empty slots

                // check horizontally
                if (c+3 < WIDTH &&
                        s.equals(array[r][c+1]) &&    // look right
                        s.equals(array[r][c+2]) &&
                        s.equals(array[r][c+3]))
                    return s;

                // check vertically & diagonally
                if(r+3 < HEIGHT) {
                    if (s.equals(array[r+1][c]) &&        // look up [vertical]
                            s.equals(array[r+2][c]) &&
                            s.equals(array[r+3][c]))
                        return s;

                    if (c+3 < WIDTH &&
                            s.equals(array[r+1][c+1]) &&    // look up & right [diagonal]
                            s.equals(array[r+2][c+2]) &&
                            s.equals(array[r+3][c+3]))
                        return s;


                    if (c-3 >= 0 &&
                            s.equals(array[r+1][c-1]) &&     // look up & left [diagonal]
                            s.equals(array[r+2][c-2]) &&
                            s.equals(array[r+3][c-2]))
                        return s;
                }
            }
        }
        return EMPTY_SLOT; // no winner found.
    }
}

