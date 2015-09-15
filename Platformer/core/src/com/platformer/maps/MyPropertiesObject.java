package com.platformer.maps;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;

public class MyPropertiesObject {

	// Класс свойств объекта

	private MapProperties prop;

	//Загрузка объекта
	public MyPropertiesObject(MapObject object) {
		prop = object.getProperties();
	}

	//Ширина объекта
	public float getWidthObject() {
		return prop.get("width", Float.class);
	}

	//Высота объекта
	public float getHeightObject() {
		return prop.get("height", Float.class);
	}

	// Х координата объекта
	public float getXObject() {
		return prop.get("x", Float.class);
	}

	// Y координата объекта
	public float getYObject() {
		return prop.get("y", Float.class);
	}
}
