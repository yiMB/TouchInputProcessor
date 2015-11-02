package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * this class contain player image, x y coordinate, and touch listener,
 * other class can call this class image,coordinate, and update method,
 *
 * InputProcessor,
 *      -touch listener
 *
 * 2 way to include InputProcessor to a class you want to listen to touch input,
 *      -create the InputProcessor class instance inside this class,
 *      -this class implements InputProcessor to access InputProcessor's methods,
 *
 * I like create the InputProcessor class instance inside this class,
 * because when dealing with collision detection, classes will be dependence on other classes.
 */
public class Player {
    Texture texture;
    Sprite sprite;
    Vector2 vector2;
    float speedX;

    public Player() {
        texture = new Texture("cheesecake.png");
        sprite = new Sprite(texture);
        vector2 = new Vector2(0, 0);
        speedX = 1000f;
        sprite.setPosition(vector2.x, vector2.y);

        Gdx.input.setInputProcessor(new InputProcessor() {

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                moveIt(screenX, speedX);
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                moveIt(screenX, speedX);
                return true;
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
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }
            @Override
            public boolean scrolled(int amount) {
                return false;
            }
        });
    }

    public void moveIt(int screenX, float speedX){
        if(screenX < sprite.getX() + sprite.getWidth()/2){
            if(sprite.getX() > 0){
                vector2.x -= speedX * Gdx.graphics.getDeltaTime();
                sprite.setX(vector2.x);
            }
        }
        else if(screenX > sprite.getX() + sprite.getWidth()/2){
            if(sprite.getX() + sprite.getWidth() < Gdx.graphics.getWidth()){
                vector2.x += speedX * Gdx.graphics.getDeltaTime();
                sprite.setX(vector2.x);
            }
        }
    }
}

//public class Player implements InputProcessor{
//    Texture texture;
//    Sprite sprite;
//    Vector2 vector2;
//    float speedX;
//
//    public Player() {
//        texture = new Texture("cheesecake.png");
//        sprite = new Sprite(texture);
//        vector2 = new Vector2(0, 0);
//        speedX = 1000f;
//        sprite.setPosition(vector2.x, vector2.y);
//
//        /*
//		tell where to listen for input, where to look for those input methods
//		this mean InputProcessor object represent by this class itself
//		if InputProcessor object created by other class then pass that InputProcessor object instead
//		 */
//        Gdx.input.setInputProcessor(this);
//    }
//
//    @Override
//    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        moveIt(screenX, speedX);
//        return true;
//    }
//    @Override
//    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
//        return false;
//    }
//    @Override
//    public boolean touchDragged(int screenX, int screenY, int pointer) {
//        moveIt(screenX, speedX);
//        return true;
//    }
//    @Override
//    public boolean keyDown(int keycode) {
//        return false;
//    }
//    @Override
//    public boolean keyUp(int keycode) {
//        return false;
//    }
//    @Override
//    public boolean keyTyped(char character) {
//        return false;
//    }
//    @Override
//    public boolean mouseMoved(int screenX, int screenY) {
//        return false;
//    }
//    @Override
//    public boolean scrolled(int amount) {
//        return false;
//    }
//
//    public void moveIt(int screenX, float speedX){
//        if(screenX < sprite.getX() + sprite.getWidth()/2){
//            if(sprite.getX() > 0){
//                vector2.x -= speedX * Gdx.graphics.getDeltaTime();
//                sprite.setX(vector2.x);
//            }
//        }
//        else if(screenX > sprite.getX() + sprite.getWidth()/2){
//            if(sprite.getX() + sprite.getWidth() < Gdx.graphics.getWidth()){
//                vector2.x += speedX * Gdx.graphics.getDeltaTime();
//                sprite.setX(vector2.x);
//            }
//        }
//    }
//}