package com.softserveinc.tasks.services;

import java.io.*;
import java.util.Scanner;

public class Parser {
    public static int countRows(String path, String row) throws FileNotFoundException {
        int counter = 0;

        Scanner scanner = new Scanner(new File(path));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.equals(row)) counter++;
        }

        scanner.close();

        return counter;
    }

    public static void replaceRows(String path, String row, String replaceWith) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line = reader.readLine();
        StringBuilder oldContent = new StringBuilder();

        while (line != null) {
            oldContent.append(line).append(System.lineSeparator());
            line = reader.readLine();
        }

        String modifiedContent = oldContent.toString().replaceAll(row, replaceWith);
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(modifiedContent);

        reader.close();
        writer.close();
    }
}

