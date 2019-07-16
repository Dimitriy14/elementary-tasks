package com.softserveinc.tasks.chees;

public class Board {
    private int width;
    private int height;

    /**
     * create a chessboard
     *
     * @param height - height of chessboard
     * @param width  - width of chessboard
     * @throws IllegalArgumentException is thrown in case if params are lower than 0
     */
    public Board(int height, int width) throws IllegalArgumentException {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException(
                    "Numbers must be greater than 0");
        }

        this.height = height;
        this.width = width;
    }

    /**
     * prints chessboard
     */
    public void print() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (i % 2 == 0) System.out.print("* ");

                else System.out.print(" *");
            }
            System.out.println();
        }
    }
}
