package com.acidcarpet.hydroponist.screen;

import com.acidcarpet.hydroponist.equipment.Box;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
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


private void lamp_click(){

}
    private void plant_click(){
        System.err.println("Plant click!");
    }
    private void fan_click(){
        System.err.println("Fan click!");
    }
    private void pot_click(){
        System.err.println("Pot click!");
    }
    private void compressor_click(){
        System.err.println("Compressor click!");
    }
    private void x3_button_click(){
        System.out.println("x3_button click!");
    }
    private void shop_button_click(){
        System.out.println("shop_button click!");
    }
    private void storage_button_click(){
        System.out.println("storage_button click!");
    }
    private void donat_button_click(){
        System.out.println("donat_button click!");
    }
    private void settings_button_click(){
        System.out.println("settings_button click!");
    }
    private void room_button_click(){
        System.out.println("room_button click!");
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        atlas = new TextureAtlas(Gdx.files.internal("skin/box/skin/skin.atlas"));
        skin = new Skin(Gdx.files.internal("skin/box/skin/skin.json"), atlas);
        Gdx.input.setInputProcessor(stage);
        background = new Image(atlas.findRegion("background"));
        background.setBounds(0, 0, stage.getWidth(), stage.getHeight());

        Image lamp_empty_image = new Image(atlas.findRegion("lamp_empty"));
        lamp_empty_image.setName("lamp_image");
        lamp_empty_image.setFillParent(true);
        lamp_empty = new ImageButton(new ImageButton.ImageButtonStyle());
        lamp_empty.addActor(lamp_empty_image);
        lamp_empty.setName("lamp");
        lamp_empty.setBounds((stage.getWidth()/2)-(lamp_empty_image.getWidth()/2), stage.getHeight()-lamp_empty_image.getHeight(), lamp_empty_image.getWidth(), lamp_empty_image.getHeight());
        lamp_empty.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                lamp_click();
            }
        });

        Image light_empty_image = new Image(atlas.findRegion("light_empty"));
        light_empty_image.setFillParent(true);
        light_empty_image.setName("light_image");
        light_empty = new ImageButton(new ImageButton.ImageButtonStyle());
        light_empty.addActor(light_empty_image);
        light_empty.setName("light");
        light_empty.setBounds(0, 0, stage.getWidth(), stage.getHeight());

        Image fan_empty_image = new Image(atlas.findRegion("fan_empty"));
        fan_empty_image.setFillParent(true);
        fan_empty_image.setName("fan_image");
        fan_empty = new ImageButton(new ImageButton.ImageButtonStyle());
        fan_empty.addActor(fan_empty_image);
        fan_empty.setName("fan");
        fan_empty.setBounds(15, stage.getHeight()-500, fan_empty_image.getWidth(), fan_empty_image.getHeight());
        fan_empty.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                fan_click();
            }
        });

        Image plant_empty_image = new Image(atlas.findRegion("plant_empty"));
        //plant_empty_image.setPosition(0, 0);
        plant_empty_image.setName("plant_image");
        plant_empty_image.setFillParent(true);
        plant_empty = new ImageButton(new ImageButton.ImageButtonStyle());
        plant_empty.addActor(plant_empty_image);
        plant_empty.setName("plant");
        plant_empty.setBounds(stage.getWidth()/2-plant_empty_image.getWidth()/2, 500, plant_empty_image.getWidth(), plant_empty_image.getHeight());
        plant_empty.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                plant_click();
            }
        });

        Image pot_empty_image = new Image(atlas.findRegion("pot_empty"));
        pot_empty_image.setFillParent(true);
        pot_empty_image.setName("pot_image");
        pot_empty = new ImageButton(new ImageButton.ImageButtonStyle());
        pot_empty.addActor(pot_empty_image);
        pot_empty.setName("pot");
        pot_empty.setBounds(stage.getWidth()/2-(pot_empty_image.getWidth()/2), 0, pot_empty_image.getWidth(), pot_empty_image.getHeight());
        pot_empty.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                pot_click();
            }
        });

       Image compressor_empty_image = new Image(atlas.findRegion("compressor_empty"));
       compressor_empty_image.setFillParent(true);
       compressor_empty_image.setName("compressor_image");
       compressor_empty = new ImageButton(new ImageButton.ImageButtonStyle());
       compressor_empty.addActor(compressor_empty_image);
       compressor_empty.setName("compressor");
       compressor_empty.setBounds(stage.getWidth()-(compressor_empty_image.getWidth()), 0, compressor_empty_image.getWidth(), compressor_empty_image.getHeight());
       compressor_empty.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                compressor_click();
            }
        });



//        ,
//        ,
//        ,



       x3_button = new ImageButton(skin, "x3_button");
       x3_button.addListener(new ClickListener() {
           @Override
           public void clicked(InputEvent event, float x, float y) {
               x3_button_click();
           }
       });
       x3_button.setPosition(stage.getWidth()-x3_button.getWidth(), stage.getHeight()-500);

       shop_button = new ImageButton(skin, "shop_button");
       shop_button.addListener(new ClickListener() {
           @Override
           public void clicked(InputEvent event, float x, float y) {
               shop_button_click();
           }
       });
       shop_button.setPosition(stage.getWidth()-shop_button.getWidth(), stage.getHeight()-650);

       inventory_button = new ImageButton(skin, "storage_button");
        inventory_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                storage_button_click();
            }
        });
        inventory_button.setPosition(stage.getWidth()-inventory_button.getWidth(), stage.getHeight()-800);

        donation_button = new ImageButton(skin, "donation_button");
        donation_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                donat_button_click();
            }
        });
        donation_button.setPosition(stage.getWidth()-donation_button.getWidth(), stage.getHeight()-950);

        settings_button = new ImageButton(skin, "settings_button");
        settings_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                settings_button_click();
            }
        });
        settings_button.setPosition(0, stage.getHeight()-650);

        room_button = new ImageButton(skin, "room_button");
        room_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                room_button_click();
            }
        });
        room_button.setPosition(0, stage.getHeight()-800);


        stage.addActor(background);

        stage.addActor(fan_empty);
        stage.addActor(plant_empty);
        stage.addActor(pot_empty);
        stage.addActor(compressor_empty);


        stage.addActor(light_empty);
        stage.addActor(lamp_empty);

        stage.addActor(x3_button);
        stage.addActor(shop_button);
        stage.addActor(inventory_button);
        stage.addActor(donation_button);

        stage.addActor(settings_button);
        stage.addActor(room_button);





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
