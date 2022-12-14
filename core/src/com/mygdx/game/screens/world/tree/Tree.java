package com.mygdx.game.screens.world.tree;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.MainScreen;
import com.mygdx.game.screens.world.enemy.Enemy;
import com.mygdx.game.screens.world.ghost.Ghost;
import com.mygdx.game.screens.world.mario.Mario;

import java.util.Random;

public class Tree extends Sprite {
    public static Tree ref;
    Sprite tree;
    public Tree(){
        super(MainScreen.tree_img, 34, 581, 98,112);
        this.setSize(98,112);
        ref = this;
    }

    public void draw(SpriteBatch batch, float delta) {
        super.draw(batch);
        this.update(delta);
        if (this.isOutScreen()) return;
        //tree.draw(batch);
    }

    public void update(float delta) {
        this.setX(this.getX()); // - 70f * delta
        this.setY(this.getY()); // - 70f * delta
    }
    public boolean isOutScreen() {
        return this.getY() < 0;
    }

    /*public boolean GhostTouch(Ghost entity){
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
    }*/
}