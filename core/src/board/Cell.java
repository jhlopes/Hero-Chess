package board;

import com.badlogic.gdx.graphics.Texture;

import character.Character;
import character.Damage;

public class Cell {

	private Character character;
	private boolean empty;

	public Cell() {
		this.character = null;
		this.empty = true;
	}

	public Texture getSpriteOfCell() {
		if (!this.empty) {
			return this.character.getSprite();
		} else {
			return new Texture("board/emptyCell.png");
		}
	}

	public boolean isEmpty() {
		return this.empty;
	}

	public void insertCharacter(Character characterToInsert) {
		this.empty = false;
		this.character = characterToInsert;
	}

	public Character removeCharacter() {
		if (!this.empty) {
			Character charToReturn = this.character;
			this.character = null;
			this.empty = true;
			return charToReturn;
		} else {
			System.out.println("tried to remove");
			return null;
		}

	}

	public String getName() {
		return this.character.getName();
	}

//	
//	
//				1 2   2 2
//	          0 1  1 1  2 1
//				1 0   0 2	 
//	
//	
// topleft  col = col / row = row + 1;
// topright col = col + 1 / row = row + 1;
// left     col = col - 1 / row = row;
// right    col = col + 1 / row = row;
// botleft  col = col / row = row - 1;
// botright col = col - 1 / row = row + 1;

}
