package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class touchListener extends ApplicationAdapter implements InputProcessor {                    //application adapter class invokes automatically created functions


    private SpriteBatch batch;                                     //SpriteBatch is used to draw images
    private BitmapFont font;
    private int screenWidth,screenHeight;
    private String msg= " This is legend ADI! ";


    private Sprite sprite;                                            //sprite object

    @Override
    public void create () {

        batch=new SpriteBatch();

        screenWidth=Gdx.graphics.getWidth();                    //this will give height and width in pixel whwn touched
        screenHeight=Gdx.graphics.getHeight();

        font=new BitmapFont();
        font.setColor(Color.BROWN);
        font.getData().scale(5);

        Gdx.input.setInputProcessor(this);                          //it imples that the result of the input will be displayed in this class only


    }

    @Override                                                                      //this is game loop method, it is automatically called n no. of times
    public void render () {

        Gdx.gl.glClearColor(0,1,0,1);                                             //inbuild methods to clear the screen R,G,B,alpha value
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, msg);

        float x = screenWidth/2 - glyphLayout.width/2;
        float y = screenHeight/2 + glyphLayout.height/2;

        batch.begin();//drawing starts

        font.draw(batch,msg,x,y);

        batch.end(); //drawing ends here

    }

    @Override                                                                 //it frees memory after render
    public void dispose () {
        batch.dispose();
        font.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        msg="Touched down at "+ screenX+","+screenY;
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        msg="Touched up at "+ screenX+","+screenY;
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        //msg="Dragged at "+ screenX+","+screenY;
        return false;
    }







    @Override //for desktop application
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
}
