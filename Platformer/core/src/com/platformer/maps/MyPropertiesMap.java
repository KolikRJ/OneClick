package com.platformer.maps;

import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;

/**
 * 
 * @author KolikRJ ����� ������� ����������� �����.
 */
public class MyPropertiesMap {

	private static TiledMap MAP;
	private static MapProperties PROP;

	/**
	 * 
	 * @param map
	 *            �������� �����.
	 */
	public static void LOAD_MAP_PROPERTIES(TiledMap map) {
		MAP = map;
		PROP = MAP.getProperties();
	}

	/**
	 * 
	 * @return ��������� ����������� �����.
	 */
	public static TiledMap GET_MAP() {
		return MAP;
	}

	/**
	 * 
	 * @return ���������� ������ ��������.
	 */
	public static MapObjects GET_OBJECTS() {
		return MAP.getLayers().get("Object").getObjects();
	}

	/**
	 * 
	 * @return ��������� ���� �����.
	 */
	public static MapLayers GET_LAYERS() {
		return MAP.getLayers();
	}

	/**
	 * 
	 * @param hor
	 * @param ver
	 * @return ��������� ���� �� �����������. ����� ��������� null.
	 */
	public static Cell GET_TILE(int hor, int ver) {
		TiledMapTileLayer layer = (TiledMapTileLayer) MAP.getLayers().get("Ground");
		return layer.getCell(hor, ver);
	}

	/**
	 * 
	 * @param x
	 * @return ��������� ����� ����� �� �����������.
	 */
	public static int GET_HOR_TILE(float x) {
		return (int) (x / GET_WIDTH_TILE());

	}

	/**
	 * 
	 * @param y
	 * @return ��������� ����� ����� �� ���������.
	 */
	public static int GET_VER_TILE(float y) {
		return (int) (y / GET_HEIGHT_TILE());

	}

	/**
	 * 
	 * @return ��������� ������ ����� � ������.
	 */
	public static int GET_WIDTH_MAP_TILES() {
		return PROP.get("width", Integer.class);
	}

	/**
	 * 
	 * @return ��������� ������ ����� � ������.
	 */
	public static int GET_HEIGHT_MAP_TILES() {
		return PROP.get("height", Integer.class);
	}

	/**
	 * 
	 * @return ��������� ������ ����� � ��������.
	 */
	public static int GET_WIDTH_MAP_PIXELS() {
		return PROP.get("width", Integer.class) * PROP.get("tilewidth", Integer.class);
	}

	/**
	 * 
	 * @return ��������� ������ ����� � ��������.
	 */
	public static int GET_HEIGHT_MAP_PIXELS() {
		return PROP.get("height", Integer.class) * PROP.get("tileheight", Integer.class);
	}

	/**
	 * 
	 * @return ��������� ������ �����.
	 */
	public static int GET_WIDTH_TILE() {
		return PROP.get("tilewidth", Integer.class);
	}

	/**
	 * 
	 * @return ��������� ������ �����.
	 */
	public static int GET_HEIGHT_TILE() {
		return PROP.get("tileheight", Integer.class);
	}

}
