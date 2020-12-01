package Fall2020OOPProject3;

import Fall2020OOPProject3.Die.Face;

public class DiceSet {

	private Die[] dice;
	private Die[] extraDice;
	private int numDice;
	private boolean useExtra;
	private int numArrows;

	public DiceSet(boolean expansion1, boolean expansion2) {
		dice = new Die[5];
		this.numDice = 5;
		numArrows = 9;
		if (expansion2) {
			for (int i = 0; i < 3; i++) {
				dice[i] = new VanillaDie();
			}
			for (int i = 3; i < 5; i++) {
				dice[i] = new BlackDie();
			}
		}
		else {
			for (int i = 0; i < 5; i++) {
				dice[i] = new VanillaDie();
			}
		}
		if(expansion1) {
			extraDice = new Die[] {new LoudmouthDie(), new CowardDie()};
			useExtra = true;
		}
		else {
			useExtra = false;
		}
	}

	public Die.Face[] getFaces() {
		Die.Face[] out = new Die.Face[numDice];
		for (int i = 0; i < numDice; i++) {
			out[i] = dice[i].getCurrentFace();
		}
		return out;
	}

	public void roll(boolean[] diceToRoll) {
		if (diceToRoll.length < numDice) {
			System.out.println("Error in DiceSet.roll: diceToRoll is too short, need at least " + numDice + " values");
		}
		for (int i = 0; i < numDice; i++) {
			if (diceToRoll[i] && !dice[i].isLocked()) dice[i].roll();
			if (dice[i].getCurrentFace() == Face.DYNAMITE) {
				dice[i].setLocked(true);
				dice[i].setUnlockable(false);
			}
		}
	}

	public void roll(boolean[] diceToRoll, boolean useLoudmouth, boolean useCoward) {
		if (diceToRoll.length < numDice) {
			System.out.println("Error in DiceSet.roll: diceToRoll is too short, need at least " + numDice + " values");
		}
		for (int i = 0; i < numDice; i++) {
			if (diceToRoll[i] && !dice[i].isLocked()) dice[i].roll();
		}
	}
}
