package com.gamedev.galaxydefenders;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	private final int ASTEROID_COUNT = 20;
	private final int BULLET_COUNT = 50;
	
	private SpriteBatch batch;
	private Background background;
	private Player player;
	private Asteroid[] asteroids;
	public static Bullet[] bullets;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		player = new Player();
		
		asteroids = new Asteroid[ASTEROID_COUNT];
		for (int i = 0; i < ASTEROID_COUNT; i++)
			asteroids[i] = new Asteroid();
		
		bullets = new Bullet[BULLET_COUNT];
		for (int i = 0; i < BULLET_COUNT; i++)
			bullets[i] = new Bullet();
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 0.5f); //RGBA
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
		
		for (int i = 0; i < ASTEROID_COUNT; i++)
			asteroids[i].render(batch);
		
		for (int i = 0; i < BULLET_COUNT; i++)
			if (bullets[i].isAlive())
				bullets[i].render(batch);
		
		player.render(batch);
		batch.end();
	}
	
	public void update() {
		background.update();
		player.update();
		
		for (int i = 0; i < ASTEROID_COUNT; i++)
			asteroids[i].update();
		
		for (int i = 0; i < BULLET_COUNT; i++)
			if (bullets[i].isAlive())
				bullets[i].update();
		
		for (int i = 0; i < BULLET_COUNT; i++)
			if (bullets[i].isAlive())
				for (int j = 0; j < ASTEROID_COUNT; j++)
					if (asteroids[j].getRectangle().contains(bullets[i].getPosition())) {
						asteroids[j].recreate();
						bullets[i].destroy();
						break;
					}
			
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
