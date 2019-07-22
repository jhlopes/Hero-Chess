package hero.chess;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import board.Board;
import character.Archer;

public class Start extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite sprite;
	Board board;

	@Override
	public void create() {
		batch = new SpriteBatch();

		board = new Board(6, 8);

		Archer archer = new Archer("Archer", false, 1, 300, 30, 30, 200, 10);
		board.insertCharacter(archer, 2, 2);
		board.insertCharacter(archer, 2, 4);
		board.insertCharacter(archer, 2, 4);
		board.removeCharacetr(2,4);
		board.removeCharacetr(2,4);
		
		
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 255, 255, 255);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		renderBoard();

		batch.end();
	}

	public void renderBoard() {

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				float offset = (j % 2 == 0) ? 0 : (sprite.getWidth() / 2);
				sprite = new Sprite(board.getSprite(i, j));
				sprite.setSize(70, 70);
				sprite.setPosition((i * sprite.getHeight()) + offset,
						(j * ((sprite.getWidth() / 2) + sprite.getWidth() / 4)));
				sprite.draw(batch);
			}
		}
	}

	@Override
	public void dispose() {
		batch.dispose();

	}
}
