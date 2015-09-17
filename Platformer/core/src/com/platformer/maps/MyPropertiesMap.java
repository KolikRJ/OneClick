package com.platformer.maps;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class MyPropertiesMap {

	// ����� ������� �����

	private static MapProperties PROP;

	// �������� �����
	public static void loadMapProperties(TiledMap map){
		PROP = map.getProperties();
	}

	// ������ ����� � ������
	public static int getWidthMapTiles() {
		return PROP.get("width", Integer.class);
	}

	// ������ ����� � ������
	public static int getHeightMapTiles() {
		return PROP.get("height", Integer.class);
	}

	// ������ �����
	public static int getWidthMap() {
		return PROP.get("width", Integer.class) * PROP.get("tilewidth", Integer.class);
	}

	// ������ �����
	public static int getHeightMap() {
		return PROP.get("height", Integer.class) * PROP.get("tileheight", Integer.class);
	}

	// ������ �����
	public static int getWidthTile() {
		return PROP.get("tilewidth", Integer.class);
	}

	// ������ �����
	public static int getHeightTile() {
		return PROP.get("tileheight", Integer.class);
	}

}
