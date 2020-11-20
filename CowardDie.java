

import java.util.Random;

public class CowardDie extends Die{

	final static private Face[] possibleFaces = {
		Face.SHOOT1,
		Face.BEER_2X,
		Face.DYNAMITE,
		Face.ARROW,
		Face.BROKEN_ARROW,
		Face.BEER
	};

	private boolean locked; //having the state of the die bound to the object makes UI retrieval easier
	private boolean unlockable; //can the user toggle the lock state, or is it locked by game rules
	private Face currentFace;


	protected Face[] getPossibleFaces() {
		return possibleFaces;
	}

	public CowardDie() {
		currentFace = Face.ARROW;
	}
}
