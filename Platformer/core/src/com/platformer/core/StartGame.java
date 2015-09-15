package com.platformer.core;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.platformer.screen.GameScreen;
import com.platformer.screen.MenuScreen;

public class StartGame extends Game implements ApplicationListener {

	SpriteBatch batch;
	MenuScreen menuScreen;
	GameScreen gameScreen;

	@Override
	public void create() {
		batch = new SpriteBatch();
		menuScreen = new MenuScreen();
		gameScreen = new GameScreen(batch);
		setScreen(menuScreen);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render() {
		getScreen().render(Gdx.graphics.getDeltaTime());

		if (Gdx.input.justTouched())
			if (getScreen() == gameScreen)
				setScreen(menuScreen);
			else
				setScreen(gameScreen);

	//	System.out.println("FPS: " + Gdx.graphics.getFramesPerSecond());

	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		menuScreen.dispose();
		gameScreen.dispose();
	}
}
