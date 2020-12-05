package Fall2020OOPProject3;

public class VanillaDie extends Die {

	final static private Face[] possibleFaces = {
		Face.ARROW,
		Face.DYNAMITE,
		Face.SHOOT1,
		Face.SHOOT2,
		Face.BEER,
		Face.GATLING
	};

	protected Face[] getPossibleFaces() {
		return possibleFaces;
	}

	public VanillaDie() {
		currentFace = Face.ARROW;
		setUnlockable(true);
	}

	public static void main(String[] args) {
		VanillaDie die = new VanillaDie();
		die.roll();
		System.out.println(die.getCurrentFace());
	}
}
