package com.mygdx.game;

/**
 * Created by ADITYA SI on 4/10/2017.
 */

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;



import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class animation extends ApplicationAdapter {                    //application adapter class invokes automatically created functions


    private SpriteBatch batch;                                     //SpriteBatch is used to draw images

    private TextureAtlas msd;                                            //raw image that will be convrted into sprite
    private Animation animation;
    private float time=0;

    private Sprite sprite;                                            //sprite object

    @Override
    public void create () {

        batch=new SpriteBatch();

        msd= new TextureAtlas(Gdx.files.internal("msd.atlas"));
        animation=new Animation(2/3f,msd.getRegions());                  //1/30f is frames per sec, msd is the atlas name which consists of images



    }

    @Override                                                                      //this is game loop method, it is automatically called n no. of times
    public void render () {

        Gdx.gl.glClearColor(0,1,0,1);                                             //inbuild methods to clear the screen R,G,B,alpha value
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.begin();//drawing starts

        time+=Gdx.graphics.getDeltaTime();   //automatically change the image
        batch.draw((TextureRegion) animation.getKeyFrame(time, true),200,300);

        batch.end(); //drawing ends here

    }

    @Override                                                                 //it frees memory after render
    public void dispose () {
        batch.dispose();
        msd.dispose();
    }
}

