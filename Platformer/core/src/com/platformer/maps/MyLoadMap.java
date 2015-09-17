package com.platformer.maps;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

//Класс для загрузки карт

public class MyLoadMap {

	// Создали переменную
	private TiledMap map;

	// Класс для рендринга
	private MyRenderer renderer;

	// Загрузка карт
	public MyLoadMap(SpriteBatch batch, String path) {
		map = new TmxMapLoader().load(path);
		renderer = new MyRenderer(map, batch);
		MyPropertiesMap.loadMapProperties(map);
	}

	// Возвращает карту
	public TiledMap getMap() {
		return map;
	}

	// Рендринг карты
	public void render() {
		renderer.render();
	}

	// Выгружает используемые объекты
	public void dispose() {
		renderer.dispose();
		map.dispose();
	}

}
