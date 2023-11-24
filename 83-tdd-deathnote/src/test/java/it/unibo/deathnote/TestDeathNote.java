package it.unibo.deathnote;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.DeathNoteImpl;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static it.unibo.deathnote.api.DeathNote.RULES;
import static java.lang.Thread.sleep;

public class TestDeathNote {


    private DeathNote deathNote;

    @BeforeEach
    void init(){
        deathNote = new DeathNoteImpl();
    }

    @Test
    public void TestIllegalRule(){
        int numRule = -1; 
        try {
            deathNote.getRule(numRule);
            Assertions.fail("IllegalArgoument but do not throw Exception for numRule=" + numRule);
            numRule++;
            deathNote.getRule(numRule);
            Assertions.fail("IllegalArgoument but do not throw Exception for numRule=" + numRule);
        }catch (Exception e) {
            Assertions.assertEquals(IllegalArgumentException.class , e.getClass() ); //controllo che sia un IllegalArgumentException
            for(int i=1; i < RULES.size(); i++){
                Assertions.assertFalse(deathNote.getRule(i).isEmpty());
            }
        }
        
    
    }

    @Test
    public void humanDeath(){
        /* verify that the human has not been written in the notebook yet*/
        Assertions.assertFalse(deathNote.isNameWritten("Alex Biondi"));
        /* write the human in the notebook */
        deathNote.writeName("Alex Biondi");
        /* verify that the human has been written in the notebook */
        Assertions.assertTrue(deathNote.isNameWritten("Alex Biondi"));
        /* verify that another human has not been written in the notebook */
        Assertions.assertFalse(deathNote.isNameWritten("UNALTRONOME"));
        /* verify that the empty string has not been written in the notebook */
        Assertions.assertFalse(deathNote.isNameWritten(""));
    }


    @Test
    public void testDeathCauseTimeout() throws InterruptedException{

        try {
            deathNote.getDeathCause("death cause");
            Assertions.fail("IllegalStateException but do not throw Exception");
        } catch (Exception e) {
            Assertions.assertEquals(IllegalArgumentException.class , e.getClass());
        }
        deathNote.writeName("Mattia Morri");
        Assertions.assertEquals("heart attack", deathNote.getDeathCause("Mattia Morri"));
        deathNote.writeName("Llazar Tafa");
        deathNote.writeDeathCause("karting accident");
        Assertions.assertEquals("karting accident", deathNote.getDeathCause("Llazar Tafa"));
        sleep(100);
        deathNote.writeDeathCause("Changed death cause");
        Assertions.assertEquals("karting accident", deathNote.getDeathCause("Llazar Tafa"));
    }

    @Test
    public void testDeathDetailsTimeout() throws InterruptedException{
        try {
            deathNote.getDeathCause("death details");
            Assertions.fail("IllegalStateException but do not throw Exception");
        } catch (Exception e) {
            Assertions.assertEquals(IllegalArgumentException.class , e.getClass());
        }
        deathNote.writeName("Jacopo Mosconi");
        Assertions.assertEquals(null, deathNote.getDeathDetails("Jacopo Mosconi"));
        deathNote.writeDetails("ran for too long");
        Assertions.assertEquals("ran for too long", deathNote.getDeathDetails("Jacopo Mosconi"));
        deathNote.writeName("Simone Lizzo");
        sleep(6100);
        deathNote.writeDetails("bit by a spider while sleeping");
        Assertions.assertEquals("heart attack", deathNote.getDeathCause("Simone Lizzo"));

    }




   

}