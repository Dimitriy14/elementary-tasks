package com.softserveinc.tasks.envelopes;

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

    /**
     * check weather it`s possible to insert another envelope into current
     *
     * @param envelope - inserted envelope
     */
    public boolean canInsert(Envelope envelope)
    {
        return this.height > envelope.height && this.width > envelope.width;
    }
}
