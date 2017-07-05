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
    Texture texture;
    Vector2 position;
    float speed;
    
    public Player() {
        texture = new Texture("ship80x60.tga");
        speed = 5.0f;
        position = new Vector2(100 , 100);
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
        if (position.y < -60) position.y = 720;
        if (position.y > 720) position.y = -60;
    }
}
