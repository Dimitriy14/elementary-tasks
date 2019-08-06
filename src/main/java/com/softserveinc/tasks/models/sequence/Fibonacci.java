package com.softserveinc.tasks.models.sequence;

import java.util.ArrayList;

public class Fibonacci implements Sequence {
    private ArrayList<Integer> sequence;

    public Fibonacci(int num) {
        this.sequence = this.getSeq(0, num);
    }

    public Fibonacci(int first, int last) {
        this.sequence = this.getSeq(first, last);
    }

    private ArrayList<Integer> getSeq(int a, int b) {
        ArrayList<Integer> seq = new ArrayList<>();
        int current = 0;
        int next = 1;

        while (next <= b) {
            int tmp = current + next;
            current = next;
            next = tmp;

            if (current >= a && current <= b) {
                seq.add(current);
            }
        }
        return seq;
    }

    public ArrayList<Integer> getSequence() {
        return this.sequence;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int num : this.getSequence()) {
            result.append(Integer.toString(num) + " ");
        }
        return result.toString();
    }
}
