package com.platformer.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.platformer.maps.MyPropertiesMap;
import com.platformer.maps.MyPropertiesObject;

/**
 * 
 * @author KolikRJ
 * @brief Класс текстурных объектов.
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

	public static int getIndex() {
		return index;
	}

	public static void setIndex() {
		index++;
	}

	/**
	 * @brief Абстрактный метод для рендринга дочерних объектов
	 * @param delta
	 */
	public abstract void render(float delta);

	/**
	 * @brief Метод для отрисовки объектов
	 * @param batch
	 * @param delta
	 */
	public void renderObject(SpriteBatch batch, float delta) {
		render(delta);
		batch.draw(textureRegion, x - height / 2, y - height / 2, originX, originY, width, height, scaleX, scaleY, -rotation);
	}

	/**
	 * 
	 * @return Возвращает имя объекта
	 */
	public String getName() {
		return name;
	}

	/**
	 * @brief Устанавить имя объекта
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return Возвращает ширину
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * @brief Устанавить ширину
	 * @param width
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * 
	 * @return Вовращает высоту
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * @brief Установить высоту
	 * @param height
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * 
	 * @return Возвращает x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @Brief установить x
	 * @param x
	 */
	public void setX(float x) {
		this.x = x;
	}

	/** @return y axis coordinate */
	public float getY() {
		return y;
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
