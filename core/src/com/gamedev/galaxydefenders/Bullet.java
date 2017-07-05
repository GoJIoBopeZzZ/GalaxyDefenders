package com.gamedev.galaxydefenders;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by _red_ on 06.07.17.
 */
public class Bullet {
    private static Texture texture;
    private Vector2 position; // Position X && Position Y
    private float speed;
    private boolean alive;
    
    public boolean isAlive() {
        return alive;
    }
    
    public Bullet () {
        if (texture == null) {
            texture = new Texture("bullet20.png");
        }
        position = new Vector2(0.0f , 0.0f);
        speed = 10.0f;
        alive = false;
    }
    
    public Vector2 getPosition() {
        return position;
    }
    
    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }
    
    public void setup(float x, float y) {
        alive = true;
        position.x = x;
        position.y = y;
    }
    
    public void destroy() {
        alive = false;
    }
    
    public void update() {
        position.x += speed;
        if (position.x > 1280) destroy();
    }
}
