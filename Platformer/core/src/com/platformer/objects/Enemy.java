package com.platformer.objects;

import com.platformer.maps.MyPropertiesMap;

public class Enemy extends MyTextureMapObject {
	private float x;
	private float y;
	private float dx;
	private float dy;

	private float moveSpeed;

	private boolean topLeft;
	private boolean topRight;
	private boolean bottomLeft;
	private boolean bottomRight;

	public Enemy() {

		moveSpeed = 60.8f;

		x = getX();
		y = getY();

	}

	@Override
	public void render(float delta) {

		calculateCorners(x, y);

		if (topRight || bottomRight)
			moveSpeed = -moveSpeed;

		if (topLeft || bottomLeft)
			moveSpeed = +moveSpeed;

		dx = moveSpeed * delta;

		x += dx;
		y += dy;

		setX(x);
		setY(y);

	}

	public void calculateCorners(float x, float y) {
		topLeft = MyPropertiesMap.GET_TILE(MyPropertiesMap.GET_HOR_TILE(x - getWidth() / 2), MyPropertiesMap.GET_VER_TILE(y + getHeight() / 2)) != null;
		topRight = MyPropertiesMap.GET_TILE(MyPropertiesMap.GET_HOR_TILE(x + getWidth() / 2), MyPropertiesMap.GET_VER_TILE(y + getHeight() / 2)) != null;
		bottomLeft = MyPropertiesMap.GET_TILE(MyPropertiesMap.GET_HOR_TILE(x - getWidth() / 2), MyPropertiesMap.GET_VER_TILE(y - getHeight() / 2)) != null;
		bottomRight = MyPropertiesMap.GET_TILE(MyPropertiesMap.GET_HOR_TILE(x + getWidth() / 2), MyPropertiesMap.GET_VER_TILE(y - getHeight() / 2)) != null;
	}

}
