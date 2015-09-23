package com.platformer.maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.platformer.objects.MyRenderObjects;

public class MyRendererMap {

	// �������� ������ ��� ��������� �����
	private TiledMapRenderer mapRenderer;

	private MyRenderObjects renderObjects;
	// ���������� ��������
	private SpriteBatch batch;
	// �������� ������
	private MyCamera camera;

	// �������� ����� ��� ���������
	public MyRendererMap(TiledMap map, SpriteBatch batch) {
		this.batch = batch;
		mapRenderer = new OrthogonalTiledMapRenderer(map, batch);
		camera = new MyCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		renderObjects = new MyRenderObjects(batch);
	}

	// �������� �����
	public void render(float delta) {
		batch.setProjectionMatrix(camera.combined);
		camera.update();
		mapRenderer.setView(camera);
		mapRenderer.render();
		renderObjects.render(delta);
	}

	public MyCamera getCamera() {
		return camera;
	}

}