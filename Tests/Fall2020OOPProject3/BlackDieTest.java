package Fall2020OOPProject3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthew
 */
public class BlackDieTest {
    
    BlackDie instance = new BlackDie();
    
    @Test
    public void testGetPossibleFaces() {
        
        Die.Face[] expResult = {
            Die.Face.DUEL, 
            Die.Face.DUEL_, 
            Die.Face.DYNAMITE, 
            Die.Face.ARROW, 
            Die.Face.GATLING, 
            Die.Face.WHISKY
        };
        Die.Face[] result = instance.getPossibleFaces();
        assertArrayEquals(expResult, result);
    }
    
}