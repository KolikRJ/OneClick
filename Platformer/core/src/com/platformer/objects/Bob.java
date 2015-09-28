package com.platformer.objects;

public class Bob extends MyTextureMapObject {

	@Override
	public void render(float delta) {

		setX(getX() + 1);

	}

}
