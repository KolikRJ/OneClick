package com.platformer.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.platformer.maps.MyPropertiesMap;

/**
 * 
 * @author KolikRJ
 * @brief Класс главного игрока.
 */
public class Player extends MyTextureMapObject {

	private float x;
	private float y;
	private float dx;
	private float dy;

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

	private int horTile;
	private int verTile;

	private int tileId;

	public Player() {

		moveSpeed = 4.8f;
		maxSpeed = 8.8f;
		stopSpeed = 25.8f;
		maxFallSpeed = -8.2f;
		jumpSpeed = 5f;

		gravity = 20;

		x = getX();
		y = getY();

	}

	@Override
	public void render(float delta) {
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

		if (dx > 0 && !right) {
			dx -= stopSpeed * delta;
			if (dx < 0)
				dx = 0;
		} else if (dx < 0 && !left) {
			dx += stopSpeed * delta;
			if (dx > 0) {
				dx = 0;
			}
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

		float tox = x + dx;
		float toy = y + dy;

		float tempx = x;
		float tempy = y;

		calculateCorners(x, toy);

		if (dy > 0) {
			if (topLeft || topRight) {
				dy = 0;
				tempy = (verTile) * MyPropertiesMap.GET_HEIGHT_TILE() - (getHeight() / 2) - 0.1f;
			} else
				tempy += dy;
		}

		if (dy < 0) {
			if (bottomLeft || bottomRight) {
				dy = 0;
				falling = false;
				tempy = (verTile) * MyPropertiesMap.GET_HEIGHT_TILE() + MyPropertiesMap.GET_HEIGHT_TILE() + getHeight() / 2;
			} else
				tempy += dy;
		}

		calculateCorners(tox, y);

		if (dx < 0) {
			if (topLeft || bottomLeft) {
				dx = 0;
				tempx = (horTile) * MyPropertiesMap.GET_WIDTH_TILE() + MyPropertiesMap.GET_WIDTH_TILE() + getWidth() / 2;
			} else
				tempx += dx;
		}

		if (dx > 0) {
			if (topRight || bottomRight) {
				dx = 0;
				tempx = (horTile) * MyPropertiesMap.GET_WIDTH_TILE() - (getWidth() / 2) - 0.1f;
			} else
				tempx += dx;
		}

		calculateCorners(x, y - 1);

		if (!falling)
			if (!bottomLeft && !bottomRight)
				falling = true;

		if (tileId == 35 || tileId == 34 || tileId == 36) {
			stopSpeed = 2f;
			maxSpeed = 12.2f;
		} else {
			stopSpeed = 25.8f;
			maxSpeed = 8.8f;
		}

		x = tempx;
		y = tempy;

		setX(x);
		setY(y);
	}

	public void calculateCorners(float x, float y) {
		topLeft = MyPropertiesMap.GET_TILE(MyPropertiesMap.GET_HOR_TILE(x - getWidth() / 2), MyPropertiesMap.GET_VER_TILE(y + getHeight() / 2)) != null;
		topRight = MyPropertiesMap.GET_TILE(MyPropertiesMap.GET_HOR_TILE(x + getWidth() / 2), MyPropertiesMap.GET_VER_TILE(y + getHeight() / 2)) != null;
		bottomLeft = MyPropertiesMap.GET_TILE(MyPropertiesMap.GET_HOR_TILE(x - getWidth() / 2), MyPropertiesMap.GET_VER_TILE(y - getHeight() / 2)) != null;
		bottomRight = MyPropertiesMap.GET_TILE(MyPropertiesMap.GET_HOR_TILE(x + getWidth() / 2), MyPropertiesMap.GET_VER_TILE(y - getHeight() / 2)) != null;

		if (bottomLeft && bottomRight) {
			tileId = MyPropertiesMap.GET_TILE(MyPropertiesMap.GET_HOR_TILE(x), MyPropertiesMap.GET_VER_TILE(y - getHeight() / 2)).getTile().getId();
		}

		if (topLeft || bottomLeft)
			horTile = MyPropertiesMap.GET_HOR_TILE(x - getWidth() / 2);

		if (topRight || bottomRight)
			horTile = MyPropertiesMap.GET_HOR_TILE(x + getWidth() / 2);

		if (topLeft || topRight)
			verTile = MyPropertiesMap.GET_VER_TILE(y + getHeight() / 2);

		if (bottomLeft || bottomRight)
			verTile = MyPropertiesMap.GET_VER_TILE(y - getHeight() / 2);
	}
}
