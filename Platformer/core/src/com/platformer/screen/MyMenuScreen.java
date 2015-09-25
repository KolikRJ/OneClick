package com.platformer.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/**
 * 
 * @author KolikRJ Класс начального экрана.
 */
public class MyMenuScreen implements Screen {

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
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
	}

}
