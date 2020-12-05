package Fall2020OOPProject3;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthew
 */
public class PlayerTest {
    

     Player testPlayer = new Player(Player.Character.BLACK_JACK, Player.Role.DEPUTY, 1);
     //8 HP

    /**
     * Test of shootPlayer method, of class Player.
     */
    @Test
    public void testShootPlayer() {
        Player instance = new Player(Player.Character.LUCKY_DUKE, Player.Role.DEPUTY, 1);
        testPlayer.shootPlayer(instance);
        assertEquals(instance.getCurrentHP(), 7);
    }

    /**
     * Test of indianAttack method, of class Player.
     */
    @Test
    public void testIndianAttack() {
        int expResult = 8;
        testPlayer.indianAttack();
        int result = testPlayer.getCurrentHP();
        assertEquals(expResult, result);
    }

    /**
     * Test of addArrow method, of class Player.
     */
    @Test
    public void testAddArrow() {
        int expResult = 1;
        int result = testPlayer.addArrow();
        assertEquals(expResult, result);
    }

    /**
     * Test of addHP method, of class Player.
     */
    @Test
    public void testAddHP() {
        int heal = 1;
        int expResult = 8;
        int result = testPlayer.addHP(heal);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeHP method, of class Player.
     */
    @Test
    public void testRemoveHP() {
        int hit = 1;
        int expResult = 7;
        int result = testPlayer.removeHP(hit);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSeatPosition method, of class Player.
     */
    @Test
    public void testGetSeatPosition() {
        int expResult = 1;
        int result = testPlayer.getSeatPosition();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSeatPosition method, of class Player.
     */
    @Test
    public void testSetSeatPosition() {
        int expResult = 2;
        testPlayer.setSeatPosition(expResult);
        int result = testPlayer.getSeatPosition();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRole method, of class Player.
     */
    @Test
    public void testGetRole() {
        Player.Role expResult = Player.Role.DEPUTY;
        Player.Role result = testPlayer.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCharacter method, of class Player.
     */
    @Test
    public void testGetCharacter() {
        Player.Character expResult = Player.Character.BLACK_JACK;
        Player.Character result = testPlayer.getCharacter();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentArrows method, of class Player.
     */
    @Test
    public void testGetCurrentArrows() {
        int expResult = 0;
        int result = testPlayer.getCurrentArrows();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentHP method, of class Player.
     */
    @Test
    public void testGetCurrentHP() {
        int expResult = 8;
        int result = testPlayer.getCurrentHP();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaxHP method, of class Player.
     */
    @Test
    public void testGetMaxHP() {
        int expResult = 8;
        int result = testPlayer.getMaxHP();
        assertEquals(expResult, result);
    }


    /**
     * Test of getMaxHPOfCharacter method, of class Player.
     */
    @Test
    public void testGetMaxHPOfCharacter() {
        Player.Character character = Player.Character.JOURDONNAIS;
        int expResult = 7;
        int result = Player.getMaxHPOfCharacter(character);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Player.
     */
    @Test
    public void testToString() {
        String expResult = "Black Jack";
        String result = testPlayer.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRoleMask method, of class Player.
     */
    @Test
    public void testGetRoleMask() {
        String expResult = "UNKNOWN";
        String result = testPlayer.getRoleMask();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentHPMask method, of class Player.
     */
    @Test
    public void testGetCurrentHPMask() {
        String expResult = "8";
        String result = testPlayer.getCurrentHPMask();
        assertEquals(expResult, result);
    }
    
}