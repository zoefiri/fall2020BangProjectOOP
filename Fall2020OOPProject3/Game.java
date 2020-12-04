package Fall2020OOPProject3;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;
import java.util.Arrays;

import Fall2020OOPProject3.Die.Face;
import Fall2020OOPProject3.Player.Role;
import Fall2020OOPProject3.Player.Character;
import javafx.scene.control.TextArea;

public class Game {

    private Random rand;

    private boolean useExpansion1;
    private boolean useExpansion2;
    private int numPlayers;

    public ArrayList<Player> players = new ArrayList<Player>();
    
    private Die[] dice;
    private Die[] extraDice;
    private int numDice;
    private boolean useExtraDice;

    private int numArrows;

    public boolean gameOver;
    private TextArea textArea;

    public Game(int bots, boolean expansion1, boolean expansion2) {
        rand = new Random();
        numPlayers = bots + 1;
        dice = new Die[5];
        numDice = 5;
        numArrows = 9;
        gameOver = false;
        //textArea = historyTextArea;

        if (expansion2) {
            for (int i = 0; i < 3; i++) {
                dice[i] = new VanillaDie();
            }
            for (int i = 3; i < 5; i++) {
                dice[i] = new BlackDie();
            }
        }
        else {
            for (int i = 0; i < 5; i++) {
                dice[i] = new VanillaDie();
            }
        }
        if(expansion1) {
            extraDice = new Die[] {new LoudmouthDie(), new CowardDie()};
            useExtraDice = true;
        }
        else {
            useExtraDice = false;
        }

        List<Character> allChars = Arrays.asList(Character.values());
        Collections.shuffle(allChars, rand);
        
        List<Role> allRoles = Arrays.asList(getRolesForGame(numPlayers));
        Collections.shuffle(allRoles, rand);

        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player(allChars.get(i), allRoles.get(i), i));
        }

    }

    
    /** 
     * @return Face[] An array of the current faces on the dice being used.
     */
    public Face[] getDiceFaces() {
        Face[] out = new Face[numDice];
        for (int i = 0; i < numDice; i++) {
            out[i] = dice[i].getCurrentFace();
        }
        return out;
    }

    
    /** 
     * @param diceToRoll A boolean array of which dice the roll. For example, {True, False, False, False, False} will only roll the first die.
     * @param player The Player that is rolling the dice.
     */
    public void rollDice(boolean[] diceToRoll, Player player) {
        if (diceToRoll.length < numDice) {
            System.out.println("Error in DiceSet.roll: diceToRoll is too short, need at least " + numDice + " values");
        }
        for (int i = 0; i < numDice; i++) {
            if (diceToRoll[i] && !dice[i].isLocked()) {
                dice[i].roll();
                if (dice[i].getCurrentFace() == Face.ARROW) takeArrow(player);
            }
        }
        for (Die d : dice) {
            System.out.print(d.getCurrentFace() + ", ");
            //textArea.appendText(d.getCurrentFace() + ", ");
        }
        System.out.println();
        //textArea.appendText("\n");
    }

    
    /** 
     * @param diceToRoll A boolean array of which dice the roll. For example, {True, False, False, False, False} will only roll the first die.
     * @param player The Player that is rolling the dice.
     * @param useLoudmouth Whether or not to use the Loudmouth die.
     * @param useCoward Whether or not to use the Coward die.
     */
    public void rollDice(boolean[] diceToRoll, Player player, boolean useLoudmouth, boolean useCoward) {
        if (!useExpansion1 && (useCoward || useLoudmouth)) System.out.println("Error: rollDice() was called with useLoudmouth or useCoward without expansion 1 enabled");
        if (diceToRoll.length < numDice) {
            System.out.println("Error in DiceSet.roll: diceToRoll is too short, need at least " + numDice + " values");
        }
        for (int i = 0; i < numDice; i++) {
            if (diceToRoll[i] && !dice[i].isLocked()) dice[i].roll();
        }
    }

    
    /** 
     * @param p The player that is taking an arrow.
     */
    public void takeArrow(Player p) {
        p.addArrow();
        //System.out.println(p.getCharacter() + " took an arrow");
        
        numArrows--;
        if (numArrows <= 0) {
            for (Player player : players) {
                player.indianAttack();
            }
            numArrows = 9;
        }
    }

    
    /** 
     * @param player The player that the computer will take a turn for.
     */
    public void takeComputerTurn(Player player) {
        boolean turnEnd = false;
        rollDice(new boolean[] {true, true, true, true, true}, player);
        int numDynamite = 0;
        for (Die d : dice) {
            if (d.getCurrentFace() == Face.DYNAMITE) numDynamite++;
        }
        turnEnd = numDynamite >= 3;
		for(int i = 0; i < 2 && !turnEnd; i++) {
			boolean roll1 = rand.nextBoolean() || getDiceFaces()[0] == Face.ARROW;
			boolean roll2 = rand.nextBoolean() || getDiceFaces()[1] == Face.ARROW;
			boolean roll3 = rand.nextBoolean() || getDiceFaces()[2] == Face.ARROW;
			boolean roll4 = rand.nextBoolean() || getDiceFaces()[3] == Face.ARROW;
			boolean roll5 = rand.nextBoolean() || getDiceFaces()[4] == Face.ARROW;
			rollDice(new boolean[] {roll1, roll2, roll3, roll4, roll5}, player);
            numDynamite = 0;
            for (Die d : dice) {
                if (d.getCurrentFace() == Face.DYNAMITE) numDynamite++;
            }
            turnEnd = numDynamite >= 3;
        }
        if (numDynamite >= 3) {
            System.out.println("Dynamite blew up in " + player + "'s face!");
            player.removeHP(1);
            if (player.isEliminated()) {
                handleElim(player);
                return;
            }
        }
        for (Face f : getDiceFaces()) {
            if (f == Face.SHOOT1) {
                if(player.getCharacter() == Character.CALAMITY_JANET) {
                    Player[] targets = new Player[] {
                        players.get(Math.floorMod((player.getSeatPosition()-1), numPlayers)), 
                        players.get(Math.floorMod((player.getSeatPosition()+1), numPlayers)),
                        players.get(Math.floorMod((player.getSeatPosition()-2), numPlayers)), 
                        players.get(Math.floorMod((player.getSeatPosition()+2), numPlayers)) 
                    };
                    Player target = targets[rand.nextInt(4)];
                    player.shootPlayer(target);
                    if (target.isEliminated()) handleElim(target);
                }
                else {
                    Player[] targets = new Player[] {
                        players.get(Math.floorMod((player.getSeatPosition()-1), numPlayers)), 
                        players.get(Math.floorMod((player.getSeatPosition()+1), numPlayers))
                    };
                    Player target = targets[rand.nextInt(2)];
                    player.shootPlayer(target);
                    if (target.isEliminated()) handleElim(target);
                }
            }
            if (f == Face.SHOOT2) {
                if(player.getCharacter() == Character.CALAMITY_JANET) {
                    Player[] targets = new Player[] {
                        players.get(Math.floorMod((player.getSeatPosition()-1), numPlayers)), 
                        players.get(Math.floorMod((player.getSeatPosition()+1), numPlayers)),
                        players.get(Math.floorMod((player.getSeatPosition()-2), numPlayers)), 
                        players.get(Math.floorMod((player.getSeatPosition()+2), numPlayers)) 
                    };
                    Player target = targets[rand.nextInt(4)];
                    player.shootPlayer(target);
                    if (target.isEliminated()) handleElim(target);
                }
                else {
                    Player[] targets = new Player[] {
                        players.get(Math.floorMod((player.getSeatPosition()-2), numPlayers)), 
                        players.get(Math.floorMod((player.getSeatPosition()+2), numPlayers)) 
                    };
                    Player target = targets[rand.nextInt(2)];
                    player.shootPlayer(target);
                    if (target.isEliminated()) handleElim(target);
                }
            }
        }

        for(Face f : getDiceFaces()) {
            if (f == Face.BEER) {
                player.addHP(1);
                System.out.println(player + " healed themself");
            }
        }

        int numGat = 0;
		for(Face f : getDiceFaces()) {
            if (f == Face.GATLING) {
                numGat++;
            }
        }

        if (numGat >= 3) {
            System.out.println(player + " fired the gatling gun");
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i) != player) {
                    players.get(i).removeHP(1);
                    if (players.get(i).isEliminated()) handleElim(players.get(i));
                }
            }
        }

        for (Die d : dice) {
            d.setLocked(false);
            d.setUnlockable(true);
        }
    }
    
    public void handleElim(Player player) {
        players.remove(player);
        numPlayers--;
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setSeatPosition(i);
        }
        System.out.println(player + " Was eliminated! They were a(n) " + player.getRole());
        if (players.size() <= 1) {
            gameOver = true;
        }
        if (player.getRole() == Role.SHERRIF) {
            gameOver = true;
        }
        if (!areRenegadesOrOutlawsAlive()) {
            gameOver = true;
        }
    }

    public boolean areRenegadesOrOutlawsAlive() {
        boolean is = false;
        for (Player p : players) {
            if (p.getRole() == Role.RENEGADE || p.getRole() == Role.OUTLAW) is = true;
        }
        return is;
    }

    
    /** 
     * @param numPlayers The number of player to get the role array for.
     * @return Role[] The Roles appropriate for the number of players.
     */
    private static Role[] getRolesForGame(int numPlayers) {
        switch(numPlayers) {
            case 3: return new Role[] {Role.DEPUTY, Role.OUTLAW, Role.RENEGADE};
            case 4: return new Role[] {Role.SHERRIF, Role.OUTLAW, Role.OUTLAW, Role.RENEGADE};
            case 5: return new Role[] {Role.SHERRIF, Role.DEPUTY, Role.OUTLAW, Role.OUTLAW, Role.RENEGADE};
            case 6: return new Role[] {Role.SHERRIF, Role.DEPUTY, Role.OUTLAW, Role.OUTLAW, Role.OUTLAW, Role.RENEGADE};
            case 7: return new Role[] {Role.SHERRIF, Role.DEPUTY, Role.DEPUTY, Role.OUTLAW, Role.OUTLAW, Role.OUTLAW, Role.RENEGADE};
            case 8: return new Role[] {Role.SHERRIF, Role.DEPUTY, Role.DEPUTY, Role.OUTLAW, Role.OUTLAW, Role.OUTLAW, Role.RENEGADE, Role.RENEGADE};
            default: return null;
        }
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Game game = new Game(5, false, false);
        while (!game.gameOver) {
            for (int i = 0; i < game.players.size() && !game.gameOver; i++) {
                System.out.println();
                System.out.println(game.players.get(i).getCharacter() + "'s turn");
                game.takeComputerTurn(game.players.get(i));
            }
        }
        for (Player p : game.players) {
            System.out.println(p + " was a " + p.getRole());
        }
    }

}
