package com.platformer.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.platformer.maps.MyPropertiesMap;
import com.platformer.maps.MyPropertiesObject;

/**
 * 
 * @author KolikRJ
 * @brief ����� ���������� ��������.
 */
public abstract class MyTextureMapObject {

	private MyPropertiesObject prop;

	private static int index = 0;

	private String name = "";
	private float x = 0.0f;
	private float y = 0.0f;
	private float originX = 0.0f;
	private float originY = 0.0f;
	private float width = 0.0f;
	private float height = 0.0f;
	private float scaleX = 0.0f;
	private float scaleY = 0.0f;
	private float rotation = 0.0f;
	private TextureRegion textureRegion = null;

	/**
	 * 
	 * @param object
	 */
	public MyTextureMapObject() {

		TextureMapObject object = (TextureMapObject) MyPropertiesMap.GET_OBJECTS().get(index);

		prop = new MyPropertiesObject(object);
		name = object.getName();
		originX = object.getOriginX();
		originY = object.getOriginY();
		width = prop.getWidthObject();
		height = prop.getHeightObject();
		x = object.getX() + height / 2;
		y = object.getY() + (height + (height / 2));
		scaleX = object.getScaleX();
		scaleY = object.getScaleY();
		rotation = object.getRotation();
		textureRegion = object.getTextureRegion();
	}

	/**
	 * 
	 * @return ������ �������� � ������� �������� �����.
	 */
	public static int getIndex() {
		return index;
	}

	/**
	 * ���������� 1 � ������� �������� ������� �������� �����.
	 */
	public static void setIndex() {
		index++;
	}

	/**
	 * @brief ����������� ����� ��� ��������� �������� ��������.
	 * @param delta
	 */
	public abstract void render(float delta);

	/**
	 * @brief ����� ��� ��������� ��������.
	 * @param batch
	 * @param delta
	 */
	public void renderObject(SpriteBatch batch, float delta) {
		render(delta);
		batch.draw(textureRegion, x - height / 2, y - height / 2, originX, originY, width, height, scaleX, scaleY, -rotation);
	}

	/**
	 * 
	 * @return ���������� ��� �������.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @brief ���������� ��� �������.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return ���������� ������.
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * @brief ���������� ������.
	 * @param width
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * 
	 * @return ��������� ������.
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * @brief ���������� ������.
	 * @param height
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * 
	 * @return ���������� x.
	 */
	public float getX() {
		return x;
	}

	/**
	 * @Brief ���������� x.
	 * @param x
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return ���������� y.
	 *
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y
	 *            ���������� y.
	 */
	public void setY(float y) {
		this.y = y;
	}

	/** @return ��������� X ������. */
	public float getOriginX() {
		return originX;
	}

	/**
	 * @param x
	 *            ���������� X ������.
	 */
	public void setOriginX(float x) {
		this.originX = x;
	}

	/** @return ��������� Y ������. */
	public float getOriginY() {
		return originY;
	}

	/**
	 * @param y
	 *            ���������� Y ������.
	 */
	public void setOriginY(float y) {
		this.originY = y;
	}

	/** @return ���������� ������ �� X. */
	public float getScaleX() {
		return scaleX;
	}

	/**
	 * @param x
	 *            ���������� ������ �� X.
	 */
	public void setScaleX(float x) {
		this.scaleX = x;
	}

	/** @return ���������� ������ �� Y. */
	public float getScaleY() {
		return scaleY;
	}

	/**
	 * @param y
	 *            ���������� ������ �� Y.
	 */
	public void setScaleY(float y) {
		this.scaleY = y;
	}

	/** @return ���������� ���� �������� �������� � ��������. */
	public float getRotation() {
		return rotation;
	}

	/**
	 * @param rotation
	 *            ������������� ���� �������� �������� � ��������.
	 */
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	/** @return ������ ��������. */
	public TextureRegion getTextureRegion() {
		return textureRegion;
	}

	/**
	 * @param region
	 *            ������������� ������ ��������.
	 */
	public void setTextureRegion(TextureRegion region) {
		textureRegion = region;
	}

}
