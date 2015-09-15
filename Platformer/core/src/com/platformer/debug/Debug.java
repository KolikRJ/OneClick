package com.platformer.debug;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.platformer.maps.MyCamera;
import com.platformer.maps.MyMap;

public class Debug {

	private ShapeRenderer sr;

	private int mapWidth;
	private int mapHeight;
	private int tileWidth;
	private int tileHeight;

	private boolean debug;

	public Debug(MyMap map, MyCamera camera) {
		sr = new ShapeRenderer();
		sr.setProjectionMatrix(camera.combined);
		sr.setColor(Color.GREEN);

		mapWidth = map.getWidthMap();
		mapHeight = map.getHeightMap();
		tileWidth = map.getTileWidth("Ground");
		tileHeight = map.getTileHeight("Ground");
	}

	public void render() {
		if (debug) {
			sr.begin(ShapeType.Line);

			for (int hor = 0; hor < mapWidth; hor += tileWidth)
				for (int ver = 0; ver < mapHeight; ver += tileHeight)
					sr.rect(hor, ver, tileWidth, tileHeight);

			sr.end();
		}
	}

	public void dispose() {
		sr.dispose();
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}
	
}
