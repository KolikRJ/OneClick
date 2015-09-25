package com.platformer.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.platformer.maps.MyLoadMap;

/**
 * 
 * @author KolikRJ Класс экрана игры.
 */
public class MyGameScreen implements Screen {

	// Загрузка карты
	private MyLoadMap map;

	/**
	 * 
	 * @param batch
	 *            Загрузка карты.
	 */
	public MyGameScreen(SpriteBatch batch) {
		map = new MyLoadMap(batch, "level1.tmx");
	}

	/**
	 * Вызывается каждый раз при вызове данного экрана.
	 */
	@Override
	public void show() {
	}

	/**
	 * Рендер экрана.
	 */
	@Override
	public void render(float delta) {
		Gdx.gl.glBlendColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		map.render(delta);
	}

	/**
	 * Вызывается при расстягивании экрана.
	 */
	@Override
	public void resize(int width, int height) {
	}

	/**
	 * Используется когда вызывается метод pause() в {@link}ApplicationListener
	 */
	@Override
	public void pause() {
	}

	/**
	 * Используется когда вызывается метод resume() в {@link}ApplicationListener
	 */
	@Override
	public void resume() {
	}

	/**
	 * Используется когда данный экран не активен
	 */
	@Override
	public void hide() {
	}

	/**
	 * Выгружает используемые объекты
	 */
	@Override
	public void dispose() {
		map.dispose();
	}

}
