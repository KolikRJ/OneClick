package com.platformer.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.platformer.debug.Debug;
import com.platformer.maps.MyMap;
import com.platformer.objects.Player;

public class GameScreen implements Screen {

	// ����� ������ ����

	// �������� �����
	private MyMap map;

	private Player player;

	private Debug debug;

	private byte tab = 0;

	// ����������� ������
	public GameScreen(SpriteBatch batch) {
		map = new MyMap(batch, "level1.tmx");

		debug = new Debug(map, map.getCamera());

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
		keyPressed();
		if (debug.isDebug())
			debug.render();
		
		player.render(delta);
	}

	private void keyPressed() {
		if (Gdx.input.isKeyJustPressed(Keys.TAB)) {
			if (tab >= 1)
				tab = 0;
			else
				tab++;
		}
		if (tab == 1) {
			debug.setDebug(true);
			player.setDebug(true);
		} else {
			debug.setDebug(false);
			player.setDebug(false);
		}

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
		debug.dispose();
	}

}
