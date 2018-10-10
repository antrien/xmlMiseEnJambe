package inf234;

import org.junit.Test;

import static org.junit.Assert.*;

public class MiseEnJambeTest {

    @Test
    public void testContient1() throws Exception {
        MiseEnJambe m1 = new MiseEnJambe("<a>xyz<b>uvw</b>toto</a>");
        assertTrue(m1.contient("uvw</"));
    }

/* -------------------------------------------------------------------------------------- */

    public void testContientBalise1() throws Exception { //Test standard
        MiseEnJambe m1 = new MiseEnJambe("<a>xyz<bcd>uvw</bcd>toto</a>"); 
        assertTrue(m1.contientBalise("bcd"));
        assertFalse(m1.contientBalise("xyz"));
    }

    public void testContientBalise1() throws Exception { //Test de non appartenance
        MiseEnJambe m1 = new MiseEnJambe("<a>xyzuvwtoto</a>");
        assertFalse(m1.contientBalise("bcd"));.
        assertTrue(m1.contientBalise("zu"));  
    }

    public void testContientBalise2() throws Exception { //Test des positions extremes des balise
        MiseEnJambe m1 = new MiseEnJambe("<bcd>xyz<a>uvw</a>toto</bcd>");
        assertTrue(m1.contientBalise("bcd"));  
    }

    public void testContientBalise3() throws Exception { //Test des imbrications des balises
        MiseEnJambe m1 = new MiseEnJambe("<bcd><bcd><bcd>fkjzefzhj</bcd></bcd></bcd>");
        assertTrue(m1.contientBalise("bcd"));  
    }

    public void testContientBalise4() throws Exception { //Test de balises enchainne
        MiseEnJambe m1 = new MiseEnJambe("<bcd></bcd><bcd>fkjzefzhj</bcd><bcd></bcd>");
        assertFalse(m1.contientBalise("bcd"));  
    }

    public void testContientBalise5() throws Exception {
        MiseEnJambe m1 = new MiseEnJambe("<a>xyz<bcd>uvw<b>toto</a");
        assertFalse(m1.contientBalise("bcd"));  
    }

    public void testContientBalise5() throws Exception {
        MiseEnJambe m1 = new MiseEnJambe("<bcd>xyz<a>uvw<a>toto</a");
        assertTrue(m1.contientBalise("bcd"));  
    }

}