package com.platformer.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.platformer.maps.MyPropertiesObject;

public class Player extends MyTextureMapObject {

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

	public Player(TextureMapObject object) {
		super(object);

		width = super.getWidth();
		height = super.getHeight();

		moveSpeed = 4.8f;
		maxSpeed = 8.8f;
		stopSpeed = 25.8f;
		maxFallSpeed = -8.2f;
		jumpSpeed = 5f;

		gravity = 10;

		super.setY(super.getY() + height);

		x = super.getX() + width / 2;
		y = super.getY() + height / 2;

		super.setX(x);
		super.setY(y);

	}

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

		x += dx;
		y += dy;

		super.setX(x);
		super.setY(y);

	}

	public float getX() {
		return x - width / 2;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y - height / 2;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

}
