package Fall2020OOPProject3;

import javax.lang.model.element.Element;

public class Player {

	public enum Character {
		SUZY_LAFAYETTE,
		PAUL_REGRET,
		VULTURE_SAM,
		LUCKY_DUKE,
		JOURDONNAIS,
		CALAMITY_JANET,
		BLACK_JACK,
		ROSE_DOOLAN
	}

	public enum Role {
		SHERRIF,
		DEPUTY,
		OUTLAW,
		RENEGADE
	}

	private int hp;
	private int arrows;
	private Character character;
	private Role role;
	private boolean elimiated;

	public Player(Character character, Role role) {
		this.character = character;
		this.role = role;
		this.arrows = 0;
		this.hp = getMaxHPOfCharacter(character);
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
		elimiated = hp <= 0;
		return hp;
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
		return elimiated;
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
	
}