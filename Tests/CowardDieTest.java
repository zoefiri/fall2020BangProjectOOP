package Fall2020OOPProject3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthew
 */
public class CowardDieTest {
    
    CowardDie instance = new CowardDie();
    
    @Test
    public void testGetPossibleFaces() {
        
        Die.Face[] expResult = {
            Die.Face.SHOOT1,
            Die.Face.BEER_2X,
            Die.Face.DYNAMITE,
            Die.Face.ARROW,
            Die.Face.BROKEN_ARROW,
            Die.Face.BEER
	};
        Die.Face[] result = instance.getPossibleFaces();
        assertArrayEquals(expResult, result);
    }
    
}