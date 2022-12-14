package com.mygdx.game.screens.world.ghost;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.world.enemy.Enemy;
import com.mygdx.game.screens.world.enemy.EnemyController;

import java.util.ArrayList;

public class GhostController {
    public static GhostController ref;
    private ArrayList<Ghost> ghosts, deadGhosts;

    public GhostController(){
        init();
    }

    public void init(){
        if (ref == null) {
            ref = this;
            ghosts = new ArrayList<Ghost>(100);
            deadGhosts = new ArrayList<Ghost>(100);
        }
    }

    public void draw(SpriteBatch batch, float delta){
        for (int k=0; k<ghosts.size(); k++){
            ghosts.get(k).draw(batch,delta);
            EnemyController.ref.KilledEnemy(ghosts.get(k));
        }
    }
    public Ghost newGhost(float x, float y, float xDest){
        Ghost b;
        if (deadGhosts.size() > 0){
            b = deadGhosts.remove(0);
        }else{
            b = new Ghost();
        }
        ghosts.add(b);
        b.setPosition(x, y);
        b.walk(true, xDest);
        return b;
    }

    public void GhostMove (int x, int y){
        for(Ghost g:ghosts){

        }
    }
}
