package com.softserveinc.tasks.models.chess;


public class Board {
    private int width;
    private int height;

    /**
     * create a chessboard
     *
     * @param height - height of chessboard
     * @param width  - width of chessboard
     */
    public Board(int height, int width) {
        this.height = height;
        this.width = width;
    }

    /**
     * creates chessboard with height and width
     */
    @Override
    public String toString() {
        StringBuilder field = new StringBuilder();

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (i % 2 == 0) field.append(" *");

                else field.append("* ");
            }
            field.append("\n");
        }
        return new String(field);
    }
}
