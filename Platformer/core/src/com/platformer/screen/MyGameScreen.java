package com.platformer.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.platformer.maps.MyLoadMap;

/**
 * 
 * @author KolikRJ ����� ������ ����.
 */
public class MyGameScreen implements Screen {

	// �������� �����
	private MyLoadMap map;

	/**
	 * 
	 * @param batch
	 *            �������� �����.
	 */
	public MyGameScreen(SpriteBatch batch) {
		map = new MyLoadMap(batch, "level1.tmx");
	}

	/**
	 * ���������� ������ ��� ��� ������ ������� ������.
	 */
	@Override
	public void show() {
	}

	/**
	 * ������ ������.
	 */
	@Override
	public void render(float delta) {
		Gdx.gl.glBlendColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		map.render(delta);
	}

	/**
	 * ���������� ��� ������������� ������.
	 */
	@Override
	public void resize(int width, int height) {
	}

	/**
	 * ������������ ����� ���������� ����� pause() � {@link}ApplicationListener
	 */
	@Override
	public void pause() {
	}

	/**
	 * ������������ ����� ���������� ����� resume() � {@link}ApplicationListener
	 */
	@Override
	public void resume() {
	}

	/**
	 * ������������ ����� ������ ����� �� �������
	 */
	@Override
	public void hide() {
	}

	/**
	 * ��������� ������������ �������
	 */
	@Override
	public void dispose() {
		map.dispose();
	}

}
