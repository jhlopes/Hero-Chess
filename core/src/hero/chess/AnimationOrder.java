package hero.chess;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

import board.Direction;

public class AnimationOrder {

	private Direction direction;
	private Texture texture;
	private int originalCol;
	private int originalRow;
	private int targetCol;
	private int targetRow;
	private static final int MAX_FRAMES = 60;
	private int counter;
	private int xIndex;
	private int yIndex;
	private static final double DIAGONAL_SPEED = 2;
	private static final double STRAIGHT_SPEED = 1;

	public AnimationOrder(Direction dir, Texture spriteOfCell, int oCol, int oRow, int tCol, int tRow) {
		this.direction = dir;
		this.texture = spriteOfCell;
		this.originalCol = oCol;
		this.originalRow = oRow;
		this.targetRow = tRow;
		this.targetCol = tCol;
		
		this.xIndex = 0;
		this.yIndex = 0;
		this.counter = 0;
	}


	public boolean isFinished() {
		if (this.counter > MAX_FRAMES) {
			return true;
		} else {
			return false;
		}
		
	}

	public Direction getDirection() {
		return this.direction;
	}

	public Texture getTexture() {
		return this.texture;
	}

	public int getOriginalCol() {
		return this.originalCol;
	}

	public int getOriginalRow() {
		return this.originalRow;
	}

	public float getStartingX() {
		
		float offset = (this.originalRow % 2 == 0) ? 0 : (this.texture.getWidth() / 2);

		return (this.originalCol * this.texture.getHeight()) + offset + 20;
	}

	public float getModX() {

		switch (this.direction) {
		case TOP_LEFT:
			return (float) ((-DIAGONAL_SPEED * 7) +( xIndex-- * .5 ));
		case TOP_RIGHT:
			return (float) (DIAGONAL_SPEED * -5 + (xIndex++ * .6) );
		case LEFT:
			return (float) ((-STRAIGHT_SPEED) + (xIndex-- * 1.5));
		case RIGHT:
			return (float) (STRAIGHT_SPEED + (xIndex++ * 1.3));
		case BOTTOM_LEFT:
			return (float) ((-DIAGONAL_SPEED) + xIndex--);
		case BOTTOM_RIGHT:
			return (float) (DIAGONAL_SPEED + (xIndex++ * 0.6));
		default:
			return 0;
		}

	}

//  float offset = (j % 2 == 0) ? 0 : (sprite.getWidth() / 2);
//	float mod = (sprite.getHeight() - sprite.getHeight() / 4);
//	font.setColor(Color.BLACK);
//
//	sprite.setPosition((i * sprite.getHeight()) + offset, (j * mod));
//
//	sprite.draw(batch);
//	font.draw(batch, i + "    " + j, ((i * sprite.getHeight()) + (offset) + 20), j * mod + 40);

	
	public float getStartingY() {
		float mod = (this.texture.getHeight() - this.texture.getHeight() / 4);
		
		return (this.originalRow * mod) ;
	}

	public float getModY() {
		switch (this.direction) {
		case TOP_LEFT:
		case TOP_RIGHT:
			return (float) (DIAGONAL_SPEED + yIndex++);
		case LEFT:
			return 10;
		case RIGHT:
			return 0;
		case BOTTOM_LEFT:
		case BOTTOM_RIGHT:
			return (float) -(DIAGONAL_SPEED + yIndex++);
		default:
			return 0;
		}
	}

	public void increaseCount() {
		this.counter++;
		
	}

}
