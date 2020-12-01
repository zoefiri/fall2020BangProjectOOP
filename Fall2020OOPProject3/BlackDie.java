package Fall2020OOPProject3;

public class BlackDie extends Die{

	final static private Face[] possibleFaces = {
		Face.DUEL,
		Face.DUEL_,
		Face.DYNAMITE,
		Face.ARROW,
		Face.GATLING,
		Face.WHISKY
	};

    protected Face[] getPossibleFaces() {
		return possibleFaces;
	}

	public BlackDie() {
		currentFace = Face.ARROW;
	}
}