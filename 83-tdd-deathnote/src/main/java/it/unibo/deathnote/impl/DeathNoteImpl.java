package it.unibo.deathnote.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import it.unibo.deathnote.api.DeathNote;

import static it.unibo.deathnote.api.DeathNote.RULES;


public class DeathNoteImpl implements DeathNote{

    Map<String, DeathInformation> deaths = new LinkedHashMap<>();
    private String name;

    @Override
    public String getDeathCause(final String name){
        return deaths.get(name).deathCause;
    }

    @Override
    public String getDeathDetails(final String name){
        return deaths.get(name).deathDetails;
    }

    @Override
    public String getRule(int ruleNumber) {
        Assertions.
        return RULES.get(ruleNumber);
    }

    @Override
    public boolean isNameWritten(String name){
        return !this.name.isEmpty();
    }

    @Override
    public boolean writeDeathCause(String cause){
        deaths.get(this.name).setDeathCause(cause);
        if (deaths.get(this.name).deathCause.isEmpty()) {
            return false;
        }
        return true;

    }

    @Override
    public boolean writeDetails(final String details){
        deaths.get(this.name).setDeathDetails(details);
        if (deaths.get(this.name).deathDetails.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public void writeName(final String name){
        this.name = name;
    }

    public class DeathInformation{
        private String deathCause;
        private String deathDetails;

        private void setDeathCause(final String cause){

        }

        private void setDeathDetails(final String details){
        }

    }
}