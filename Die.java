import java.util.Random;

public abstract class Die{

	protected static final Random rand = new Random();

	public enum Face {
		ARROW,
		DYNAMITE,
		SHOOT1,
		SHOOT2,
		BEER,
		GATLING,
		SHOOT1_2X,
		SHOOT2_2X,
		SILVERBULLET,
		BROKEN_ARROW,
		BEER_2X,
		DUEL,
		DUEL_,
		WHISKY
	};

	protected abstract Face[] getPossibleFaces();

	private boolean unlockable; //can the user toggle the lock state, or is it locked by game rules

	Face currentFace;

	public Face roll(){
		currentFace = getPossibleFaces()[rand.nextInt(getPossibleFaces().length)];
		unlockable = currentFace != Face.DYNAMITE;
		return currentFace;
	}
		

	public Face getCurrentFace() {
		return currentFace;
	};
}
