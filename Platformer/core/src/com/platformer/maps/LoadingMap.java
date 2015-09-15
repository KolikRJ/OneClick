package com.platformer.maps;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

//����� ��� �������� ����

public class LoadingMap {

	// ������� ����������
	private TiledMap map;

	// ����� ��� ���������
	private Renderer renderer;
	
	private MyPropertiesMap prop;

	// �������� ����
	public LoadingMap(SpriteBatch batch, String path) {
		map = new TmxMapLoader().load(path);
		renderer = new Renderer(map, batch);
		prop = new MyPropertiesMap(map);
	}

	// ���������� �����
	public TiledMap getMap() {
		return map;
	}

	// �������� �����
	public void render() {
		renderer.render();
	}
	
	public int getTileHeight(TiledMapTileLayer layer){
		return layer.getHeight();
	}
	
	public int getHorTile(int x){
		return x / prop.getWidthTile();
	}
	
	public int getVerTile(int y){
		return y / prop.getHeightTile();
	}
	
	public boolean getTile(TiledMapTileLayer layer, int hor, int ver){
		return layer.getCell(hor, ver) != null;
	}
	
	public Renderer getRender(){
		return renderer;
	}
	
	// ��������� ������������ �������
	public void dispose() {
		renderer.dispose();
		map.dispose();
	}

}
