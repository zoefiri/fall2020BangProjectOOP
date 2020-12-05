package Fall2020OOPProject3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthew
 */
public class DieTest {
    
    VanillaDie instanceVanilla = new VanillaDie();
    VanillaDie instanceVanillaRoll = new VanillaDie(); //separate instance for testing roll because rolling dynamite screws up testing for lock functions


    /**
     * Test of roll method, of class Die.
     */
    @Test
    public void testRoll() {
        int expResult = 1;
        Die.Face result = instanceVanillaRoll.roll();
        if((result == Die.Face.ARROW)||(result == Die.Face.DYNAMITE)||(result == Die.Face.BEER)||(result == Die.Face.GATLING)||(result == Die.Face.SHOOT1)||(result == Die.Face.SHOOT2))
        {
            assertEquals(expResult, 1);
        }
        else
        {
            assertEquals(expResult, null);
        }
    }

    /**
     * Test of toggleLocked method, of class Die.
     */
    @Test
    public void testToggleLocked() {
        instanceVanilla.setLocked(false);
        instanceVanilla.toggleLocked();
        assertEquals(instanceVanilla.isLocked(), true);
    }

    /**
     * Test of setLocked method, of class Die.
     */
    @Test
    public void testSetLocked() {
        boolean lock = false;
        instanceVanilla.setLocked(lock);
        assertEquals(instanceVanilla.isLocked(), false);
    }

    /**
     * Test of isLocked method, of class Die.
     */
    @Test
    public void testIsLocked() {
        boolean expResult = false;
        instanceVanilla.setLocked(expResult);
        boolean result = instanceVanilla.isLocked();
        assertEquals(expResult, result);
    }

    /**
     * Test of isUnlockable method, of class Die.
     */
    @Test
    public void testIsUnlockable() {
        boolean expResult = true;
        boolean result = instanceVanilla.isUnlockable();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentFace method, of class Die.
     */
    @Test
    public void testGetCurrentFace() {
        Die.Face expResult = Die.Face.ARROW; //arrow expected because it is default for vanilla die
        Die.Face result = instanceVanilla.getCurrentFace();
        assertEquals(expResult, result);
    }
    
}
