package com.platformer.maps;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

/**
 * 
 * @author KolikRJ
 * @brief Класс для загрузки карт.
 */
public class MyLoadMap {

	// Класс карт
	private TiledMap map;

	// Класс для рендринга
	private MyRendererMap renderer;

	/**
	 * @param batch
	 * @param path
	 */
	public MyLoadMap(SpriteBatch batch, String path) {
		// Загрузка файла карты
		map = new TmxMapLoader().load(path);
		// Задали карту для статического класса свойств карты
		MyPropertiesMap.LOAD_MAP_PROPERTIES(map);
		// Рендринг карты
		renderer = new MyRendererMap(map, batch);
	}

	/**
	 * 
	 * @return Возвращает загруженную карту.
	 */
	public TiledMap getMap() {
		return map;
	}

	/**
	 * @brief Рендринг карты.
	 * @param delta
	 */
	public void render(float delta) {
		renderer.render(delta);
	}

	/**
	 * @brief Выгружает используемые объекты.
	 */
	public void dispose() {
		map.dispose();
	}

}
