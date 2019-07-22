package character;

import com.badlogic.gdx.graphics.Texture;

public class Archer extends Character {

	public Archer(String name, boolean enemy, int range, int health, int armor, int attack, int mana, int magic) {
		super(name, enemy, range, health, armor, attack, mana, magic);

		this.setTexture(new Texture("heros/archer.png"));
	}

}
