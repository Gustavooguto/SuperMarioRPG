package com.mygdx.game.screens.world.enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.MainScreen;
import com.mygdx.game.screens.world.ghost.Ghost;
import com.mygdx.game.screens.world.mario.Mario;
import com.mygdx.game.screens.world.rock.Rock;
import com.mygdx.game.screens.world.tree.Tree;

import java.util.Random;

public class Enemy extends Sprite {
    public static Enemy ref;
    float x, y;
    Random r = new Random();
    boolean walk;
    float nX, nY;
    InputProcessorEnemy inputProcessorEnemy;

    public Enemy(){
       super(MainScreen.sprites_img, 387, 234, 27,34);
        this.setSize(26,34);
        this.setPosition(730,466);
        ref=this;
    }

    public void draw (Batch batch, float delta){
        super.draw(batch);
        update(delta);
    }

    public void update(float delta) {
        if (!walk) return;
        if(nX - this.getX() != 0){
            float deltaX = (nX - this.getX())/Math.abs(nX - this.getX());
            this.setX(this.getX() + (deltaX*delta)*75);
        }else{
            float deltaX = 0;
        }
        if(nY - this.getY() != 0){
            float deltaY = (nY - this.getY())/Math.abs(nY - this.getY());
            this.setY(this.getY() + (deltaY*delta)*75);
        }else{
            float deltaY = 0;
        }
    }
    public void walk(boolean walk, float nX, float nY) {
        this.walk = walk;
        this.nX = nX;
        this.nY = Gdx.graphics.getHeight()-nY;
    }
    public boolean MarioTouch(Mario mario){
        float centreY = mario.getHeight() / 2 + mario.getY();
        float centreX = mario.getWidth() / 2 + mario.getX();
        return ((centreX > this.getX() &&
                centreY > this.getY() &&
                centreX < (this.getX() + this.getWidth()) &&
                centreY < (this.getY() + this.getHeight())) ||
                (centreX > this.getX() &&
                        centreY > this.getY() &&
                        centreX < (this.getX() + this.getWidth()) &&
                        centreY < (this.getY() + this.getHeight())));
    }

    public boolean EnemyTouch(Ghost ghost){
        float centreY = ghost.getHeight() / 2 + ghost.getY();
        float centreX = ghost.getWidth() / 2 + ghost.getX();
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

    public boolean RockTouch(Rock rock){
        float centreY = rock.getHeight() / 2 + rock.getY();
        float centreX = rock.getWidth() / 2 + rock.getX();
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

    public boolean TreeTouch(Tree tree){
        float centreY = tree.getHeight() / 2 + tree.getY();
        float centreX = tree.getWidth() / 2 + tree.getX();
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

    public void dispose(){
        this.dispose();
    }
}
