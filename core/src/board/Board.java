package board;

import com.badlogic.gdx.graphics.Texture;

import character.Archer;
import character.Character;
import hero.chess.AnimationOrder;

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

		if (checkOutOfBounds(col, row)) {
			return false;
		}

		if (cell[col][row].isEmpty()) {
			cell[col][row].insertCharacter(character);
			try {
				System.out.println(character.getName() + " inserted in " + col + " " + row);
			} catch (Exception e) {

			}
			return true;
		} else {

			System.out.println(col + " " + row + " is already occupied by " + character.getName());

			return false;
		}

	}

	public Character removeCharacter(int col, int row) {

		if (checkOutOfBounds(col, row)) {
			return null;
		}

		if (cell[col][row].isEmpty()) {
			System.out.println("Tried to remove a character from empty cell " + col + " " + row);
			return null;
		} else {
			System.out.println("Removed " + cell[col][row].getName() + " from " + col + " " + row);
			return cell[col][row].removeCharacter();
		}

	}

	public boolean characterCanMove(Direction dir, int col, int row) {
		int[] targetColRow = getColAndRowOfDirection(dir, col, row);

		if (checkOutOfBounds(col, row) || checkOutOfBounds(targetColRow[0], targetColRow[1])) {
			return false;
		}

		if (cell[col][row].isEmpty() || !cell[targetColRow[0]][targetColRow[1]].isEmpty()) {
			System.out.println("Tried to move empty cell or move to filled cell;");
			return false;
		} else {
			return true;
		}

	}

	private boolean checkOutOfBounds(int col, int row) {
		if ((col < 0 || col >= rows) || (row < 0 || row >= cols)) {
			System.out.println("out of bounds");
			return true;
		} else {
			return false;
		}

	}

	public int[] getColAndRowOfDirection(Direction dir, int col, int row) {
		int[] col0row1 = new int[2];
		// topleft col = col / row = row + 1;
		// topright col = col / row = row + 1;
		// left col = col - 1 / row = row;
		// right col = col + 1 / row = row;
		// botleft col = col / row = row - 1;
		// botright col = col - 1 / row = row + 1;
		switch (dir) {
		case TOP_LEFT:
			col0row1[0] = col - 1;
			col0row1[1] = row + 1;
			return col0row1;
		case TOP_RIGHT:
			col0row1[0] = col;
			col0row1[1] = row + 1;
			return col0row1;
		case LEFT:
			col0row1[0] = col - 1;
			col0row1[1] = row;
			return col0row1;
		case RIGHT:
			col0row1[0] = col + 1;
			col0row1[1] = row;
			return col0row1;
		case BOTTOM_LEFT:
			col0row1[0] = col - 1;
			col0row1[1] = row - 1;
			return col0row1;
		case BOTTOM_RIGHT:
			col0row1[0] = col;
			col0row1[1] = row - 1;
			return col0row1;
		default:
			return col0row1;
		}

	}

	public AnimationOrder moveCharacter(Direction dir, int oCol, int oRow) {
		int[] col0row1 = getColAndRowOfDirection(dir, oCol, oRow);
		
		cell[col0row1[0]][col0row1[1]].setIsGonnaBeOccupied();

		return new AnimationOrder(dir, cell[oCol][oRow].getSpriteOfCell(), oCol, oRow, col0row1[0], col0row1[1]);
	}

}
