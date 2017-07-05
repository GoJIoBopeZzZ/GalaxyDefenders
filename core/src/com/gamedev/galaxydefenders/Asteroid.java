package com.gamedev.galaxydefenders;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by _red_ on 06.07.17.
 */
public class Asteroid {
    private static Texture texture;
    private Vector2 position;
    private float speed;
    private Rectangle rectangle;
    
    public Asteroid() {
        if (texture == null) {
            texture = new Texture("asteroid60.tga");
        }
        
        speed = 6.0f + (float) Math.random() * 3.0f;
        position = new Vector2(1280 + (float) Math.random() * 300.0f , (float) Math.random() * 720.0f);
        rectangle = new Rectangle(position.x, position.y, 60, 60);
    }
    
    public Rectangle getRectangle() {
        return rectangle;
    }
    
    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }
    
    public void recreate() {
        position.x = 1280 + (float) Math.random() * 300.0f;
        position.y = (float) Math.random() * 720.0f;
    }
    
    public void update() {
        position.x -= speed;
        rectangle.x = position.x;
        rectangle.y = position.y;
        if (position.x < -60) recreate();
    }
}
