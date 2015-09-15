package com.platformer.maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Renderer {

	// Создание класса для рендринга карты
	private TiledMapRenderer mapRenderer;
	// Переменная карты
	private TiledMap map;
	// Отрисовщик спрайтов
	private SpriteBatch batch;
	// Создание камеры
	private MyCamera camera;

	// Загрузка карты для рендринга
	public Renderer(TiledMap map, SpriteBatch batch) {
		this.map = map;
		this.batch = batch;
		mapRenderer = new OrthogonalTiledMapRenderer(map, batch);
		camera = new MyCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	// Рендринг карты
	public void render() {
		batch.setProjectionMatrix(camera.combined);
		camera.update();
		mapRenderer.setView(camera);
		mapRenderer.render();
		renderObjects(map.getLayers().get("Objects"));
	}

	// Метод для отрисовки объектов
	private void renderObjects(MapLayer layer) {
		batch.begin();
		for (MapObject object : layer.getObjects()) {
			TextureMapObject textureObject = (TextureMapObject) object;
			renderObject(textureObject);
		}
		batch.end();
	}

	// Метод для отрисовки объектов
	private void renderObject(TextureMapObject object) {
		MyPropertiesObject prop = new MyPropertiesObject(object);

		TextureRegion region = object.getTextureRegion();
		float width = prop.getWidthObject();
		float height = prop.getHeightObject();
		float x = object.getX();
		float y = object.getY();
		float scaleX = object.getScaleX();
		float scaleY = object.getScaleY();
		float originX = object.getOriginX();
		float originY = object.getOriginY();
		float rotation = object.getRotation();

		batch.draw(region, x, y, originX, originY, width, height, scaleX, scaleY, -rotation);
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

}
