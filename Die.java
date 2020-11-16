package fall2020BangProjectOOP;
import java.util.Random;

public class Die {

	public enum Face {
		ARROW,
		DYNAMITE,
		SHOOT1,
		SHOOT2,
		BEER,
		GATLING
	}

	private Face currentFace;

	public Die() {
		currentFace = Face.ARROW;
	}

	public Face roll() {
		Random rand = new Random();
		currentFace = Face.values()[rand.nextInt(6)];
		return currentFace;
	}

	public Face getCurrentFace() {
		return currentFace;
	}
}