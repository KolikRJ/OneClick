package com.platformer.maps;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class MyPropertiesMap {

	// ����� ������� �����

	private MapProperties prop;

	// �������� �����
	public MyPropertiesMap(TiledMap map) {
		prop = map.getProperties();
	}

	// ������ ����� � ������
	public int getWidthMapTiles() {
		return prop.get("width", Integer.class);
	}

	// ������ ����� � ������
	public int getHeightMapTiles() {
		return prop.get("height", Integer.class);
	}

	// ������ �����
	public int getWidthMap() {
		return prop.get("width", Integer.class) * prop.get("tilewidth", Integer.class);
	}

	// ������ �����
	public int getHeightMap() {
		return prop.get("height", Integer.class) * prop.get("tileheight", Integer.class);
	}

	// ������ �����
	public int getWidthTile() {
		return prop.get("tilewidth", Integer.class);
	}

	// ������ �����
	public int getHeightTile() {
		return prop.get("tileheight", Integer.class);
	}

}
