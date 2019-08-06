package com.softserveinc.tasks.view;

import com.softserveinc.tasks.models.chess.Board;
import com.softserveinc.tasks.validator.Validator;

import java.io.BufferedReader;
import java.io.IOException;

public class RunChessBoard implements TaskRunner {
    private BufferedReader reader;

    public RunChessBoard(BufferedReader reader){
        this.reader = reader;
    }

    @Override
    public void run() {
        do {
            int width = 0;
            int height = 0;

            try {
                System.out.println("Enter the sides of chessboard in format: <width> <height>");
                String input = reader.readLine();
                String[] args = input.split(" ");

                width = Integer.parseInt(args[0]);
                height = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid type");
                continue;
            } catch (IOException e){
                System.out.printf("Invalid input: %s", e.toString());
                continue;
            }

            if (Validator.checkIfGreaterThanZero(width, height)) {
                Board board = new Board(height, width);
                System.out.printf(board.toString());
            }


        } while (tryAgain());
    }

     boolean tryAgain() {
        String answ = "";
        System.out.println("Would you like to try again? Press y/yes");
        try {
            answ = reader.readLine();
        }
        catch (IOException e){
            System.out.printf("Incorrect input: %s", e.toString());
        }
        return answ.equalsIgnoreCase("y") ||
                answ.equalsIgnoreCase("yes");

    }
}
