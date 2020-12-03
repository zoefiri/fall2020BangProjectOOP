package Fall2020OOPProject3;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;
import java.util.Arrays;

import Fall2020OOPProject3.Die.Face;
import Fall2020OOPProject3.Player.Role;
import Fall2020OOPProject3.Player.Character;

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

    public Game(int bots, boolean expansion1, boolean expansion2) {
        rand = new Random();
        numPlayers = bots + 1;
        dice = new Die[5];
        this.numDice = 5;
        numArrows = 9;

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

    public Face[] getDiceFaces() {
        Face[] out = new Face[numDice];
        for (int i = 0; i < numDice; i++) {
            out[i] = dice[i].getCurrentFace();
        }
        return out;
    }

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
        }
        System.out.println();
    }

    public void rollDice(boolean[] diceToRoll, Player player, boolean useLoudmouth, boolean useCoward) {
        if (!useExpansion1 && (useCoward || useLoudmouth)) System.out.println("Error: rollDice() was called with useLoudmouth or useCoward without expansion 1 enabled");
        if (diceToRoll.length < numDice) {
            System.out.println("Error in DiceSet.roll: diceToRoll is too short, need at least " + numDice + " values");
        }
        for (int i = 0; i < numDice; i++) {
            if (diceToRoll[i] && !dice[i].isLocked()) dice[i].roll();
        }
    }

    public void takeArrow(Player p) {
        p.addArrow();
        System.out.println(p.getCharacter() + " took an arrow");
        numArrows--;
        if (numArrows <= 0) {
            for (Player player : players) {
                player.indianAttack();
            }
            numArrows = 9;
        }
    }

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
                    player.shootPlayer(targets[rand.nextInt(4)]);
                }
                else {
                    Player[] targets = new Player[] {
                        players.get(Math.floorMod((player.getSeatPosition()-1), numPlayers)), 
                        players.get(Math.floorMod((player.getSeatPosition()+1), numPlayers))
                    };
                    player.shootPlayer(targets[rand.nextInt(2)]);
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
                    player.shootPlayer(targets[rand.nextInt(4)]);
                }
                else {
                    Player[] targets = new Player[] {
                        players.get(Math.floorMod((player.getSeatPosition()-2), numPlayers)), 
                        players.get(Math.floorMod((player.getSeatPosition()+2), numPlayers)) 
                    };
                    player.shootPlayer(targets[rand.nextInt(2)]);
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
            for (Player p : players) {
                if (p != player) {
                    p.removeHP(1);
                }
            }
        }

        for (Die d : dice) {
            d.setLocked(false);
            d.setUnlockable(true);
        }
	}


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

    public static void main(String[] args) {
        Game game = new Game(5, false, false);
        for (Player p : game.players) {
            System.out.println();
            System.out.println(p.getCharacter() + "'s turn");
            game.takeComputerTurn(p);
        }
    }

}
