package Fall2020OOPProject3;

import Fall2020OOPProject3.DiceSet;
import Fall2020OOPProject3.Die.Face;
import java.util.Random;

public class ComPlayer extends Player{

	private Random rand;

	public ComPlayer(Character character, Role role) {
		rand = new Random();
		super(character, role);
	}

	public void takeTurn(DiceSet dice) {
		dice.roll(new boolean[] {true, true, true, true, true});
		for (Face f : dice.getFaces()) {
			if (f == Face.ARROW) addArrow();
		}
		for(int i = 0; i < 2; i++) {
			boolean roll1 = rand.nextBoolean() || dice.getFaces()[0] == Face.ARROW;
			boolean roll2 = rand.nextBoolean() || dice.getFaces()[1] == Face.ARROW;
			boolean roll3 = rand.nextBoolean() || dice.getFaces()[2] == Face.ARROW;
			boolean roll4 = rand.nextBoolean() || dice.getFaces()[3] == Face.ARROW;
			boolean roll5 = rand.nextBoolean() || dice.getFaces()[4] == Face.ARROW;
			dice.roll(new boolean[] {roll1, roll2, roll3, roll4, roll5});
			for (Face f : dice.getFaces()) {
				if (f == Face.ARROW) addArrow();
			}
		}
		
	}

}