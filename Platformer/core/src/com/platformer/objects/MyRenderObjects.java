package com.platformer.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.platformer.maps.MyPropertiesMap;

/**
 * 
 * @author KolikRJ
 * @brief Класс рендринга объектов.
 */
public class MyRenderObjects {

	private SpriteBatch batch;
	private MyMapObjects myObjects;

	/**
	 * 
	 * @param batch
	 */
	public MyRenderObjects(SpriteBatch batch) {
		this.batch = batch;
		myObjects = new MyMapObjects();

		/*
		 * Бегаем по объектам, узнаем имя каждого объекта, если имя NULL, то
		 * выводим ошибку. Если имя не NULL, то создаем пустой объект по данному
		 * имени, ищем данный класс в объектах, если класса нет, то выводим
		 * ошибку, иначе вызываем его и преобразовываем в класс текстурных
		 * объектов.
		 */
		for (MapObject object : MyPropertiesMap.GET_OBJECTS()) {
			String name = object.getName();
			if (name != null) {
				MyTextureMapObject ob = null;
				try {
					ob = (MyTextureMapObject) Class.forName("com.platformer.objects." + name).newInstance();
					myObjects.add(ob);
					MyTextureMapObject.setIndex();
				} catch (Exception e) {
					System.err.println("You have created a new object, create a new class: " + name);
					MyTextureMapObject.setIndex();
				}
			} else {
				System.err.println("Name is NULL object! Number object: " + (MyTextureMapObject.getIndex() + 1));
				MyTextureMapObject.setIndex();
			}
		}
	}

	/**
	 * 
	 * @param delta
	 *            Рендринг всех объектов.
	 */
	public void render(float delta) {
		batch.begin();
		for (MyTextureMapObject object : myObjects)
			object.renderObject(batch, delta);
		batch.end();
	}

}
