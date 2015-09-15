package com.platformer.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.platformer.maps.LoadingMap;
import com.platformer.maps.MyPropertiesObject;

public class Player {

	private TextureMapObject player;
	private MyPropertiesObject propObject;

	private SpriteBatch batch;

	private TiledMapTileLayer layer;

	private LoadingMap map;

	private float x;
	private float y;
	private float dx;
	private float dy;

	private float width;
	private float height;

	private float moveSpeed;
	private float maxSpeed;
	private float stopSpeed;
	private float jumpSpeed;
	private float maxFallSpeed;

	private float gravity;

	private boolean topLeft;
	private boolean topRight;
	private boolean bottomLeft;
	private boolean bottomRight;

	private boolean left;
	private boolean right;
	private boolean jumping;
	private boolean falling;

	public Player(LoadingMap map, SpriteBatch batch) {

		this.batch = batch;
		this.map = map;
		this.player = map.getRender().getPlayer();

		propObject = new MyPropertiesObject(player);

		width = propObject.getWidthObject();
		height = propObject.getHeightObject();

		moveSpeed = 4.8f;
		maxSpeed = 8.8f;
		stopSpeed = 25.8f;
		maxFallSpeed = -8.2f;
		jumpSpeed = 5f;

		gravity = 10;

		player.setY(player.getY() + height);
		
		x = player.getX() + width / 2;
		y = player.getY() + height / 2;
		
		player.setX(x);
		player.setY(y);

	}

	public void render(float delta) {
		renderObject(player);
		key();
		move(delta);
	}

	private void key() {
		if (Gdx.input.isKeyPressed(Keys.LEFT))
			left = true;
		else
			left = false;

		if (Gdx.input.isKeyPressed(Keys.RIGHT))
			right = true;
		else
			right = false;

		if (Gdx.input.isKeyJustPressed(Keys.UP) && !falling)
			jumping = true;

	}

	private void move(float delta) {

		if (left) {
			dx -= moveSpeed * delta;
			if (dx < -maxSpeed)
				dx = -maxSpeed;
		} else if (right) {
			dx += moveSpeed * delta;
			if (dx > maxSpeed)
				dx = maxSpeed;
		}
		
		

		if (jumping) {
			dy = jumpSpeed;
			falling = true;
			jumping = false;
		}

		if (falling) {
			dy -= gravity * delta;
			if (dy < maxFallSpeed)
				dy = maxFallSpeed;
		} else {
			dy = 0;
		}

		player.setX(x += dx);
		player.setY(y += dy);

	}

	private void renderObject(TextureMapObject object) {

		TextureRegion region = object.getTextureRegion();
		float scaleX = object.getScaleX();
		float scaleY = object.getScaleY();
		float originX = object.getOriginX();
		float originY = object.getOriginY();
		float rotation = object.getRotation();

		batch.begin();
		batch.draw(region, x - width / 2, y - height / 2, originX, originY, width, height, scaleX, scaleY, -rotation);
		batch.end();
	}

	private void isFree(float x, float y) {

		int leftTile = map.getHorTile((int) (x - width / 2));
		int rightTile = map.getHorTile((int) (x + width / 2));
		int topTile = map.getVerTile((int) (y + height / 2));
		int bottonTile = map.getVerTile((int) (y - height / 2));

		topLeft = map.getTile(layer, topTile, leftTile);
		topRight = map.getTile(layer, topTile, rightTile);
		bottomLeft = map.getTile(layer, bottonTile, leftTile);
		topLeft = map.getTile(layer, bottonTile, rightTile);

	}
}
