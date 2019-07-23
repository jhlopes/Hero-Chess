package hero.chess;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.utils.Array;

import board.Board;
import board.Direction;
import character.Archer;
import character.Character;

public class Start extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite test;
	Sprite sprite;
	Board board;
	BitmapFont font;
	List<AnimationOrder> listAnimation;
	int x = 0;
	int index = 0;

	@Override
	public void create() {
		batch = new SpriteBatch();
		listAnimation = new ArrayList<AnimationOrder>();
		board = new Board(6, 8);
		font = new BitmapFont();
		test = new Sprite(new Texture("heros/archer.png"));

		Archer archer = new Archer("Archer", false, 1, 300, 30, 30, 200, 10);

		board.insertCharacter(archer, 2, 2);
		board.insertCharacter(archer, 2, 4);
		board.insertCharacter(archer, 6, 4);
		board.removeCharacter(2, 4);
		board.removeCharacter(2, 4);
		board.insertCharacter(archer, 2, 6);
		board.insertCharacter(archer, 1, 3);
		listAnimation.add(board.moveCharacter(Direction.LEFT, 2, 6));
		listAnimation.add(board.moveCharacter(Direction.RIGHT, 2, 6));
		listAnimation.add(board.moveCharacter(Direction.TOP_LEFT, 2, 6));
		listAnimation.add(board.moveCharacter(Direction.TOP_RIGHT, 2, 6));
		listAnimation.add(board.moveCharacter(Direction.BOTTOM_LEFT, 2, 6));
		listAnimation.add(board.moveCharacter(Direction.BOTTOM_RIGHT, 2, 6));

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 255, 255, 255);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();

		renderBoard();
		if (!listAnimation.isEmpty()) {
			
			animateBoard();
		}
		batch.end();
	}

	private void animateBoard() {

		for (int i = 0; i < listAnimation.size(); i++) {
			Sprite spriteToDraw = new Sprite(listAnimation.get(i).getTexture());
			spriteToDraw.setRotation(listAnimation.get(i).getDirection().angle());
			spriteToDraw.setPosition(listAnimation.get(i).getStartingX() + listAnimation.get(i).getModX(),
					listAnimation.get(i).getStartingY() + listAnimation.get(i).getModY());
			listAnimation.get(i).increaseCount();

			spriteToDraw.draw(batch);
			if (listAnimation.get(i).isFinished()) {
				listAnimation.remove(i);
			}

		}

	}

	public void renderBoard() {

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				float offset = (j % 2 == 0) ? 0 : (sprite.getWidth() / 2);
				sprite = new Sprite(board.getSprite(i, j));
				sprite.setSize(70, 70);

				float mod = (sprite.getHeight() - sprite.getHeight() / 4);
				font.setColor(Color.BLACK);

				sprite.setPosition((i * sprite.getHeight()) + offset, (j * mod));

				sprite.draw(batch);
				font.draw(batch, i + "    " + j, ((i * sprite.getHeight()) + (offset) + 20), j * mod + 40);
			}
		}

	}

	@Override
	public void dispose() {
		batch.dispose();

	}
}