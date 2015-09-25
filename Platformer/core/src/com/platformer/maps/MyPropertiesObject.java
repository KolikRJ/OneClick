package com.platformer.maps;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;

/**
 * 
 * @author KolikRJ
 * @brief Класс свыойств объекта.
 */
public class MyPropertiesObject {

	private MapProperties prop;

	/**
	 * 
	 * @param object
	 *            Загрузка объекта.
	 */
	public MyPropertiesObject(MapObject object) {
		prop = object.getProperties();
	}

	/**
	 * 
	 * @return Возващает ширину объекта.
	 */
	public float getWidthObject() {
		return prop.get("width", Float.class);
	}

	/**
	 * 
	 * @return Возващает высоту объекта.
	 */
	public float getHeightObject() {
		return prop.get("height", Float.class);
	}

	/**
	 * 
	 * @return Возващает x Координату объекта.
	 */
	public float getXObject() {
		return prop.get("x", Float.class);
	}

	/**
	 * 
	 * @return Возващает y координату объекта.
	 */
	public float getYObject() {
		return prop.get("y", Float.class);
	}
}
