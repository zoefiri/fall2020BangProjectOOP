package Fall2020OOPProject3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthew
 */
public class VanillaDieTest {
    
    VanillaDie instance = new VanillaDie();
    
    @Test
    public void testGetPossibleFaces() {
        
        Die.Face[] expResult = {
            Die.Face.ARROW,
            Die.Face.DYNAMITE,
            Die.Face.SHOOT1,
            Die.Face.SHOOT2,
            Die.Face.BEER,
            Die.Face.GATLING
	};
        Die.Face[] result = instance.getPossibleFaces();
        assertArrayEquals(expResult, result);
    }
    
}