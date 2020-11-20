package Fall2020OOPProject3;

import java.util.Random;

public class BlackDie extends Die{

	final static private Face[] possibleFaces = {
		Face.DUEL,
		Face.DUEL_,
		Face.DYNAMITE,
		Face.ARROW,
		Face.GATLING,
		Face.WHISKY
	};

        private boolean locked; //having the state of the die bound to the object makes UI retrieval easier
	private boolean unlockable; //can the user toggle the lock state, or is it locked by game rules
	private Face currentFace;

	protected Face[] getPossibleFaces() {
		return possibleFaces;
	}

	public BlackDie() {
		currentFace = Face.ARROW;
	}
}