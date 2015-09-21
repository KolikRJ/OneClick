package com.platformer.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.TextureMapObject;

public class MyRenderObjects {

	private SpriteBatch batch;
	private MyMapObjects objects;

	public MyRenderObjects(SpriteBatch batch, MapObjects mapObjects) {
		this.batch = batch;
		objects = new MyMapObjects();
		objects.add(new Player((TextureMapObject) mapObjects.get("Player")));
	}

	public void render(float delta) {
		batch.begin();
		for (MyTextureMapObject object : objects)
			object.renderObject(batch);
		
		}
		batch.end();
	}

}
