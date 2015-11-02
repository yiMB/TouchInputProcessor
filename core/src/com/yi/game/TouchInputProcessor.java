package com.yi.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * move a image that store in a Sprite by touch and drag on the screen,
 * A standalone Player class contain image, x y coordinate, touch listener, and take care all change.
 */
public class TouchInputProcessor extends ApplicationAdapter {
	SpriteBatch batch;

	Player player;

	float screenWidth, screenHeight, textureWidth, textureHeight;

	@Override
	public void create () {
		batch = new SpriteBatch();

		player = new Player();

		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();
		textureWidth = player.texture.getWidth();
		textureHeight = player.texture.getHeight();

		Gdx.app.log("MyTag", "screenWidth = " + screenWidth);
		Gdx.app.log("MyTag", "screenHeight = " + screenHeight);
		Gdx.app.log("MyTag", "textureWidth = " + textureWidth);
		Gdx.app.log("MyTag", "textureHeight = " + textureHeight);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
//		batch.draw(player.texture, player.vector2.x, player.vector2.y);
		player.sprite.draw(batch);
		batch.end();
	}
}
