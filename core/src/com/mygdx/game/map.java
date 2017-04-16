package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

public class map extends ApplicationAdapter implements GestureDetector.GestureListener {                    //application adapter class invokes automatically created functions


    private SpriteBatch batch;                                     //SpriteBatch is used to draw images
    private OrthographicCamera camera;
    private Texture texture;

    private Sprite sprite;                                            //sprite object

    @Override
    public void create() {

        batch = new SpriteBatch();

        camera= new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());          //to mention how muc part of the image camera will view initially
        texture= new Texture(Gdx.files.internal("mapp.jpg"));
        sprite= new Sprite(texture);

        sprite.setPosition(-sprite.getWidth()/2,-sprite.getHeight()/2);    //this will put the image in center
        Gdx.input.setInputProcessor(new GestureDetector(this));


    }

    @Override
    //this is game loop method, it is automatically called n no. of times
    public void render() {

        Gdx.gl.glClearColor(0, 1, 0, 1);                                             //inbuild methods to clear the screen R,G,B,alpha value
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);  //to display only particular part of image using camera


        batch.begin();//drawing starts

        sprite.draw(batch);

        batch.end(); //drawing ends here

    }

    @Override
    //it frees memory after render
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }


    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {                                     //for panning around the image
        camera.translate(-deltaX,deltaY);                                  //change in x and y while spanning
        camera.update();
        return true;
    }







    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }



    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}












