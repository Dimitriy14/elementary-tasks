package com.softserveinc.tasks.models.envelopes;

public class Envelope {
    private double height;
    private double width;

    /**
     * create an envelope
     *
     * @param height - height of envelope
     * @param width  - width of envelope
     */
    public Envelope(double height, double width){
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
