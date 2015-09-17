package com.platformer.objects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.platformer.maps.MyPropertiesObject;

public class MyTextureObject extends MapObject {

	private MyPropertiesObject prop;

	private float x = 0.0f;
	private float y = 0.0f;
	private float originX = 0.0f;
	private float originY = 0.0f;
	private float width = 0.0f;
	private float height = 0.0f;
	private float scaleX = 1.0f;
	private float scaleY = 1.0f;
	private float rotation = 0.0f;
	private TextureRegion textureRegion = null;

	public MyTextureObject() {
		this(null);
	}

	/**
	 * Creates texture map object with the given region
	 * 
	 * @param textureRegion
	 *            the {@link TextureRegion} to use.
	 */
	public MyTextureObject(TextureRegion textureRegion) {
		super();
		prop = new MyPropertiesObject(this);
		width = prop.getWidthObject();
		height = prop.getHeightObject();
		this.textureRegion = textureRegion;
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

	/** @return x axis coordinate */
	public float getX() {
		return x;
	}

	/**
	 * @param x
	 *            new x axis coordinate
	 */
	public void setX(float x) {
		this.x = x;
	}

	/** @return y axis coordinate */
	public float getY() {
		return y + height;
	}

	/**
	 * @param y
	 *            new y axis coordinate
	 */
	public void setY(float y) {
		this.y = y;
	}

	/** @return x axis origin */
	public float getOriginX() {
		return originX;
	}

	/**
	 * @param x
	 *            new x axis origin
	 */
	public void setOriginX(float x) {
		this.originX = x;
	}

	/** @return y axis origin */
	public float getOriginY() {
		return originY;
	}

	/**
	 * @param y
	 *            new axis origin
	 */
	public void setOriginY(float y) {
		this.originY = y;
	}

	/** @return x axis scale */
	public float getScaleX() {
		return scaleX;
	}

	/**
	 * @param x
	 *            new x axis scale
	 */
	public void setScaleX(float x) {
		this.scaleX = x;
	}

	/** @return y axis scale */
	public float getScaleY() {
		return scaleY;
	}

	/**
	 * @param y
	 *            new y axis scale
	 */
	public void setScaleY(float y) {
		this.scaleY = y;
	}

	/** @return texture's rotation in radians */
	public float getRotation() {
		return rotation;
	}

	/**
	 * @param rotation
	 *            new texture's rotation in radians
	 */
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	/** @return region */
	public TextureRegion getTextureRegion() {
		return textureRegion;
	}

	/**
	 * @param region
	 *            new texture region
	 */
	public void setTextureRegion(TextureRegion region) {
		textureRegion = region;
	}

}
