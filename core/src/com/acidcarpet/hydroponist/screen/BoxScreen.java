package com.acidcarpet.hydroponist.screen;

import com.acidcarpet.hydroponist.equipment.Box;
import com.acidcarpet.hydroponist.genered.test_pack.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class BoxScreen implements Screen {
    Game game;

    Skin skin;
    TextureAtlas atlas;

    Stage stage;

    Image background;

    Image lamp_empty;
    Image light_empty;
    Image fan_empty;
    Image plant_empty;
    Image pot_empty;
    Image compressor_empty;


    ImageButton x3_button;
    ImageButton shop_button;
    ImageButton donation_button;
    ImageButton inventory_button;
    ImageButton settings_button;
    ImageButton room_button;

    Box box;

    public BoxScreen(Game game){
        this.game = game;


    }

    private void lamp_click(){

    try{

        //box.getLamp().set_on_off();
        game.setScreen(new LampScreen(game));

    }catch (Exception e){
        e.printStackTrace();
    }

}
    private void plant_click(){
        System.err.println("Plant click!");
    }
    private void fan_click(){
        try{
            if(box.getFan().isOn())box.getFan().set_off();
            else box.getFan().set_on();
        }catch (Exception e){

        }
    }
    private void pot_click(){
        System.err.println("Pot click!");
    }
    private void compressor_click(){
        try{
            if(box.getCompressor().isOn()){
                box.getCompressor().set_off();
            }
            else {
                box.getCompressor().set_on();
            }
        }catch (Exception e){
        e.printStackTrace();
        }
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
        box = Box.getInstance();

        stage = new Stage(new ExtendViewport(1080, 1920));

        atlas = ScreenAtlas.getInstance().getBoxScreen_atlas();
        skin = ScreenAtlas.getInstance().getBoxScreen_skin();

        Gdx.input.setInputProcessor(stage);

        background = new Image(atlas.findRegion("background"));
        background.setName("background");
        background.setBounds(0, 0, stage.getWidth(), stage.getHeight());

        lamp_empty = new Image(atlas.findRegion("lamp_empty"));
        lamp_empty.setName("lamp");
        lamp_empty.setBounds((stage.getWidth()/2)-(800/2), stage.getHeight()-200, 800, 200);
        lamp_empty.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                lamp_click();
            }
        });

        light_empty = new Image(atlas.findRegion("light_empty"));
        light_empty.setName("light");
        light_empty.setBounds(0, 0, stage.getWidth(), stage.getHeight()-100);
        light_empty.setTouchable(Touchable.disabled);

        fan_empty = new Image(atlas.findRegion("fan_empty"));
        fan_empty.setName("fan");
        fan_empty.setBounds(15, stage.getHeight()-500, 300, 300);
        fan_empty.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                fan_click();
            }
        });

        plant_empty = new Image(atlas.findRegion("plant_empty"));
        plant_empty.setName("plant");
        plant_empty.setBounds(stage.getWidth()/2-plant_empty.getWidth()/2, 500, plant_empty.getWidth(), plant_empty.getHeight());
        plant_empty.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                plant_click();
            }
        });

        pot_empty = new Image(atlas.findRegion("pot_empty"));
        pot_empty.setName("pot");
        pot_empty.setBounds(stage.getWidth()/2-(pot_empty.getWidth()/2), 0, plant_empty.getWidth(), pot_empty.getHeight());
        pot_empty.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                pot_click();
            }
        });

       compressor_empty = new Image(atlas.findRegion("compressor_empty"));
       compressor_empty.setName("compressor");
       compressor_empty.setBounds(stage.getWidth()-(compressor_empty.getWidth()), 0, compressor_empty.getWidth(), compressor_empty.getHeight());
       compressor_empty.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                compressor_click();
            }
        });

       x3_button = new ImageButton(skin, "x3_button");
       x3_button.addListener(new ClickListener() {
           @Override
           public void clicked(InputEvent event, float x, float y) {
               x3_button_click();
           }
       });
       x3_button.setPosition(stage.getWidth()-x3_button.getWidth(), stage.getHeight()-500);
       x3_button.setName("x3_button");

       shop_button = new ImageButton(skin, "shop_button");
       shop_button.addListener(new ClickListener() {
           @Override
           public void clicked(InputEvent event, float x, float y) {
               shop_button_click();
           }
       });
       shop_button.setPosition(stage.getWidth()-shop_button.getWidth(), stage.getHeight()-650);
       shop_button.setName("shop_button");

       inventory_button = new ImageButton(skin, "storage_button");
       inventory_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                storage_button_click();
            }
        });
       inventory_button.setPosition(stage.getWidth()-inventory_button.getWidth(), stage.getHeight()-800);
       inventory_button.setName("inventory_button");

       donation_button = new ImageButton(skin, "donation_button");
       donation_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                donat_button_click();
            }
        });
       donation_button.setPosition(stage.getWidth()-donation_button.getWidth(), stage.getHeight()-950);
       donation_button.setName("donation_button");

       settings_button = new ImageButton(skin, "settings_button");
       settings_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                settings_button_click();
            }
        });
       settings_button.setPosition(0, stage.getHeight()-650);
       settings_button.setName("settings_button");

        room_button = new ImageButton(skin, "room_button");
        room_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                room_button_click();
            }
        });
        room_button.setPosition(0, stage.getHeight()-800);
        room_button.setName("room_button");


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

    if(box==null){ //Если бокс пустой сам по себе и нужны заглушки

        if(!lamp_empty.equals(stage.getRoot().findActor("lamp"))){
            stage.getRoot().removeActor(stage.getRoot().findActor("lamp"));
            stage.getRoot().addActorAfter(stage.getRoot().findActor("light"), lamp_empty);

        }
        if(!light_empty.equals(stage.getRoot().findActor("light"))){

            stage.getRoot().removeActor(stage.getRoot().findActor("light"));
            stage.getRoot().addActorBefore(stage.getRoot().findActor("lamp"), light_empty);

        }

        if(!fan_empty.equals(stage.getRoot().findActor("fan"))){

            stage.getRoot().removeActor(stage.getRoot().findActor("fan"));
            stage.getRoot().addActorBefore(stage.getRoot().findActor("plant"), fan_empty);


        }

        if(!plant_empty.equals(stage.getRoot().findActor("plant"))){

            stage.getRoot().removeActor(stage.getRoot().findActor("plant"));
            stage.getRoot().addActorBefore(stage.getRoot().findActor("pot"), plant_empty);

        }

        if(!pot_empty.equals(stage.getRoot().findActor("pot"))){

            stage.getRoot().removeActor(stage.getRoot().findActor("pot"));
            stage.getRoot().addActorBefore(stage.getRoot().findActor("compressor"), pot_empty);

        }
        if(!compressor_empty.equals(stage.getRoot().findActor("compressor"))){

            stage.getRoot().removeActor(stage.getRoot().findActor("compressor"));
            stage.getRoot().addActorBefore(stage.getRoot().findActor("light"), compressor_empty);

        }


    }else{ // Если бокс все же не пустой. Так должно быть 100% времени
        if(box.getLamp()!=null){// Если лампа есть
            if(!box.getLamp().get_image_lamp().equals(stage.getRoot().findActor("lamp"))){

                stage.getRoot().findActor("lamp").clear();
                stage.getRoot().findActor("lamp").remove();

                Image lamp_temp = box.getLamp().get_image_lamp();

                lamp_temp.setName("lamp");
                lamp_temp.setBounds((stage.getWidth()/2)-(lamp_empty.getWidth()/2), stage.getHeight()-lamp_empty.getHeight(), lamp_empty.getWidth(), lamp_empty.getHeight());

                lamp_temp.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        lamp_click();
                    }
                });

                stage.getRoot().addActorAfter(stage.getRoot().findActor("light"), lamp_temp);
            }
            if(!box.getLamp().get_image_light().equals(stage.getRoot().findActor("light"))){

                stage.getRoot().findActor("light").clear();
                stage.getRoot().findActor("light").remove();

                Image light_temp = box.getLamp().get_image_light();

                light_temp.setName("light");
                light_temp.setBounds(0, 0, stage.getWidth(), light_temp.getHeight());

                light_temp.setTouchable(Touchable.disabled);

                stage.getRoot().addActorBefore(stage.getRoot().findActor("lamp"), light_temp);
            }
        }else{ // если лампы нет должны быть заглушки как если бокса вообще нет, но только где лампа
            if(!lamp_empty.equals(stage.getRoot().findActor("lamp"))){

                stage.getRoot().findActor("lamp").clear();
                stage.getRoot().findActor("lamp").remove();

                lamp_empty.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        lamp_click();
                    }
                });
                stage.getRoot().addActorAfter(stage.getRoot().findActor("light"), lamp_empty);

            }
            if(!light_empty.equals(stage.getRoot().findActor("light"))){

                stage.getRoot().findActor("light").clear();
                stage.getRoot().findActor("light").remove();

                light_empty.setTouchable(Touchable.disabled);
                stage.getRoot().addActorBefore(stage.getRoot().findActor("lamp"), light_empty);

            }
        }

        if(box.getFan()!=null){ // Если вентилятор в боксе есть
            if(!box.getFan().get_image_fan().equals(stage.getRoot().findActor("fan"))){
                stage.getRoot().findActor("fan").clear();
                stage.getRoot().findActor("fan").remove();
                Image fan_temp = box.getFan().get_image_fan();

                fan_temp.setName("fan");
                fan_temp.setBounds(15, stage.getHeight()-500, fan_empty.getWidth(), fan_empty.getHeight());
                fan_temp.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        fan_click();
                    }
                });

                stage.getRoot().addActorBefore(stage.getRoot().findActor("plant"), fan_temp);

            }

        }else{ // Если вентилятора в боксе нет должна быть заглушка как если нет всего бокса но только на вентиляторе
            if(!fan_empty.equals(stage.getRoot().findActor("fan"))){
                stage.getRoot().findActor("fan").clear();
                stage.getRoot().findActor("fan").remove();
                stage.getRoot().addActorBefore(stage.getRoot().findActor("plant"), fan_empty);
            }
        }

        if(box.getPlant()!=null){ // Растение в боксе есть
            if(!box.getPlant().get_image_plant().equals(stage.getRoot().findActor("plant"))){
                stage.getRoot().findActor("plant").clear();
                stage.getRoot().findActor("plant").remove();
                Image plant_temp = box.getPlant().get_image_plant();

                plant_temp.setName("plant");
                plant_temp.setBounds(stage.getWidth()/2-plant_empty.getWidth()/2, 500, plant_empty.getWidth(), plant_empty.getHeight());
                plant_temp.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        plant_click();
                    }
                });

                stage.getRoot().addActorBefore(stage.getRoot().findActor("pot"), plant_temp);
            }
        }else{// Если растения нет вместо него должна быть заглушка как вообще без бокса, но только на растение
            if(!plant_empty.equals(stage.getRoot().findActor("plant"))){

                stage.getRoot().findActor("plant").clear();
                stage.getRoot().findActor("plant").remove();
                stage.getRoot().addActorBefore(stage.getRoot().findActor("pot"), plant_empty);

            }
        }

        if(box.getPot()!=null){ // Если горшок в боксе есть
            if(!box.getPot().get_image_pot().equals(stage.getRoot().findActor("pot"))){
                stage.getRoot().findActor("pot").clear();
                stage.getRoot().findActor("pot").remove();

                Image pot_temp = box.getPot().get_image_pot();

                pot_temp.setName("pot");
                pot_temp.setBounds(stage.getWidth()/2-(pot_empty.getWidth()/2), 0, plant_empty.getWidth(), pot_empty.getHeight());
                pot_temp.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        pot_click();
                    }
                });

                stage.getRoot().addActorBefore(stage.getRoot().findActor("compressor"), pot_temp);
            }

        }else{ // Если горшка в боксе нет должна быть заглушка как если нет всего бокса но только на горшке
            if(!pot_empty.equals(stage.getRoot().findActor("pot"))){
                stage.getRoot().findActor("pot").clear();
                stage.getRoot().findActor("pot").remove();
                stage.getRoot().addActorBefore(stage.getRoot().findActor("compressor"), pot_empty);
            }
        }

        if(box.getCompressor()!=null){ // Если вентилятор в боксе есть
            if(!box.getCompressor().get_image_compressor().equals(stage.getRoot().findActor("compressor"))){
                stage.getRoot().findActor("compressor").clear();
                stage.getRoot().findActor("compressor").remove();
                Image compressor_temp = box.getCompressor().get_image_compressor();

                compressor_temp.setName("compressor");
                compressor_temp.setBounds(stage.getWidth()-(compressor_empty.getWidth()), 0, compressor_empty.getWidth(), compressor_empty.getHeight());
                compressor_temp.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        compressor_click();
                    }
                });

                stage.getRoot().addActorBefore(stage.getRoot().findActor("light"), compressor_temp);
            }

        }else{ // Если вентилятора в боксе нет должна быть заглушка как если нет всего бокса но только на вентиляторе
            if(!compressor_empty.equals(stage.getRoot().findActor("compressor"))){
                stage.getRoot().findActor("compressor").clear();
                stage.getRoot().findActor("compressor").remove();
                stage.getRoot().addActorBefore(stage.getRoot().findActor("light"), compressor_empty);
            }
        }
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
    //skin.dispose();
    //atlas.dispose();
    stage.dispose();
    }
}
