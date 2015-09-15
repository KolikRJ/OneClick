package com.platformer.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.platformer.maps.LoadingMap;
import com.platformer.objects.Player;

public class GameScreen implements Screen {

	// ����� ������ ����

	// �������� �����
	private LoadingMap map;
	
	private Player player;

	// ����������� ������
	public GameScreen(SpriteBatch batch) {
		map = new LoadingMap(batch, "level1.tmx");
		
		player = new Player(map, batch);
	}

	// ������������ ����� ���������� ������ �����
	@Override
	public void show() {
	}

	// ��������
	@Override
	public void render(float delta) {
		Gdx.gl.glBlendColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		map.render();
		player.render(delta);
	}

	// ���������� ��� ������������ ������
	@Override
	public void resize(int width, int height) {
	}

	// ������������ ����� ���������� ����� pause() � ApplicationListener
	@Override
	public void pause() {
	}

	// ������������ ����� ���������� ����� resume() � ApplicationListener
	@Override
	public void resume() {
	}

	// ������������ ����� ������ ����� �� �������
	@Override
	public void hide() {
	}

	// ��������� ������������ �������
	@Override
	public void dispose() {
		map.dispose();
	}

}
