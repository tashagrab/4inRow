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


    /* public void checkWins(String s) {

        // source, check out comment section for improvements!
        // https://codereview.stackexchange.com/questions/127091/java-connect-four-four-in-a-row-detection-algorithms

        int count = 0;

        VERTICAL:
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array.length; x++) {
                if (s.equals(array[x][y])) {
                    count++;

                    if (count >= 4) {
                        System.out.println("Player " + s + " won!");
                        break VERTICAL;
                    }
                } else {
                    count = 0;
                }
            }
        }

        count = 0;

        HORIZONTAL:
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array.length; y++) {
                if (s.equals(array[x][y])) {
                    count++;


                if (count >= 4) {
                    System.out.println("Player " + s + " won!");
                    break HORIZONTAL;
                }
            } else{
                count = 0;
            }
        }
    }

    count = 0;
        int y = array.length-1;
        int x;
        DIAGONAL_DOWN_RIGHT_A: for (int loop = 0; y >= 0; loop++ ) {
            x = 0;
            int otherY = y;

            while(x<=array.length-1 && otherY <= y) {
                if (s.equals(array[x][otherY])) {
                    count++;

                    if(count >= 4) {
                        System.out.println("Player " + s + " won!");
                        break DIAGONAL_DOWN_RIGHT_A;
                    }
                } else {
                    count = 0;
                }
                x++;
                otherY++;
                y = array.length-1;
            }

            y -= loop;
        }

        count = 0;

        x = array.length-1;
        DIAGONAL_DOWN_RIGHT_B: for (int loop = 0; x >= 0; loop++) {
            y = 0;
            int otherX = x;

            while (y <= array.length-1 && otherX <= array.length-1) {
                if (s.equals(array[otherX][y])) {
                    count++;

                    if(count>=4) {
                        System.out.println("Player " + s + " won!");
                        break DIAGONAL_DOWN_RIGHT_B;
                    }
                } else {
                    count = 0;
                }
                y++;
                otherX++;
                x = array.length-1;
            }
            x -=loop;
        }

        y = array.length-1;
        DIAGONAL_DOWN_LEFT_A: for (int loop = 0; y>=0; loop++) {
            x = array.length-1;
            int otherY = y;

            while(x>=0 && otherY<=array.length-1) {
                if (s.equals(array[x][otherY])) {
                    count++;

                    if (count>=4) {
                        System.out.println("Player " + s + " won!");
                        break DIAGONAL_DOWN_LEFT_A;
                    }
                } else {
                    count = 0;
                }
                x--;
                otherY++;
                y = array.length-1;
            }
            y -= loop;
        }

        count = 0;

        x = array.length-1;
        DIAGONAL_DOWN_LEFT_B: for(int loop = 0; x>=0; loop++) {
            y = 0;
            int otherX = x;

            while (y <= array.length-1 && otherX >= 0) {
                if (s.equals(array[otherX][y])) {
                    count++;

                    if (count>=4) {
                        System.out.println("Player " + s + " won!");
                        break DIAGONAL_DOWN_LEFT_B;
                    }
                } else {
                    count = 0;
                }
                y++;
                otherX--;
                x = array.length-1;
            }
            x -= loop;
        }

*/

    }

