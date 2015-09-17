package com.platformer.maps;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

//����� ��� �������� ����

public class MyLoadMap {

	// ������� ����������
	private TiledMap map;

	// ����� ��� ���������
	private MyRenderer renderer;

	// �������� ����
	public MyLoadMap(SpriteBatch batch, String path) {
		map = new TmxMapLoader().load(path);
		renderer = new MyRenderer(map, batch);
		MyPropertiesMap.loadMapProperties(map);
	}

	// ���������� �����
	public TiledMap getMap() {
		return map;
	}

	// �������� �����
	public void render() {
		renderer.render();
	}

	// ��������� ������������ �������
	public void dispose() {
		renderer.dispose();
		map.dispose();
	}

}
