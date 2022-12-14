package com.mygdx.game.screens.world.rock;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.MainScreen;
import com.mygdx.game.screens.world.enemy.Enemy;
import com.mygdx.game.screens.world.ghost.Ghost;
import com.mygdx.game.screens.world.mario.Mario;

public class Rock extends Sprite {
    public static Rock ref;
    Sprite rock;
    public Rock(){
       super(MainScreen.rock_img, 419, 257, 33,22);
        this.setSize(33,22);
        ref=this;
    }

    public void draw(SpriteBatch batch, float delta) {
        super.draw(batch);
        this.update(delta);
        if (this.isOutScreen()) return;
    }

    public void update(float delta) {
        this.setX(this.getX());
        this.setY(this.getY());
    }
    public boolean isOutScreen() {
        return this.getY() < 0;
    }

    public boolean GhostTouch(Ghost entity){
        float centreY = entity.getHeight() / 2 + entity.getY();
        float centreX = entity.getWidth() / 2 + entity.getX();
        return ((centreX > this.getX() &&
                centreY > this.getY()
                &&
                centreX < (this.getX() + this.getWidth()) &&
                centreY < (this.getY() + this.getHeight())) ||
                (centreX > this.getX() &&
                        centreY > this.getY()
                        &&
                        centreX < (this.getX() + this.getWidth()) &&
                        centreY < (this.getY() + this.getHeight())));
    }

    public boolean MarioTouch(Mario entity){
        float centreY = entity.getHeight() / 2 + entity.getY();
        float centreX = entity.getWidth() / 2 + entity.getX();
        return ((centreX > this.getX() &&
                centreY > this.getY()
                &&
                centreX < (this.getX() + this.getWidth()) &&
                centreY < (this.getY() + this.getHeight())) ||
                (centreX > this.getX() &&
                        centreY > this.getY()
                        &&
                        centreX < (this.getX() + this.getWidth()) &&
                        centreY < (this.getY() + this.getHeight())));
    }

    public boolean EnemyTouch(Enemy entity){
        float centreY = entity.getHeight() / 2 + entity.getY();
        float centreX = entity.getWidth() / 2 + entity.getX();
        return ((centreX > this.getX() &&
                centreY > this.getY()
                &&
                centreX < (this.getX() + this.getWidth()) &&
                centreY < (this.getY() + this.getHeight())) ||
                (centreX > this.getX() &&
                        centreY > this.getY()
                        &&
                        centreX < (this.getX() + this.getWidth()) &&
                        centreY < (this.getY() + this.getHeight())));
    }
}
