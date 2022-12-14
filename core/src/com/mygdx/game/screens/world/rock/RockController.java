package com.mygdx.game.screens.world.rock;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.screens.world.enemy.EnemyController;
import com.mygdx.game.screens.world.mario.Mario;

import java.util.Random;

public class RockController {
    static Array<Rock> rocks = new Array<Rock>();
    int posX, posY,qtd_rocks = 7;
    Random rand = new Random();

    public void init() {
        rocks = new Array<>(qtd_rocks);
        for (int i = 0; i < qtd_rocks; i++) {
            Rock rock = new Rock();
            rocks.add(rock);
            if(i==0){
                posY = rand.nextInt((300-150)+1)+150;
                posX = rand.nextInt(200);
                rock.setPosition((float) posX, (float) posY);
                rock.setPosition(250, 75);
            } else if(i==1){
                posY = rand.nextInt((300-150)+1)+150;
                posX = rand.nextInt((300-200)+1)+200;
                rock.setPosition((float) posX, (float) posY);
                rock.setPosition(500, 200);
            }else if(i==2){
                posY = rand.nextInt(150);
                posX = rand.nextInt((300-200)+1)+200;
                rock.setPosition((float) posX, (float) posY);
                rock.setPosition(650, 35);
            }else if(i==3){
                posY = rand.nextInt((600-450)+1)+450;
                posX = rand.nextInt((300-200)+1)+200;
                rock.setPosition((float) posX, (float) posY);
                rock.setPosition(720, 400);
            }else if(i==4){
                posY = rand.nextInt((600-450)+1)+450;
                posX = rand.nextInt(200);
                rock.setPosition((float) posX, (float) posY);
                rock.setPosition(350, 450);
            }else{
                posY = rand.nextInt((450-300)+1)+300;
                posX = rand.nextInt(200);
                rock.setPosition((float) posX, (float) posY);
                rock.setPosition(300, 350);
            }
        }
    }

    public void draw(SpriteBatch batch, float delta) {
        for (int i = 0; i < qtd_rocks; i++) {
            rocks.get(i).draw(batch, delta);
            EnemyController.ref.RockHit(rocks.get(i));
            Mario.ref.RockTouch(rocks.get(i));
        }
    }
}
