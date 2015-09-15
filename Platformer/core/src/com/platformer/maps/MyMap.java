package com.platformer.maps;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

//����� ��� �������� ����

public class MyMap {

	// ������� ����������
	private TiledMap map;

	// ����� ��� ���������
	private Renderer renderer;
	
	private MyPropertiesMap prop;
	
	// �������� ����
	public MyMap(SpriteBatch batch, String path) {
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
	
	public int getTileHeight(String index){
		return (int) ((TiledMapTileLayer) map.getLayers().get(index)).getTileHeight();
	}
	
	public int getTileWidth(String index){
		return (int) ((TiledMapTileLayer) map.getLayers().get(index)).getTileWidth();
	}
	
	public int getHorTile(int x){
		return x / prop.getWidthTile();
	}
	
	public int getVerTile(int y){
		return y / prop.getHeightTile();
	}
	
	public boolean getTile(int index, int x, int y){
		return ((TiledMapTileLayer) map.getLayers().get(index)).getCell(x, y) != null;
	}
	
	public int getWidthMap(){
		return prop.getWidthMap();
	}
	
	public int getHeightMap(){
		return prop.getHeightMap();
	}
	
	public Renderer getRender(){
		return renderer;
	}
	
	public MyCamera getCamera(){
		return renderer.getCamera();
	}
	
	// ��������� ������������ �������
	public void dispose() {
		renderer.dispose();
		map.dispose();
	}

}
