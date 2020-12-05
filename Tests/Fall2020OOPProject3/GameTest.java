package Fall2020OOPProject3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthew
 */
public class GameTest {
    
    /**
     * Test of getDiceFaces method, of class Game.
     */
    @Test
    public void testGetDiceFaces() {
        Game instance = new Game(2, false, false);
        Die.Face[] expResult = {
            Die.Face.ARROW,
            Die.Face.ARROW,
            Die.Face.ARROW,
            Die.Face.ARROW,
            Die.Face.ARROW
        };
        Die.Face[] result = instance.getDiceFaces();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of areRenegadesOrOutlawsAlive method, of class Game.
     */
    @Test
    public void testAreRenegadesOrOutlawsAlive() {
        Game instance = new Game(2, false, false);
        boolean expResult = true;
        boolean result = instance.areRenegadesOrOutlawsAlive();
        assertEquals(expResult, result);
    }
}