package Fall2020OOPProject3;

public class LoudmouthDie extends Die{

	final static private Face[] possibleFaces = {
		Face.SHOOT1_2X,
		Face.SHOOT2_2X,
		Face.DYNAMITE,
		Face.ARROW,
		Face.GATLING,
		Face.SILVERBULLET
	};

	protected Face[] getPossibleFaces() {
		return possibleFaces;
	}

	public LoudmouthDie() {
		currentFace = Face.ARROW;
	}
}
