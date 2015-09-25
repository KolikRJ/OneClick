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

	/**
	 * 
	 * @return индекс объектов в массиве объектов карты.
	 */
	public static int getIndex() {
		return index;
	}

	/**
	 * Прибавляет 1 к индексу объектов массиве объектов карты.
	 */
	public static void setIndex() {
		index++;
	}

	/**
	 * @brief Абстрактный метод для рендринга дочерних объектов.
	 * @param delta
	 */
	public abstract void render(float delta);

	/**
	 * @brief Метод для отрисовки объектов.
	 * @param batch
	 * @param delta
	 */
	public void renderObject(SpriteBatch batch, float delta) {
		render(delta);
		batch.draw(textureRegion, x - height / 2, y - height / 2, originX, originY, width, height, scaleX, scaleY, -rotation);
	}

	/**
	 * 
	 * @return Возвращает имя объекта.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @brief Устанавить имя объекта.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return Возвращает ширину.
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * @brief Устанавить ширину.
	 * @param width
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	/**
	 * 
	 * @return Вовращает высоту.
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * @brief Установить высоту.
	 * @param height
	 */
	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * 
	 * @return Возвращает x.
	 */
	public float getX() {
		return x;
	}

	/**
	 * @Brief установить x.
	 * @param x
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return Возвращает y.
	 *
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y
	 *            Установить y.
	 */
	public void setY(float y) {
		this.y = y;
	}

	/** @return Возващает X центра. */
	public float getOriginX() {
		return originX;
	}

	/**
	 * @param x
	 *            Установить X центра.
	 */
	public void setOriginX(float x) {
		this.originX = x;
	}

	/** @return Возващает Y центра. */
	public float getOriginY() {
		return originY;
	}

	/**
	 * @param y
	 *            Установить Y центра.
	 */
	public void setOriginY(float y) {
		this.originY = y;
	}

	/** @return Возвращает маштаб по X. */
	public float getScaleX() {
		return scaleX;
	}

	/**
	 * @param x
	 *            Установить маштаб по X.
	 */
	public void setScaleX(float x) {
		this.scaleX = x;
	}

	/** @return Возвращает маштаб по Y. */
	public float getScaleY() {
		return scaleY;
	}

	/**
	 * @param y
	 *            Установить маштаб по Y.
	 */
	public void setScaleY(float y) {
		this.scaleY = y;
	}

	/** @return Возвращает угол поворота текстуры в радианах. */
	public float getRotation() {
		return rotation;
	}

	/**
	 * @param rotation
	 *            Устанавливает угол поворота текстуры в радианах.
	 */
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	/** @return Регион текстуры. */
	public TextureRegion getTextureRegion() {
		return textureRegion;
	}

	/**
	 * @param region
	 *            Устанавливает Регион текстуры.
	 */
	public void setTextureRegion(TextureRegion region) {
		textureRegion = region;
	}

}
