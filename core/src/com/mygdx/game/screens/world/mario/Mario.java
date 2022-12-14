package com.mygdx.game.screens.world.mario;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.world.enemy.Enemy;
import com.mygdx.game.screens.world.rock.Rock;
import com.mygdx.game.screens.world.tree.Tree;

public class Mario extends Sprite {
    public static Mario ref;
    boolean walk;
    int nX, nY;

    public Mario(Texture img, int x, int y, int width, int height){
        super(img, x, y, width, height);
        ref = this;
    }

    public void draw(SpriteBatch batch, float delta) {
        super.draw(batch);
        update(delta);
    }

    public void update(float delta){
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

    public void walk(boolean walk, int nX, int nY) {
        this.walk = walk;
        this.nX = nX;
        this.nY = Gdx.graphics.getHeight()-nY;
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

    public void TreeHit(Tree tree){
        if(this.TreeTouch(tree)){
            this.walk = false;
        }
    }

    public void RockHit(Rock rock){
        if(this.RockTouch(rock)){
            this.walk = false;
        }
    }
}
