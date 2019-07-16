package com.softserveinc.tasks.envelopes;

public class Envelope {
    private float height;
    private float width;

    /**
     * create an envelope
     *
     * @param height - height of envelope
     * @param width  - width of envelope
     * @throws IllegalArgumentException is thrown in case if params are lower than 0
     */
    Envelope(float height, float width) throws IllegalArgumentException {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(
                    "Envelope`s sides must be greater than 0");
        }

        this.height = height;
        this.width = width;
    }

    /**
     * check weather it`s possible to insert another envelope into current
     *
     * @param envelope - inserted envelope
     */
    boolean canInsert(Envelope envelope) {
        return this.height > envelope.height && this.width > envelope.width;
    }
}
