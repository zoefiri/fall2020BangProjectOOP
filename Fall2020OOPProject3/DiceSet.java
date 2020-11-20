package Fall2020OOPProject3;

public class DiceSet {

	private Die[] dice;
	private int numDice;

	public DiceSet(int numDice) {
		dice = new Die[numDice];
		this.numDice = numDice;
		for (int i = 0; i < numDice; i++) {
			dice[i] = new VanillaDie();
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
			if (diceToRoll[i]) dice[i].roll();
		}
	}
}
