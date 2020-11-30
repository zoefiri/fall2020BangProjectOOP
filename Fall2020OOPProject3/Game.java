package Fall2020OOPProject3;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    public ArrayList<Player> players = new ArrayList<Player>();

    public Game(int bots, boolean expansion1, boolean expansion2) {
        for (int i = 0; i < bots+1; i++) {
            int pickChar = new Random().nextInt(Player.Character.values().length);
            int pickRole = new Random().nextInt(Player.Role.values().length);
            boolean d = false;
            while (!d) {
                for (Player player : players) {
                    if (player.getCharacter() == Player.Character.values()[pickChar]) {
                        d = false;
                    }
                }

            }
            players.add(new Player(Player.Character.values()[pickChar], Player.Role.values()[pickRole]));
        }

    }

}
