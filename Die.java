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
	
	private boolean locked; //having the state of the die bound to the object makes UI retrieval easier
	private boolean unlockable; //can the user toggle the lock state, or is it locked by game rules
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