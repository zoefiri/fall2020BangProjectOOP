package Fall2020OOPProject3;

public class Player {

	public enum Character {
		SUZY_LAFAYETTE("Suzy Lafayette"),
		PAUL_REGRET("Paul Regret"),
		VULTURE_SAM("Vulture Sam"),
		LUCKY_DUKE("Lucky Duke"),
		JOURDONNAIS("Jourdonnais"),
		CALAMITY_JANET("Calamity Janet"),
		BLACK_JACK("Black Jack"),
		ROSE_DOOLAN("Rose Doolan");

		private String name;
		
		private Character(String s) {
			name = s;
		}

		public String toString() {
			return name;
		}
	}

	public enum Role {
		SHERRIF("Sherrif"),
		DEPUTY("Deputy"),
		OUTLAW("Outlaw"),
		RENEGADE("Renegade");

		private String name;
		
		private Role(String s) {
			name = s;
		}

		public String toString() {
			return name;
		}
	}

	protected int hp;
	protected int arrows;
	protected int seatPosition;
	protected Character character;
	protected Role role;
	protected boolean eliminated;

	public Player(Character character, Role role, int seat) {
		this.character = character;
		this.role = role;
		this.arrows = 0;
		this.hp = getMaxHPOfCharacter(character);
		this.seatPosition = seat;
	}

	public void shootPlayer(Player player) {
		player.removeHP(1);
		System.out.println(character + " shot at " + player.getCharacter());
	}

	public int indianAttack() {
		if (arrows == 0) return hp;
		hp -= (character == Character.JOURDONNAIS) ? 1 : arrows;
		arrows = 0;
		return hp; 
	}

	public int addArrow() {
		return ++arrows;
	}

	public int addHP(int heal) {
		hp += heal;
		if (hp > getMaxHP()) hp = getMaxHP();
		return hp;
	}

	public int removeHP(int hit) {
		hp -= hit;
		eliminated = hp <= 0;
		return hp;
	}

	public int getSeatPosition() {
		return seatPosition;
	}

	public void setSeatPosition(int seat) {
		seatPosition = seat;
	}

	public Role getRole() {
		return role;
	}

	public Character getCharacter(){
		return character;
	}

	public int getCurrentArrows() {
		return arrows;
	}

	public int getCurrentHP() {
		return hp;
	}

	public int getMaxHP() {
		return getMaxHPOfCharacter(character);
	}

	public boolean isEliminated() {
		return eliminated;
	}

	public static int getMaxHPOfCharacter(Character character) {
		switch(character) {
			case JOURDONNAIS: 
				return 7;
			case SUZY_LAFAYETTE:
			case LUCKY_DUKE:
			case CALAMITY_JANET:
			case BLACK_JACK:
				return 8;
			case PAUL_REGRET:
			case VULTURE_SAM:
			case ROSE_DOOLAN:
				return 9;
		}
		return -1; //needs explicit return statement or default case
	} 

	public String toString() {
		return character.toString();
	}
	
}