package Fall2020OOPProject3;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;
import java.util.Arrays;

public class Game {
    public ArrayList<Player> players = new ArrayList<Player>();
    public DiceSet dice;

    private boolean useExpansion1;
    private boolean useExpansion2;
    private int numPlayers;
    private Random rand;

    public Game(int bots, boolean expansion1, boolean expansion2) {
        rand = new Random();
        numPlayers = bots + 1;
        List<Player.Character> allChars = Arrays.asList(Player.Character.values());
        Collections.shuffle(allChars, rand);
        
        List<Player.Role> allRoles = Arrays.asList(getRolesForGame(numPlayers));
        Collections.shuffle(allRoles, rand);

        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player(allChars.get(i), allRoles.get(i)));
        }

        dice = new DiceSet(expansion1, expansion2);



    }

    private static Player.Role[] getRolesForGame(int numPlayers) {
        switch(numPlayers) {
            case 3: return new Player.Role[] {Player.Role.DEPUTY, Player.Role.OUTLAW, Player.Role.RENEGADE};
            case 4: return new Player.Role[] {Player.Role.SHERRIF, Player.Role.OUTLAW, Player.Role.OUTLAW, Player.Role.RENEGADE};
            case 5: return new Player.Role[] {Player.Role.SHERRIF, Player.Role.DEPUTY, Player.Role.OUTLAW, Player.Role.OUTLAW, Player.Role.RENEGADE};
            case 6: return new Player.Role[] {Player.Role.SHERRIF, Player.Role.DEPUTY, Player.Role.OUTLAW, Player.Role.OUTLAW, Player.Role.OUTLAW, Player.Role.RENEGADE};
            case 7: return new Player.Role[] {Player.Role.SHERRIF, Player.Role.DEPUTY, Player.Role.DEPUTY, Player.Role.OUTLAW, Player.Role.OUTLAW, Player.Role.OUTLAW, Player.Role.RENEGADE};
            case 8: return new Player.Role[] {Player.Role.SHERRIF, Player.Role.DEPUTY, Player.Role.DEPUTY, Player.Role.OUTLAW, Player.Role.OUTLAW, Player.Role.OUTLAW, Player.Role.RENEGADE, Player.Role.RENEGADE};
            default: return null;
        }
    }

}
