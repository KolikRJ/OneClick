package com.platformer.objects;

import java.util.Iterator;

import com.badlogic.gdx.utils.Array;

/**
 * 
 * @author KolikRJ
 * @brief Класс содержащий массив текстурных объектов.
 */
public class MyMapObjects implements Iterable<MyTextureMapObject> {

	private Array<MyTextureMapObject> objects;

	public MyMapObjects() {
		objects = new Array<MyTextureMapObject>();
	}

	/**
	 * 
	 * @param index
	 * @return Возвращает объект из массива по индексу.
	 */
	public MyTextureMapObject get(int index) {
		return objects.get(index);
	}

	/**
	 * 
	 * @param name
	 * @return Возвращает объект из массива по имени.
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
	 *            Добавляет объект в массив.
	 */
	public void add(MyTextureMapObject object) {
		objects.add(object);
	}

	/**
	 * 
	 * @param index
	 *            Удаляет объект из массива по индексу.
	 */
	public void remove(int index) {
		objects.removeIndex(index);
	}

	/**
	 * 
	 * @param index
	 *            Удаляет объект из массива по имени.
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
	 *            Удаляет объект объект из массива.
	 */
	public void remove(MyTextureMapObject object) {
		objects.removeValue(object, true);
	}

	/**
	 * Итерация по массиву.
	 */
	@Override
	public Iterator<MyTextureMapObject> iterator() {
		return objects.iterator();
	}

}
