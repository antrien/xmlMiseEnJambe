package inf234;

import org.junit.Test;

import static org.junit.Assert.*;

public class MiseEnJambeTest {

    @Test
    public void testContient1() throws Exception {
        MiseEnJambe m1 = new MiseEnJambe("<a>xyz<b>uvw</b>toto</a>");
        assertTrue(m1.contient("uvw</"));
    }

}
