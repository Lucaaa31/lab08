package it.unibo.deathnote.impl;

import it.unibo.deathnote.api.DeathNote;
import java.lang.Exception;

public class DeathNoteImpl implements DeathNote{
    @Override
    public String getDeathCause(String name){
        throw new UnsupportedOperationException();
    }

    @Override
    public String getDeathDetails(String name){
        throw new UnsupportedOperationException();
    }

    @Override
    public String getRule(int ruleNumber) {
        throw new IllegalArgumentException();
    }

    @Override
    public boolean isNameWritten(String name){
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean writeDeathCause(String cause){
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean writeDetails(String details){
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeName(String name){
        throw new UnsupportedOperationException();
    }
}