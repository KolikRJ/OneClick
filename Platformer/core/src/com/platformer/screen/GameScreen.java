package com.platformer.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.platformer.debug.Debug;
import com.platformer.maps.MyMap;
import com.platformer.objects.Player;

public class GameScreen implements Screen {

	// Класс экрана игры

	// Загрузка карты
	private MyMap map;

	private Player player;

	private Debug debug;

	private byte tab = 0;

	// Конструктор класса
	public GameScreen(SpriteBatch batch) {
		map = new MyMap(batch, "level1.tmx");

		debug = new Debug(map, map.getCamera());

		player = new Player(map, batch);

	}

	// Используется когда вызывается данный экран
	@Override
	public void show() {
	}

	// Рендринг
	@Override
	public void render(float delta) {
		Gdx.gl.glBlendColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		map.render();
		keyPressed();
		if (debug.isDebug())
			debug.render();
		
		player.render(delta);
	}

	private void keyPressed() {
		if (Gdx.input.isKeyJustPressed(Keys.TAB)) {
			if (tab >= 1)
				tab = 0;
			else
				tab++;
		}
		if (tab == 1) {
			debug.setDebug(true);
			player.setDebug(true);
		} else {
			debug.setDebug(false);
			player.setDebug(false);
		}

	}

	// Вызывается при растягивании экрана
	@Override
	public void resize(int width, int height) {
	}

	// Используется когда вызывается метод pause() в ApplicationListener
	@Override
	public void pause() {
	}

	// Используется когда вызывается метод resume() в ApplicationListener
	@Override
	public void resume() {
	}

	// Используется когда данный экран не активен
	@Override
	public void hide() {
	}

	// Выгружает используемые объекты
	@Override
	public void dispose() {
		map.dispose();
		debug.dispose();
	}

}
