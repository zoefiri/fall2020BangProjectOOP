package Fall2020OOPProject3;

import java.util.Random;

public class die_black {

	public enum Face {
		DUEL,
		DUEL_,
                DYNAMITE,
                ARROW,
		GATLING,
                WHISKY
	}

        private boolean locked; //having the state of the die bound to the object makes UI retrieval easier
	private boolean unlockable; //can the user toggle the lock state, or is it locked by game rules
	private Face currentFace;

	public die_black() {
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