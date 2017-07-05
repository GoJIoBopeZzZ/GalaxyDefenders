package com.gamedev.galaxydefenders;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {
    private Texture texture;
    private Texture textureStar;
    
    class Star {
        private Vector2 position; // Position X && Position Y
        private float speed;
    
        public Star () {
            position = new Vector2((float) Math.random() * 1280 ,
                    (float) Math.random() * 720 );
            speed = 1.0f + (float) Math.random() * 10.0f;
        }
        
        public void update() {
            position.x -= speed;
            position.y += (float) Math.sin(position.x / 100.0f);
            if (position.x <= -20) {
                position.x = 1280 + (float) Math.random() * 300;
                position.y = (float) Math.random() * 720;
                speed = 1.0f + (float) Math.random() * 10.0f;
            }
        }
    }
    
    private final int STARS_COUNT = 500;
    private Star[] stars;
    
    public Background () {
        texture = new Texture("staticback.jpg");
        textureStar = new Texture("star12.tga");
        stars = new Star[STARS_COUNT];
        for (int i = 0; i < STARS_COUNT; i++) {
            stars[i] = new Star();
        }
    }
    
    public void render (SpriteBatch batch) {
        batch.draw(texture, 0, 0);
        for (int i = 0; i < STARS_COUNT; i++) {
//            batch.setColor((stars[i].position.x + i) / 1280.0f, (stars[i].position.y) / 720.0f, 1, 1);
            batch.draw(textureStar, stars[i].position.x, stars[i].position.y);
        }
    }
    
    public void update() {
        for (int i = 0; i < STARS_COUNT; i++) {
            stars[i].update();
        }
    }
}
