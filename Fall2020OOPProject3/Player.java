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

	public boolean isHuman = false;
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
	 * Makes the player shoot another player.
	 * 
	 * @param player The Player this Player is going to shoot.
	 */
	public void shootPlayer(Player player) {
		player.removeHP(1);
		System.out.println(character + " shot at " + player.getCharacter());
	}

	
	/** 
	 * Handles the damage for an Indian attack.
	 * @return int The HP the Player has after the attack.
	 */
	public void indianAttack() {
		if (arrows != 0) {
			if (character == Character.JOURDONNAIS) removeHP(1);
			else removeHP(arrows);
			arrows = 0;
		}
	}

	
	/** 
	 * Adds an arrow to the player's pool.
	 * @return int The amount of arrows the player has after adding one.
	 */
	public int addArrow() {
		return ++arrows;
	}

	
	/** 
	 * Adds HP to a players total, capping it at their maximum.
	 * @param heal The amount of HP to restore.
	 * @return int The HP of the Player after healing.
	 */
	public int addHP(int heal) {
		hp += heal;
		if (hp > getMaxHP()) hp = getMaxHP();
		return hp;
	}

	
	/** 
	 * Removes HP from a player and updates the eliminated flag.
	 * @param hit The amount of HP to subtract.
	 * @return int The HP of the player after being hit.
	 */
	public int removeHP(int hit) {
		hp -= hit;
		eliminated = hp <= 0;
		return hp;
	}

	
	/** 
	 * Returns the seat position of the player.
	 * @return int The current seat position of the Player.
	 */
	public int getSeatPosition() {
		return seatPosition;
	}

	
	/** 
	 * Moves the player to a new seat position.
	 * @param seat The seat position to move the player to.
	 */
	public void setSeatPosition(int seat) {
		seatPosition = seat;
	}

	
	/** 
	 * Gets the Role of the player.
	 * @return Role The current Role of the Player.
	 */
	public Role getRole() {
		return role;
	}

	
	/** 
	 * Gets the Character of the player.
	 * @return Character The current Character of the Player.
	 */
	public Character getCharacter(){
		return character;
	}

	
	/** 
	 * Gets the amount of arrows the player currently has.
	 * @return int The amount of arrows the Player currently has.
	 */
	public int getCurrentArrows() {
		return arrows;
	}

	
	/** 
	 * Gets the amount of HP the player currently has.
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
	 * Looks up the maximum HP a player should have based on what character they are.
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

	/**
	 * If this player's role is known to the human player, get it; if not, return "UNKNOWN".
	 * @return String gets the role if it is known, or "UNKNOWN" if not.
	 */
	public String getRoleMask() {
		if (isHuman)
			return getRole().toString();
		if (isEliminated())
			return getRole().toString();
		else
			return "UNKNOWN";
	}

	/**
	 * Return the HP of the current player, or "DEAD" if the player is eliminated.
	 * @return String the HP of the player, or "DEAD"
	 */
	public String getCurrentHPMask() {
		if (isEliminated())
			return "DEAD";
		else
			return Integer.toString(getCurrentHP());
	}

}