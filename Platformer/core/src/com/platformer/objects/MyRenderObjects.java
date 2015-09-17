package com.platformer.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class MyRenderObjects {

	private TiledMap map;
	private SpriteBatch batch;

	public MyRenderObjects(TiledMap map, SpriteBatch batch) {
		this.map = map;
		this.batch = batch;
	}

	public void render() {
		for (MapLayer layer : map.getLayers())
			renderObjects(layer);
	}

	// Метод для отрисовки объектов
	private void renderObjects(MapLayer layer) {
		batch.begin();
		for (MapObject object : layer.getObjects()) {
			TextureMapObject textureObject = (MyTextureObject) object;
			renderObject(textureObject);
		}
		batch.end();
	}

	// Метод для отрисовки объектов
	private void renderObject(MyTextureObject object) {

		TextureRegion region = object.getTextureRegion();
		float width = 16;
		float height = 16;
		float x = object.getX();
		float y = object.getY();
		float scaleX = object.getScaleX();
		float scaleY = object.getScaleY();
		float originX = object.getOriginX();
		float originY = object.getOriginY();
		float rotation = object.getRotation();

		batch.draw(region, x, y, originX, originY, width, height, scaleX, scaleY, -rotation);
	}

}
