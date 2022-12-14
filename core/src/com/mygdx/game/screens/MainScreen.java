package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screens.world.enemy.EnemyController;
import com.mygdx.game.screens.world.enemy.InputProcessorEnemy;
import com.mygdx.game.screens.world.ghost.GhostController;
import com.mygdx.game.screens.world.ghost.InputProcessorGhost;
import com.mygdx.game.screens.world.mario.InputProcessorMario;
import com.mygdx.game.screens.world.mario.Mario;
import com.mygdx.game.screens.world.rock.Rock;
import com.mygdx.game.screens.world.rock.RockController;
import com.mygdx.game.screens.world.tree.TreeController;
import com.mygdx.game.world.castle.Castle;

public class MainScreen implements Screen {

    public static MainScreen ref;
    public static Texture bg_img;
    public static Texture mario_img;
    public static Texture ghost_img;
    public static Texture rock_img;
    public static Texture tree_img;
    public static Texture sprites_img;

    SpriteBatch batch;
    Sprite backGround;
    Mario mario;
    Castle castle;

    RockController rockController;
    TreeController treeController;
    GhostController ghostController;
    EnemyController enemyController;

    InputMultiplexer inputMultiplexer;
    InputProcessorMario inputProcessorMario;
    InputProcessorGhost inputProcessorGhost;
    InputProcessorEnemy inputProcessorEnemy;

    @Override
    public void show() {
        ref = this;
        batch = new SpriteBatch();
        bg_img = new Texture("bg.png");
        backGround = new Sprite(bg_img, 0, 0, 800, 600);

        rock_img = new Texture("rock.png");
        tree_img = new Texture("tree.png");

        sprites_img = new Texture("sprites2.png");

        mario_img = new Texture("mario.png");
        mario = new Mario(mario_img,122, 292,39, 72);
        mario.setSize(39, 72);
        mario.setPosition(75,75);

        castle = new Castle(sprites_img, 379, 40,49, 67);
        castle.setSize(49*2, 67*2);
        castle.setX(701);
        castle.setY(466);

        rockController = new RockController();
        rockController.init();

        treeController = new TreeController();
        treeController.init();

        ghost_img = new Texture("sprites3.png");
        ghostController = new GhostController();

        enemyController = new EnemyController();
        enemyController.init();

        InputMultiplexer inputMultiplexer = new InputMultiplexer();

        inputProcessorMario = new InputProcessorMario();
        inputMultiplexer.addProcessor(inputProcessorMario);

        inputProcessorGhost = new InputProcessorGhost();
        inputMultiplexer.addProcessor(inputProcessorGhost);

        inputProcessorEnemy = new InputProcessorEnemy();
        inputMultiplexer.addProcessor(inputProcessorEnemy);

        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public void render(float delta) {
        batch.begin();
            backGround.draw(batch);

            rockController.draw(batch, delta);
            treeController.draw(batch, delta);
            mario.draw(batch, delta);
            castle.draw(batch, delta);
            enemyController.draw(batch, delta);
            ghostController.draw(batch, delta);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        bg_img.dispose();
    }
}
