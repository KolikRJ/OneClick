package com.platformer.maps;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapProperties;

public class MyPropertiesObject {

	// ����� ������� �������

	private MapProperties prop;

	//�������� �������
	public MyPropertiesObject(MapObject object) {
		prop = object.getProperties();
	}

	//������ �������
	public float getWidthObject() {
		return prop.get("width", Float.class);
	}

	//������ �������
	public float getHeightObject() {
		return prop.get("height", Float.class);
	}

	// � ���������� �������
	public float getXObject() {
		return prop.get("x", Float.class);
	}

	// Y ���������� �������
	public float getYObject() {
		return prop.get("y", Float.class);
	}
}
