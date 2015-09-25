package com.platformer.maps;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;

/**
 * 
 * @author KolikRJ
 * @brief ����� �������� �������.
 */
public class MyPropertiesObject {

	private MapProperties prop;

	/**
	 * 
	 * @param object
	 *            �������� �������.
	 */
	public MyPropertiesObject(MapObject object) {
		prop = object.getProperties();
	}

	/**
	 * 
	 * @return ��������� ������ �������.
	 */
	public float getWidthObject() {
		return prop.get("width", Float.class);
	}

	/**
	 * 
	 * @return ��������� ������ �������.
	 */
	public float getHeightObject() {
		return prop.get("height", Float.class);
	}

	/**
	 * 
	 * @return ��������� x ���������� �������.
	 */
	public float getXObject() {
		return prop.get("x", Float.class);
	}

	/**
	 * 
	 * @return ��������� y ���������� �������.
	 */
	public float getYObject() {
		return prop.get("y", Float.class);
	}
}
