package com.platformer.debug;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.platformer.maps.MyCamera;
import com.platformer.maps.MyLoadMap;
import com.platformer.objects.Player;

public class Debug {
//
//	private ShapeRenderer sr;
//
//	private MyLoadMap map;
//	private Player player;
//
//	private int mapWidth;
//	private int mapHeight;
//	private int tileWidth;
//	private int tileHeight;
//
//	private boolean debug;
//
//	public Debug(MyLoadMap map, Player player, MyCamera camera) {
//		sr = new ShapeRenderer();
//		this.map = map;
//		this.player = player;
//		sr.setProjectionMatrix(camera.combined);
//
//		mapWidth = map.getWidthMap();
//		mapHeight = map.getHeightMap();
//		tileWidth = map.getTileWidth("Ground");
//		tileHeight = map.getTileHeight("Ground");
//	}
//
//	public void render() {
//		if (debug) {
//			sr.begin(ShapeType.Line);
//			sr.setColor(Color.GREEN);
//			for (int hor = 0; hor < mapWidth; hor += tileWidth)
//				for (int ver = 0; ver < mapHeight; ver += tileHeight)
//					if (map.getTile("Ground", hor / tileWidth, ver / tileHeight))
//						sr.rect(hor, ver, tileWidth, tileHeight);
//			
//			sr.setColor(Color.RED);
//			sr.rect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
//			sr.end();
//		}
//	}
//
//	public void dispose() {
//		sr.dispose();
//	}
//
//	public boolean isDebug() {
//		return debug;
//	}
//
//	public void setDebug(boolean debug) {
//		this.debug = debug;
//	}

}
