package character;

import com.badlogic.gdx.graphics.Texture;

public abstract class Character {

	private int health;
	private Texture texture;
	private boolean enemy;
	private int range;
	private int level;
	private int attack;
	private int mana;
	private int magic;
	private int armor;
	private String name;
	private int xp;

	public Character(String name, boolean enemy, int range, int health, int armor, int attack, int mana, int magic) {

		this.health = health;
		this.enemy = enemy;
		this.range = range;
		this.level = 1;
		this.attack = attack;
		this.mana = mana;
		this.magic = magic;
		this.armor = armor;
		this.name = name;
		this.xp = 0;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Texture getSprite() {

		return this.texture;
	}

}
