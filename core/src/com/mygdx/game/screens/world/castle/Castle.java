package com.mygdx.game.world.castle;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Castle extends Sprite {
    public static Castle ref;
    boolean destroyed=false;
    public Castle(Texture img, int x, int y, int width, int height){
        super(img, x, y, width, height);
        ref = this;
    }

    public void draw(SpriteBatch batch, float delta) {
        super.draw(batch);
    }

    public void update(float delta) {
        this.setX(this.getX()); // - 70f * delta
        this.setY(this.getY()); // - 70f * delta
    }
}