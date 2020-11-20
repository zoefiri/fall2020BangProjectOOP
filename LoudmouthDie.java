
import java.util.Random;

public class LoudmouthDie extends Die{

	final static private Face[] possibleFaces = {
		Face.SHOOT1_2X,
		Face.SHOOT2_2X,
		Face.DYNAMITE,
		Face.ARROW,
		Face.GATLING,
		Face.SILVERBULLET
	};

	private boolean locked; //having the state of the die bound to the object makes UI retrieval easier
	private boolean unlockable; //can the user toggle the lock state, or is it locked by game rules
	private Face currentFace;


	protected Face[] getPossibleFaces() {
		return possibleFaces;
	}

	public die_loudmouth() {
		currentFace = Face.ARROW;
	}
}
