package com.platformer.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

/**
 * 
 * @author KolikRJ
 * @brief ����� ���������� ������.
 */
public class MyMenuScreen implements Screen {

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
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
	}

}
