package com.platformer.maps;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class MyPropertiesMap {

	// Класс свойств карты

	private static MapProperties PROP;

	// Загрузка карты
	public static void loadMapProperties(TiledMap map){
		PROP = map.getProperties();
	}

	// Ширина карты в тайлах
	public static int getWidthMapTiles() {
		return PROP.get("width", Integer.class);
	}

	// Высота карты в тайлах
	public static int getHeightMapTiles() {
		return PROP.get("height", Integer.class);
	}

	// Ширина карты
	public static int getWidthMap() {
		return PROP.get("width", Integer.class) * PROP.get("tilewidth", Integer.class);
	}

	// Высота карты
	public static int getHeightMap() {
		return PROP.get("height", Integer.class) * PROP.get("tileheight", Integer.class);
	}

	// Ширина тайла
	public static int getWidthTile() {
		return PROP.get("tilewidth", Integer.class);
	}

	// Высота тайла
	public static int getHeightTile() {
		return PROP.get("tileheight", Integer.class);
	}

}
