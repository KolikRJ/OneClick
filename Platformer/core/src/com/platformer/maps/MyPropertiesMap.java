package com.platformer.maps;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class MyPropertiesMap {

	// Класс свойств карты

	private MapProperties prop;

	// Загрузка карты
	public MyPropertiesMap(TiledMap map) {
		prop = map.getProperties();
	}

	// Ширина карты в пикселях
	public int getWidthMap() {
		return prop.get("width", Integer.class);
	}

	// Высота карты в пикселях
	public int getHeightMap() {
		return prop.get("height", Integer.class);
	}

	// Количество тайлов по горизонтали
	public int getWidthMapPixels() {
		return prop.get("width", Integer.class) * prop.get("tilewidth", Integer.class);
	}

	// Количество тайлов по вертикали
	public int getHeightMapPixels() {
		return prop.get("height", Integer.class) * prop.get("tileheight", Integer.class);
	}

	// Ширина тайла
	public int getWidthTile() {
		return prop.get("tilewidth", Integer.class);
	}

	// Высота тайла
	public int getHeightTile() {
		return prop.get("tileheight", Integer.class);
	}

}
