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

	
	/** 
	 * @param player The Player this Player is going to shoot.
	 */
	public void shootPlayer(Player player) {
		player.removeHP(1);
		System.out.println(character + " shot at " + player.getCharacter());
	}

	
	/** 
	 * @return int The HP the Player has after the attack.
	 */
	public int indianAttack() {
		if (arrows == 0) return hp;
		hp -= (character == Character.JOURDONNAIS) ? 1 : arrows;
		arrows = 0;
		return hp; 
	}

	
	/** 
	 * @return int The amount of arrows the player has after adding one.
	 */
	public int addArrow() {
		return ++arrows;
	}

	
	/** 
	 * @param heal The amount of HP to restore.
	 * @return int The HP of the Player after healing.
	 */
	public int addHP(int heal) {
		hp += heal;
		if (hp > getMaxHP()) hp = getMaxHP();
		return hp;
	}

	
	/** 
	 * @param hit The amount of HP to subtract.
	 * @return int The HP of the player after being hit.
	 */
	public int removeHP(int hit) {
		hp -= hit;
		eliminated = hp <= 0;
		return hp;
	}

	
	/** 
	 * @return int The current seat position of the Player.
	 */
	public int getSeatPosition() {
		return seatPosition;
	}

	
	/** 
	 * @param seat The seat position to move the player to.
	 */
	public void setSeatPosition(int seat) {
		seatPosition = seat;
	}

	
	/** 
	 * @return Role The current Role of the Player.
	 */
	public Role getRole() {
		return role;
	}

	
	/** 
	 * @return Character The current Character of the Player.
	 */
	public Character getCharacter(){
		return character;
	}

	
	/** 
	 * @return int The amount of arrows the Player currently has.
	 */
	public int getCurrentArrows() {
		return arrows;
	}

	
	/** 
	 * @return int The amount of HP the Player currently has.
	 */
	public int getCurrentHP() {
		return hp;
	}

	
	/** 
	 * @return int The maximum HP of the player, determined by their Character.
	 */
	public int getMaxHP() {
		return getMaxHPOfCharacter(character);
	}

	
	/** 
	 * @return boolean Whether this Player has been eliminated from the game.
	 */
	public boolean isEliminated() {
		return eliminated;
	}

	
	/** 
	 * @param character The Character to look up.
	 * @return int The Maximum HP of character.
	 */
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

	
	/** 
	 * @return String Returns the name of the player's Character.
	 */
	public String toString() {
		return character.toString();
	}

	public String getRoleMask() {
		if (isEliminated())
			return getRole().toString();
		else
			return "UNKNOWN";
	}

	public String getCurrentHPMask() {
		if (isEliminated())
			return "DEAD";
		else
			return Integer.toString(getCurrentHP());
	}
}