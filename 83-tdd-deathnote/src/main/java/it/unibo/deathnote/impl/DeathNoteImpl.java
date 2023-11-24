package it.unibo.deathnote.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import it.unibo.deathnote.api.DeathNote;


import static it.unibo.deathnote.api.DeathNote.RULES;

import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static java.util.concurrent.TimeUnit.valueOf;



public class DeathNoteImpl implements DeathNote{

    private Map<String, DeathInformation> deaths = new LinkedHashMap<>();
    private String name;
    private long time;

    @Override
    public String getDeathCause(final String name){
        if (isNameWritten(name)) {
            if(deaths.get(name).deathCause == null){
                return "heart attack";
            }
            return deaths.get(name).deathCause;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getDeathDetails(final String name){
        return deaths.get(name).deathDetails;
    }

    @Override
    public String getRule(final int ruleNumber) {
        if (ruleNumber <= 0 || ruleNumber >= RULES.size() ) {
            throw new IllegalArgumentException();
        }
        return RULES.get(ruleNumber);
    }

    @Override
    public boolean isNameWritten(final String name){
        if (deaths.containsKey(name)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean writeDeathCause(final String cause){
        if(NANOSECONDS.toMillis((System.nanoTime() - time)) < 40 ){
            deaths.get(this.name).deathCause = cause;
            return true;
        }
        return false;
        

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
        time = System.nanoTime();
        this.deaths.put(name, new DeathInformation());
        this.name = name;
        
    }

    public class DeathInformation{
        private String deathCause;
        private String deathDetails;

        private void setDeathCause(final String cause){
            this.deathCause = cause;
        }

        private void setDeathDetails(final String details){
            this.deathDetails = details;
        }

    }
}