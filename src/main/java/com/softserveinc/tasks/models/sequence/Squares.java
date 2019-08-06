package com.softserveinc.tasks.models.sequence;

import java.util.ArrayList;

public class Squares implements Sequence{
    private ArrayList<Integer> sequence;

    public Squares(int num){
        this.sequence = this.getSeq(num);
    }

     private ArrayList<Integer> getSeq(int n) {
        ArrayList<Integer> sequence = new ArrayList<>();
        for (int i = 0; Math.pow(i, 2) <= n; i++) {
            sequence.add(i);
        }
        return sequence;
    }

    @Override
    public ArrayList<Integer> getSequence(){
        return this.sequence;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int num:this.getSequence()) {
            result.append(Integer.toString(num) + " ");
        }
        return result.toString();
    }
}