package com.mygdx.game.screens.world.ghost;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.screens.MainScreen;
import com.mygdx.game.screens.world.enemy.Enemy;
import com.mygdx.game.screens.world.mario.Mario;

public class Ghost extends Sprite {
    static Ghost ref;

    boolean walk;
    float nX;

    public Ghost(){
        super(MainScreen.ghost_img,506, 346, 17,17);
        this.setSize(17,17);
        this.setPosition(0,0);
        ref=this;
    }
    public boolean isOutScreen() {
        return this.getY() < 0;
    }

    public void update(float delta){
        if (!walk) return;
        if(nX - this.getX() != 0){
            float deltaX = (nX - this.getX())/Math.abs(nX - this.getX());
            this.setX(this.getX() + (deltaX*delta)*70);
        }
    }

    //@Override
    public void draw (Batch batch, float delta){
        super.draw(batch);
        update(delta);
    }
    public void walk(boolean walk, float nX) {
        this.walk = walk;
        this.nX = nX;
    }
    /*public boolean EnemyTouch(Enemy enemy){
        float centreY = enemy.getHeight() / 2 + enemy.getY();
        float centreX = enemy.getWidth() / 2 + enemy.getX();
        return ((centreX > this.getX() &&
                centreY > this.getY() &&
                centreX < (pipeDown.getX() + pipeDown.getWidth()) &&
                centreY < (pipeDown.getY() + pipeDown.getHeight())) ||
                (centreX > this.getX() &&
                        centreY > this.getY() &&
                        centreX < (pipeUp.getX() + pipeUp.getWidth()) &&
                        centreY < (pipeUp.getY() + pipeUp.getHeight())));
    }*/
}
