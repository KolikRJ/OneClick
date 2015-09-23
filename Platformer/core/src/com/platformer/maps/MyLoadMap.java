package com.platformer.maps;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

/**
 * 
 * @author KolikRJ
 * @brief ����� ��� �������� ����.
 */
public class MyLoadMap {

	// ����� ����
	private TiledMap map;

	// ����� ��� ���������
	private MyRendererMap renderer;

	/**
	 * @param batch
	 * @param path
	 */
	public MyLoadMap(SpriteBatch batch, String path) {
		// �������� ����� �����
		map = new TmxMapLoader().load(path);
		// ������ ����� ��� ������������ ������ ������� �����
		MyPropertiesMap.LOAD_MAP_PROPERTIES(map);
		// �������� �����
		renderer = new MyRendererMap(map, batch);
	}

	/**
	 * 
	 * @return ���������� ����������� �����.
	 */
	public TiledMap getMap() {
		return map;
	}

	/**
	 * @brief �������� �����.
	 * @param delta
	 */
	public void render(float delta) {
		renderer.render(delta);
	}

	/**
	 * @brief ��������� ������������ �������.
	 */
	public void dispose() {
		map.dispose();
	}

}
