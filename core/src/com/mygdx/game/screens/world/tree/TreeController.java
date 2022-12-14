package com.mygdx.game.screens.world.tree;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.screens.world.enemy.Enemy;
import com.mygdx.game.screens.world.enemy.EnemyController;
import com.mygdx.game.screens.world.ghost.Ghost;
import com.mygdx.game.screens.world.mario.Mario;

import java.util.Random;

public class TreeController {
    static Array<Tree> trees = new Array<Tree>();
    //static float gap = (int) Math.random() * 52;
    int posX, posY,qtd_trees = 6;
    Random rand = new Random();

    public void init() {
        trees = new Array<>(qtd_trees);
        for (int i = 0; i < qtd_trees; i++) {
            Tree tree = new Tree();
            trees.add(tree);
            /*posX = rand.nextInt(700);
            posY = rand.nextInt(500);*/
            if(i==0){
                posY = rand.nextInt((300-150)+1)+150;
                posX = rand.nextInt(200);
                tree.setPosition((float) posX, (float) posY);
                tree.setPosition(150, 150);
            } else if(i==1){
                posY = rand.nextInt((300-150)+1)+150;
                posX = rand.nextInt((300-200)+1)+200;
                tree.setPosition((float) posX, (float) posY);
                tree.setPosition(400, 0);
            }else if(i==2){
                posY = rand.nextInt(150);
                posX = rand.nextInt((300-200)+1)+200;
                tree.setPosition((float) posX, (float) posY);
                tree.setPosition(650, 175);
            }else if(i==3){
                posY = rand.nextInt((600-450)+1)+450;
                posX = rand.nextInt((300-200)+1)+200;
                tree.setPosition((float) posX, (float) posY);
                tree.setPosition(500, 480);
            }else if(i==4){
                posY = rand.nextInt((600-450)+1)+450;
                posX = rand.nextInt(200);
                tree.setPosition((float) posX, (float) posY);
                tree.setPosition(100, 450);
            }else{
                posY = rand.nextInt((450-300)+1)+300;
                posX = rand.nextInt(200);
                tree.setPosition((float) posX, (float) posY);
                tree.setPosition(35, 350);
            }
        }
    }

    public void draw(SpriteBatch batch, float delta) {
        for (int i = 0; i < qtd_trees; i++) {
            trees.get(i).draw(batch, delta);
            EnemyController.ref.TreeHit(trees.get(i));
            Mario.ref.TreeTouch(trees.get(i));
        }
    }

}
/*
*
* if((posX >= 61 && posX <= 139) && (posX >= 28 && posX <= 172)){
                tree.setX(posX+39);
                tree.setY(posY+72);
            } else if (posX >= 668 && posY >= 444){
                tree.setX(posX-98);
                tree.setY(posY-134);
            }   else{
                tree.setX(posX);
                tree.setY(posY);
            }*/