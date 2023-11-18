package it.unibo.deathnote;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.DeathNoteImpl;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDeathNote {


    private DeathNote deathNote;

    @BeforeEach
    void init(){
        deathNote = new DeathNoteImpl();
    }

    @Test
    public void TestIllegalRule(){

        for ( int i = 1 ; i < DeathNote.RULES.size() ; i++) {
            try {
                deathNote.getRule(i);
            } catch (Exception e) {
                Assertions.assertEquals(IllegalArgumentException.class , e.getClass() ); //controllo che sia un IllegalArgumentException
                Assertions.assertFalse(deathNote.getRule(i).isEmpty());
            }
        }
        
    }

    @Test
    public void humanDeath(){
        
        Assertions.assertFalse(deathNote.isNameWritten("Mattia"));
        deathNote.writeName("Mattia");
        Assertions.assertTrue(deathNote.isNameWritten("Mattia"));
        Assertions.assertFalse(deathNote.isNameWritten("UNALTRONOME"));
        Assertions.assertFalse(deathNote.isNameWritten(""));
    }

    @Test
    public void humanDeathTimeout(){

        deathNote.writeDetails("")
    }





   

}