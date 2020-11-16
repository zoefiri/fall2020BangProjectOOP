package fall2020BangProjectOOP;

public class DiceSet {

	private Die[] dice;
	private int numDice;

	public DiceSet(int numDice) {
		dice = new Die[numDice];
		this.numDice = numDice;
		for (int i = 0; i < numDice; i++) {
			dice[i] = new Die();
		}
	}

	public Die.Face[] getFaces() {
		Die.Face[] out = new Die.Face[numDice];
		for (int i = 0; i < numDice; i++) {
			out[i] = dice[i].getCurrentFace();
		}
		return out;
	}

	public void roll() {
		for (Die d : dice) {
			d.roll();
		}
	}
}