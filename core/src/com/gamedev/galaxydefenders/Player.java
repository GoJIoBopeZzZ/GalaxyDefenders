package com.gamedev.galaxydefenders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by _red_ on 06.07.17.
 */
public class Player {
    private Texture texture;
    private Vector2 position;
    private float speed;
    private int fireRate;
    private int fireCounter;
    
    
    public Player() {
        texture = new Texture("ship80x60.tga");
        speed = 9.0f;
        position = new Vector2(100 , 100);
        fireRate = 5;
    }
    
    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }
    
    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            position.y += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            position.y -= speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && position.x >= 0) {
            position.x -= speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && position.x <= 640) {
            position.x += speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            fireCounter++;
            if (fireRate < fireCounter) {
                fireCounter = 0;
                for (int i = 0; i < Game.bullets.length; i++) {
                    if (!Game.bullets[i].isAlive()) {
                        Game.bullets[i].setup(position.x + 60, position.y + 10);
                        break;
                    }
                }
            }
        }
        if (position.y < -60) position.y = 720;
        if (position.y > 720) position.y = -60;
    }
}
