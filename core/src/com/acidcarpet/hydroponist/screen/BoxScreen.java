package com.acidcarpet.hydroponist.screen;

import com.acidcarpet.hydroponist.equipment.Box;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class BoxScreen implements Screen {

    Skin skin;
    TextureAtlas atlas;
    Stage stage;

    Image background;

    ImageButton lamp_empty;
    ImageButton light_empty;
    ImageButton fan_empty;
    ImageButton plant_empty;
    ImageButton pot_empty;
    ImageButton compressor_empty;

    ImageButton x3_button;
    ImageButton shop_button;
    ImageButton donation_button;
    ImageButton inventory_button;

    ImageButton settings_button;
    ImageButton room_button;

    Box box;



    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        atlas = new TextureAtlas(Gdx.files.internal("skin/box/skin/skin.pack"));
        //skin = new Skin(Gdx.files.internal("skin/box/skin/skin.json"));

        background = new Image(atlas.findRegion("background"));
        background.setBounds(0, 0, stage.getWidth(), stage.getHeight());

        Image lamp_empty_image = new Image(atlas.findRegion("lamp_empty"));
        lamp_empty_image.setName("lamp_image");
        lamp_empty = new ImageButton(new ImageButton.ImageButtonStyle());
        lamp_empty.addActor(lamp_empty_image);
        lamp_empty.setName("lamp");
        lamp_empty.setPosition((stage.getWidth()/2)-(lamp_empty_image.getWidth()/2), stage.getHeight()-lamp_empty_image.getHeight());

        Image light_empty_image = new Image(atlas.findRegion("light_empty"));
        light_empty_image.setBounds(0,0, stage.getWidth(), stage.getHeight());
        light_empty_image.setName("light_image");
        light_empty = new ImageButton(new ImageButton.ImageButtonStyle());
        light_empty.addActor(light_empty_image);
        light_empty.setName("light");
        light_empty.setBounds(0, 0, stage.getWidth(), stage.getHeight());

        Image fan_empty_image = new Image(atlas.findRegion("fan_empty"));
        fan_empty_image.setPosition(0, 0);
        fan_empty_image.setName("fan_image");
        fan_empty = new ImageButton(new ImageButton.ImageButtonStyle());
        fan_empty.addActor(fan_empty_image);
        fan_empty.setName("fan");
        fan_empty.setBounds(15, stage.getHeight()-500, fan_empty_image.getWidth(), fan_empty_image.getHeight());

        Image plant_empty_image = new Image(atlas.findRegion("plant_empty"));
        //plant_empty_image.setPosition(0, 0);
        plant_empty_image.setName("plant_image");
        plant_empty_image.setFillParent(true);
        plant_empty = new ImageButton(new ImageButton.ImageButtonStyle());
        plant_empty.addActor(plant_empty_image);
        plant_empty.setName("plant");
        plant_empty.setBounds(stage.getWidth()/2-plant_empty_image.getWidth()/2, 500, plant_empty_image.getWidth(), plant_empty_image.getHeight());

        Image pot_empty_image = new Image(atlas.findRegion("pot_empty"));
        pot_empty_image.setPosition((1080/2)-350, 0);
        pot_empty_image.setName("pot_image");
        pot_empty = new ImageButton(new ImageButton.ImageButtonStyle());
        pot_empty.addActor(pot_empty_image);
        pot_empty.setName("pot");
        pot_empty.setBounds(stage.getWidth()/2-pot_empty_image.getWidth()/2, 0, pot_empty_image.getWidth(), pot_empty_image.getHeight());

       Image compressor_empty_image = new Image(atlas.findRegion("compressor_empty"));
       compressor_empty_image.setPosition(1080-300, 0);
       compressor_empty_image.setName("compressor_image");
       compressor_empty = new ImageButton(new ImageButton.ImageButtonStyle());
       compressor_empty.addActor(compressor_empty_image);
       compressor_empty.setName("compressor");

        stage.addActor(background);

        stage.addActor(fan_empty);
        stage.addActor(plant_empty);
        stage.addActor(pot_empty);


        stage.addActor(light_empty);
        stage.addActor(lamp_empty);




    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
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
    skin.dispose();
    atlas.dispose();
    stage.dispose();
    }
}
