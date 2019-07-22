package board;

import com.badlogic.gdx.graphics.Texture;

import character.Archer;
import character.Character;

public class Board {

	private int rows;
	private int cols;
	private Cell[][] cell;

	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		cell = new Cell[rows][cols];
		generateEmptyBoard();

	}

	private void generateEmptyBoard() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				this.cell[i][j] = new Cell();
			}
		}

	}

	public Texture getSprite(int col, int row) {
		return this.cell[col][row].getSpriteOfCell();
	}

	public boolean insertCharacter(Character character, int col, int row) {

		if (cell[col][row].isEmpty()) {
			cell[col][row].insertCharacter(character);
			System.out.println(character.getName() + " inserted in " + col + " " + row);
			return true;
		} else {
			System.out.println(col + " " + row + " is already occupied by " + character.getName());
			return false;
		}

	}

	public Character removeCharacetr(int col, int row) {
		
		if (cell[col][row].isEmpty()) {
			System.out.println("Tried to remove a character from empty cell " + col + " " + row);
			return null; 
		} else {
			System.out.println("Removed "+ cell[col][row].getName() + " from " + col + " " + row);
			return cell[col][row].removeCharacter();
		}
		
	}

}
