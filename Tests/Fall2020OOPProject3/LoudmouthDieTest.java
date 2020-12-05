package Fall2020OOPProject3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthew
 */
public class LoudmouthDieTest {
    
    LoudmouthDie instance = new LoudmouthDie();
    
    @Test
    public void testGetPossibleFaces() {
        
        Die.Face[] expResult = {
            Die.Face.SHOOT1_2X,
            Die.Face.SHOOT2_2X,
            Die.Face.DYNAMITE,
            Die.Face.ARROW,
            Die.Face.GATLING,
            Die.Face.SILVERBULLET
	};
        Die.Face[] result = instance.getPossibleFaces();
        assertArrayEquals(expResult, result);
    }
    
}