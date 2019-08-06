package com.softserveinc.tasks.view;

import com.softserveinc.tasks.models.envelopes.Envelope;
import com.softserveinc.tasks.services.EnvelopeInsertion;
import com.softserveinc.tasks.validator.Validator;

import java.io.BufferedReader;
import java.io.IOException;

public class RunEnvelope implements TaskRunner {
    private BufferedReader reader;

    public RunEnvelope(BufferedReader reader){
        this.reader = reader;
    }

    @Override
    public void run() {
        do {
            try {
                System.out.println("Enter envelope`s sides");
                System.out.print("(First envelope)Enter first side: ");
                double a = Double.parseDouble(reader.readLine());

                System.out.print("(First envelope)Enter second side: ");
                double b = Double.parseDouble(reader.readLine());

                System.out.print("(Second envelope)Enter first side: ");
                double c = Double.parseDouble(reader.readLine());

                System.out.print("(Second envelope)Enter second side: ");
                double d = Double.parseDouble(reader.readLine());

                if (!Validator.checkIfGreaterThanZero(a, b, c, d)) {
                    System.out.println("Invalid envelope`s sides");
                    continue;
                }

                Envelope env1 = new Envelope(a, b);
                Envelope env2 = new Envelope(c, d);

                if (EnvelopeInsertion.canInsert(env1, env2)) {
                    System.out.println("You can put second envelope into first");

                } else if (EnvelopeInsertion.canInsert(env2, env1)) {
                    System.out.println("You can put first envelope into second");

                } else {
                    System.out.println("It`s not possible to put envelopes into each other");
                }

            } catch (NumberFormatException e) {
                System.out.println("Params must be numbers");
            } catch (IOException e){
                System.out.printf("Incorrect input: %s", e.toString());
            }
        } while (tryAgain());
    }

    private boolean tryAgain() {
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
