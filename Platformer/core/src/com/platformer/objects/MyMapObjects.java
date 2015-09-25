package com.platformer.objects;

import java.util.Iterator;

import com.badlogic.gdx.utils.Array;

/**
 * 
 * @author KolikRJ
 * @brief ����� ���������� ������ ���������� ��������.
 */
public class MyMapObjects implements Iterable<MyTextureMapObject> {

	private Array<MyTextureMapObject> objects;

	public MyMapObjects() {
		objects = new Array<MyTextureMapObject>();
	}

	/**
	 * 
	 * @param index
	 * @return ���������� ������ �� ������� �� �������.
	 */
	public MyTextureMapObject get(int index) {
		return objects.get(index);
	}

	/**
	 * 
	 * @param name
	 * @return ���������� ������ �� ������� �� �����.
	 */
	public MyTextureMapObject get(String name) {
		for (MyTextureMapObject object : objects) {
			if (name.equals(object.getName()))
				return object;
		}
		return null;
	}

	/**
	 * 
	 * @param object
	 *            ��������� ������ � ������.
	 */
	public void add(MyTextureMapObject object) {
		objects.add(object);
	}

	/**
	 * 
	 * @param index
	 *            ������� ������ �� ������� �� �������.
	 */
	public void remove(int index) {
		objects.removeIndex(index);
	}

	/**
	 * 
	 * @param index
	 *            ������� ������ �� ������� �� �����.
	 */
	public void remove(String name) {
		for (int i = 0, n = objects.size; i < n; i++) {
			if (objects.get(i).getName().equals(name))
				objects.removeIndex(i);
		}
	}

	/**
	 * 
	 * @param object
	 *            ������� ������ ������ �� �������.
	 */
	public void remove(MyTextureMapObject object) {
		objects.removeValue(object, true);
	}

	/**
	 * �������� �� �������.
	 */
	@Override
	public Iterator<MyTextureMapObject> iterator() {
		return objects.iterator();
	}

}
