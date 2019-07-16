package com.softserveinc.tasks.parser;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length == 2) {
            System.out.println(countRows(args[0], args[1]));

        } else if (args.length == 3) {
            replaceRows(args[0], args[1], args[2]);

        } else {
            System.out.println("Incorrect arguments");
        }
    }

    public static int countRows(String path, String row) {
        int counter = 0;

        try {
            Scanner scanner = new Scanner(new File(path));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.equals(row)) counter++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Incorrect filepath");
        }

        return counter;
    }

    public static void replaceRows(String path, String row, String replaceWith) {
        BufferedWriter writer = null;
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(path));

            String line = reader.readLine();
            StringBuilder oldContent = new StringBuilder();

            while (line != null) {
                oldContent.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }

            String modifiedContent = oldContent.toString().replaceAll(row, replaceWith);

            writer = new BufferedWriter(new FileWriter(path));

            writer.write(modifiedContent);

        } catch (FileNotFoundException e) {
            System.out.println("Incorrect filepath");

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }

                if (writer != null) {
                    writer.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
