package com.platformer.objects;

import java.util.Iterator;

import com.badlogic.gdx.utils.Array;

public class MyMapObjects implements Iterable<MyTextureMapObject> {

	private Array<MyTextureMapObject> objects;

	public MyMapObjects() {
		objects = new Array<MyTextureMapObject>();
	}

	public MyTextureMapObject get(int index) {
		return objects.get(index);
	}

	public MyTextureMapObject get(String name) {
		for (MyTextureMapObject object : objects) {
			if (name.equals(object.getName()))
				return object;
		}
		return null;
	}

	public void add(MyTextureMapObject object) {
		objects.add(object);
	}

	public void remove(int index) {
		objects.removeIndex(index);
	}

	public void remove(MyTextureMapObject object) {
		objects.removeValue(object, true);
	}

	@Override
	public Iterator<MyTextureMapObject> iterator() {
		return objects.iterator();
	}

}
