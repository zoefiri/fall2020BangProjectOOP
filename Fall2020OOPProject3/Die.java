package Fall2020OOPProject3;

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

	private boolean locked;
	private boolean unlockable; //can the user toggle the lock state, or is it locked by game rules

	Face currentFace;

	public Face roll(){
		if (locked) return currentFace;
		currentFace = getPossibleFaces()[rand.nextInt(getPossibleFaces().length)];
		unlockable = currentFace != Face.DYNAMITE;
		return currentFace;
	}

	public void toggleLocked() {
		if (unlockable) locked = !locked;
	}

	public void setLocked(boolean lock) {
		if (unlockable) locked = lock;
	}

	public boolean isLocked() {
		return locked;
	}

	public boolean isUnlockable() {
		return unlockable;
	}

	public void setUnlockable(boolean unlockable) {
		this.unlockable = unlockable;
	}
		

	public Face getCurrentFace() {
		return currentFace;
	};
}
