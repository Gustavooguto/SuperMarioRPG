package com.mygdx.game.screens.world.ghost;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.mygdx.game.screens.world.mario.Mario;

import java.util.Random;

public class InputProcessorGhost implements InputProcessor{
    Random random;
    public InputProcessorGhost (){
        random = new Random(10);
    }

    @Override
    public boolean keyDown(int i) {
        if (i == Input.Keys.SPACE){
            GhostController.ref.newGhost(Mario.ref.getX(),(Mario.ref.getY()+(72/2)),Gdx.graphics.getWidth());
        }
        //ghostController.render(batch);
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }
}
