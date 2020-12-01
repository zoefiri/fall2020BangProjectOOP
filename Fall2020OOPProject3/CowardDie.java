package Fall2020OOPProject3;


public class CowardDie extends Die{

	final static private Face[] possibleFaces = {
		Face.SHOOT1,
		Face.BEER_2X,
		Face.DYNAMITE,
		Face.ARROW,
		Face.BROKEN_ARROW,
		Face.BEER
	};

	protected Face[] getPossibleFaces() {
		return possibleFaces;
	}

	public CowardDie() {
		currentFace = Face.ARROW;
	}
}
