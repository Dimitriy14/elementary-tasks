package com.softserveinc.tasks.task1.chess;

import com.softserveinc.tasks.task1.Fields;

public class Board implements Fields {
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
     * prints chessboard
     */
    @Override
    public StringBuilder create() {
        StringBuilder field = new StringBuilder();

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (i % 2 == 0) field.append(" *");

                else field.append("* ");
            }
            field.append("\n");
        }
        return field;
    }
}
