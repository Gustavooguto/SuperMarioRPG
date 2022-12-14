package com.mygdx.game.screens.world.enemy;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.screens.world.ghost.Ghost;
import com.mygdx.game.screens.world.mario.Mario;
import com.mygdx.game.screens.world.rock.Rock;
import com.mygdx.game.screens.world.tree.Tree;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;

import static com.mygdx.game.screens.MainScreen.sprites_img;

public class EnemyController {
    public static EnemyController ref;
    private ConcurrentLinkedDeque<Enemy> enemies, deadEnemies;
    int qtd_enemies = 5, gap=20;

    public EnemyController(){
        init();
    }
    public void init() {
        if (ref == null) {
            ref = this;
            enemies = new ConcurrentLinkedDeque<Enemy>();
            deadEnemies = new ConcurrentLinkedDeque<Enemy>();
        }
    }
    public void draw(SpriteBatch batch, float delta){
        for (Enemy e : enemies){
        e.draw(batch,delta);
        }
    }
    public Enemy newEnemy(float x, float y, float xDest, float yDest){
        Enemy b;
        b = new Enemy();
        System.out.println("size enemies: "+enemies.size());

        if (deadEnemies.size() > 0){
            b = deadEnemies.remove();
            //Resetar posição do inimigo
        }else if (enemies.size() < qtd_enemies){
            enemies.add(b);
            b.setPosition(x, y);
        }
        b.walk(true, xDest, yDest);
        return b;
    }
    public void EnemyMove (float x, float y){
        for(Enemy e:enemies){
            e.walk(true,x,y);
            if(e.MarioTouch(Mario.ref) == true){
                System.out.println("GAME OVER");
            }
        }
    }

    public void TreeHit(Tree tree){
        for(Enemy e:enemies){
            if(e.TreeTouch(tree)){
                e.walk = false;
            }
        }
    }

    public void RockHit(Rock rock){
        for(Enemy e:enemies){
            if(e.RockTouch(rock)){
                e.walk = false;
            }
        }
    }

    public void KilledEnemy(Ghost ghost){
        for(Enemy e:enemies){
            if(e.EnemyTouch(ghost)){
                deadEnemies.add(e);
                enemies.remove(e);
                break;
            }
        }
    }
}
