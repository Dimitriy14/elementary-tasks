package com.softserveinc.tasks.services;

import com.softserveinc.tasks.models.envelopes.Envelope;

public class EnvelopeInsertion {
    public static boolean canInsert(Envelope env1, Envelope env2) {
        return env1.getHeight() > env2.getHeight() &&
                env1.getWidth() > env2.getWidth();
    }
}
