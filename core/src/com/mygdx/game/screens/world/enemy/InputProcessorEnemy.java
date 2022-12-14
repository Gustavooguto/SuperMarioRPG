package com.mygdx.game.screens.world.enemy;

import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.screens.world.mario.Mario;

public class InputProcessorEnemy implements InputProcessor {

    int n=0;
    public InputProcessorEnemy(){

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(n<5) {
            EnemyController.ref.newEnemy(730, 466,Mario.ref.getX(),Mario.ref.getY());
            n++;
        }else{
            EnemyController.ref.EnemyMove(Mario.ref.getX(),Mario.ref.getY());
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
