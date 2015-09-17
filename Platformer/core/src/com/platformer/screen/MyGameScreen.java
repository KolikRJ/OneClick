package com.platformer.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.platformer.maps.MyLoadMap;

public class MyGameScreen implements Screen {

	// Класс экрана игры

	// Загрузка карты
	private MyLoadMap map;

	// Конструктор класса
	public MyGameScreen(SpriteBatch batch) {
		map = new MyLoadMap(batch, "level1.tmx");
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
	}

}
