package com.acidcarpet.hydroponist.screen.settings;

import com.acidcarpet.hydroponist.screen.box.BoxScreen;
import com.acidcarpet.hydroponist.screen.seedling.SeedlingOffer;
import com.acidcarpet.hydroponist.screen.seedling.SeedlingResources;
import com.acidcarpet.hydroponist.screen.seedling.SeedlingShop;
import com.acidcarpet.hydroponist.storage.Inventory;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class SettingsScreen implements Screen {

    long last_update;

    Game game;

    Skin skin;
    TextureAtlas atlas;
    Stage stage;


    public SettingsScreen(Game game){
        this.game = game;
        last_update = 1;

    }

    @Override
    public void show() {

        stage = new Stage(new ExtendViewport(1080, 1920));

        atlas = SettingsResources.getAtlas();
        skin = SettingsResources.getSkin();
        Gdx.input.setInputProcessor(stage);

        Image background = new Image(atlas.findRegion("background"));
        background.setBounds(0, 0, stage.getWidth(), stage.getHeight());
        background.setName("background");
        stage.addActor(background);

        stage.addActor(generate_items_pane());
        stage.addActor(generate_buttons_pane());

    }

    @Override
    public void render(float delta) {
        if(last_update!= Settings.getLast_update()){

            try{    stage.getRoot().findActor("items_pane").clearListeners();                    }catch (Exception e){ System.out.println(e.getMessage());}
            try{    stage.getRoot().removeActor(stage.getRoot().findActor("items_pane"));        }catch (Exception e){ System.out.println(e.getMessage());}
            try{    stage.getRoot().findActor("buttons_pane").clearListeners();                  }catch (Exception e){ System.out.println(e.getMessage());}
            try{    stage.getRoot().removeActor(stage.getRoot().findActor("buttons_pane"));      }catch (Exception e){ System.out.println(e.getMessage());}

            try{    stage.addActor(generate_items_pane());                                              }catch (Exception e){ System.out.println(e.getMessage());}
            try{    stage.addActor(generate_buttons_pane());                                            }catch (Exception e){ System.out.println(e.getMessage());}


            last_update = Settings.getLast_update();
        }

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

    }

    public Group generate_items_pane(){
        Group out = new Group();

        Image background = new Image(atlas.findRegion("items_background"));
        background.setPosition(0, 0);
        background.setName("items_background");
        out.addActor(background);

        Table table = new Table();
        table.defaults().width(1080).height(200);

        ImageButton music_button;
        if(Settings.isMusic()){
            music_button = new ImageButton(skin, "red_music_button");
        }else{
            music_button = new ImageButton(skin, "green_music_button");
        }
        music_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                music_button_click();
            }
        });
        music_button.setName("music_button");
        table.add(music_button);
        table.row();

        ImageButton sound_button;
        if(Settings.isSound()){
            sound_button = new ImageButton(skin, "red_sound_button");
        }else{
            sound_button = new ImageButton(skin, "green_sound_button");
        }
        sound_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sound_button_click();
            }
        });
        sound_button.setName("sound_button");
        table.add(sound_button);
        table.row();

        ImageButton vibration_button;
        if(Settings.isVibration()){
            vibration_button = new ImageButton(skin, "red_vibration_button");
        }else{
            vibration_button = new ImageButton(skin, "green_vibration_button");
        }
        vibration_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                vibration_button_click();
            }
        });
        vibration_button.setName("vibration_button");
        table.add(vibration_button);
        table.row();

        ImageButton reset_button;
        reset_button = new ImageButton(skin, "green_reset_button");
        reset_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                reset_button_click();
            }
        });
        reset_button.setName("reset_button");
        table.add(reset_button);
        table.row();

        ImageButton about_button;
        about_button = new ImageButton(skin, "green_about_button");
        about_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                about_button_click();
            }
        });
        about_button.setName("about_button");
        table.add(about_button);
        table.row();

        ImageButton study_button;
        study_button = new ImageButton(skin, "green_study_button");
        study_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                study_button_click();
            }
        });
        study_button.setName("study_button");
        table.add(study_button);
        table.row();

        ScrollPane pane = new ScrollPane(table);
        pane.setScrollingDisabled(true, false);
        pane.setBounds(0 ,0 ,1080 , 1760);
        out.addActor(pane);

        out.setName("items_pane");
        out.setPosition(0+40, 160);

        return out;
    }

    public Group generate_buttons_pane(){
        Group out = new Group();

        Image background = new Image(atlas.findRegion("buttons_background"));
        background.setPosition(0, 0);
        background.setName("buttons_background");
        out.addActor(background);

        ImageButton back_button = new ImageButton(skin, "back_button");
        back_button.setBounds(1080/2-(560/2), 20, 560, 120);
        back_button.setName("back_button");
        back_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                back_button_click();
            }
        });
        out.addActor(back_button);

        out.setName("buttons_pane");
        out.setPosition(0+40, 0);
        return out;
    }

    public void back_button_click(){
        game.setScreen(new BoxScreen(game));
    }
    public void music_button_click(){

        Settings.change_music();
    }
    public void sound_button_click(){
        Settings.change_sound();
    }
    public void vibration_button_click(){
        Settings.change_vibration();
    }
    public void reset_button_click(){
        
    }
    public void about_button_click(){

    }
    public void study_button_click(){

    }
}
