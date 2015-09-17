package com.platformer.maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.platformer.objects.MyRenderObjects;

public class MyRenderer {

	// Создание класса для рендринга карты
	private TiledMapRenderer mapRenderer;
	
	private MyRenderObjects renderObjects;
	// Переменная карты
	private TiledMap map;
	// Отрисовщик спрайтов
	private SpriteBatch batch;
	// Создание камеры
	private MyCamera camera;

	// Загрузка карты для рендринга
	public MyRenderer(TiledMap map, SpriteBatch batch) {
		this.map = map;
		this.batch = batch;
		mapRenderer = new OrthogonalTiledMapRenderer(map, batch);
		camera = new MyCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		renderObjects = new MyRenderObjects(map, batch);
	}

	// Рендринг карты
	public void render() {
		batch.setProjectionMatrix(camera.combined);
		camera.update();
		mapRenderer.setView(camera);
		mapRenderer.render();
		renderObjects.render();
	}

	

	// Выгружает используемые объекты
	public void dispose() {
		batch.dispose();
	}

	public TextureMapObject getPlayer() {
		return (TextureMapObject) map.getLayers().get("Player").getObjects().get("Player");
	}

	public TiledMapTileLayer getLayer(String str) {
		return (TiledMapTileLayer) map.getLayers().get(str);
	}

	public MyCamera getCamera() {
		return camera;
	}

}
