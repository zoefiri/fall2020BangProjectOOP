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

	
	/** 
	 * @return Face[] Returns the possible faces for the implementation of Die.
	 */
	protected abstract Face[] getPossibleFaces();

	private boolean locked;
	private boolean unlockable; //can the user toggle the lock state, or is it locked by game rules

	Face currentFace;

	
	/** 
	 * @return Face The face that was rolled.
	 */
	public Face roll(){
		if (locked) return currentFace;
		currentFace = getPossibleFaces()[rand.nextInt(getPossibleFaces().length)];
		unlockable = currentFace != Face.DYNAMITE;
		locked = currentFace == Face.DYNAMITE;
		return currentFace;
	}

	public void toggleLocked() {
		if (unlockable && locked) locked = false;
		else locked = true;
	}

	
	/** 
	 * @param lock 
	 */
	public void setLocked(boolean lock) {
		if (unlockable) locked = lock;
	}

	
	/** 
	 * @return boolean Whether the Die is currently locked, either by the player or by game rules.
	 */
	public boolean isLocked() {
		return locked;
	}

	
	/** 
	 * @return boolean Whether the Die is locked by game rules.
	 */
	public boolean isUnlockable() {
		return unlockable;
	}

	
	/** 
	 * @param unlockable
	 */
	public void setUnlockable(boolean unlockable) {
		this.unlockable = unlockable;
	}
		

	
	/** 
	 * @return Face Returns the current showing Face of the Die.
	 */
	public Face getCurrentFace() {
		return currentFace;
	};
}
