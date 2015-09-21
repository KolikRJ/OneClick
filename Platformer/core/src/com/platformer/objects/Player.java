package com.platformer.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.platformer.maps.MyPropertiesMap;

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

	public Player(TextureMapObject object) {
		super(object);

		moveSpeed = 4.8f;
		maxSpeed = 8.8f;
		stopSpeed = 25.8f;
		maxFallSpeed = -8.2f;
		jumpSpeed = 5.3f;

		gravity = 10;

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

		int tileHor = MyPropertiesMap.GET_HOR_TILE(x);
		int tileVer = MyPropertiesMap.GET_VER_TILE(y);

		float tempx = x;
		float tempy = y;

		topLeft = isFree(MyPropertiesMap.GET_HOR_TILE(x - getWidth() / 2), MyPropertiesMap.GET_VER_TILE((y + dy) + getWidth() / 2));
		topRight = isFree(MyPropertiesMap.GET_HOR_TILE(x + getWidth() / 2), MyPropertiesMap.GET_VER_TILE((y + dy) + getWidth() / 2));
		bottomLeft = isFree(MyPropertiesMap.GET_HOR_TILE(x - getWidth() / 2), MyPropertiesMap.GET_VER_TILE((y + dy) - getWidth() / 2));
		bottomRight = isFree(MyPropertiesMap.GET_HOR_TILE(x + getWidth() / 2), MyPropertiesMap.GET_VER_TILE((y + dy) - getWidth() / 2));

		if (dy > 0) {
			if (topLeft || topRight) {
				dy = 0;
				tempy = (tileVer) * MyPropertiesMap.GET_HEIGHT_TILE() + getHeight() / 2;
			} else
				tempy += dy;
		}

		if (dy < 0) {
			if (bottomLeft || bottomRight) {
				dy = 0;
				falling = false;
				tempy = (tileVer) * MyPropertiesMap.GET_HEIGHT_TILE() + getHeight() / 2;
			} else
				tempy += dy;
		}

		topLeft = isFree(MyPropertiesMap.GET_HOR_TILE((x + dx) - getWidth() / 2), MyPropertiesMap.GET_VER_TILE(y + getWidth() / 2));
		topRight = isFree(MyPropertiesMap.GET_HOR_TILE((x + dx) + getWidth() / 2), MyPropertiesMap.GET_VER_TILE(y + getWidth() / 2));
		bottomLeft = isFree(MyPropertiesMap.GET_HOR_TILE((x + dx) - getWidth() / 2), MyPropertiesMap.GET_VER_TILE(y - getWidth() / 2));
		bottomRight = isFree(MyPropertiesMap.GET_HOR_TILE((x + dx) + getWidth() / 2), MyPropertiesMap.GET_VER_TILE(y - getWidth() / 2));

		if (dx < 0) {
			if (topLeft || bottomLeft) {
				dx = 0;
				tempx = (tileHor) * MyPropertiesMap.GET_WIDTH_TILE() + getWidth() / 2;
			} else
				tempx += dx;
		}

		if (dx > 0) {
			if (topRight || bottomRight) {
				dx = 0;
				tempx = (tileHor) * MyPropertiesMap.GET_WIDTH_TILE() + getWidth() / 2;
				System.out.println(tempx);
			} else
				tempx += dx;
		}
		
		topLeft = isFree(MyPropertiesMap.GET_HOR_TILE(x - getWidth() / 2), MyPropertiesMap.GET_VER_TILE((y + dy) + getWidth() / 2) - 1);
		topRight = isFree(MyPropertiesMap.GET_HOR_TILE(x + getWidth() / 2), MyPropertiesMap.GET_VER_TILE((y + dy) + getWidth() / 2) - 1);
		bottomLeft = isFree(MyPropertiesMap.GET_HOR_TILE(x - getWidth() / 2), MyPropertiesMap.GET_VER_TILE((y + dy) - getWidth() / 2) - 1);
		bottomRight = isFree(MyPropertiesMap.GET_HOR_TILE(x + getWidth() / 2), MyPropertiesMap.GET_VER_TILE((y + dy) - getWidth() / 2) - 1);

		if (!falling)
			if (!bottomLeft && !bottomRight)
				falling = true;

		x = tempx;
		y = tempy;

		setX(x);
		setY(y);
	}

	public boolean isFree(int hor, int ver) {
		if (MyPropertiesMap.GET_TILE(hor, ver) != null)
			return true;
		else
			return false;
	}
}
