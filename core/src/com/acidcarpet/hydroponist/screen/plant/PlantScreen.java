package com.acidcarpet.hydroponist.screen.plant;

import com.acidcarpet.hydroponist.ref.box.Box;
import com.acidcarpet.hydroponist.screen.pot.PotResources;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class PlantScreen extends InputAdapter implements Screen {

    Game game;

    long box_last_update;

    Skin skin;
    TextureAtlas atlas;
    Stage stage;

    BitmapFont alice_96_69AA35_stroke_5_2F5313;
    BitmapFont alice_96_000000_stroke_2_000000;
    BitmapFont alice_48_000000_stroke_1_000000;



    public PlantScreen(Game game){
        this.game = game;
        box_last_update = 1;

    }

    @Override
    public void show() {
        stage = new Stage(new ExtendViewport(1080, 1920));

        atlas = PotResources.getAtlas();
        skin = PotResources.getSkin();
        Gdx.input.setInputProcessor(stage);

        alice_96_69AA35_stroke_5_2F5313 = PlantResources.getAlice_96_69AA35_stroke_5_2F5313();
        alice_96_000000_stroke_2_000000 = PlantResources.getAlice_96_000000_stroke_2_000000();
        alice_48_000000_stroke_1_000000 = PlantResources.getAlice_48_000000_stroke_1_000000();

        Image background = new Image(atlas.findRegion("background"));
        background.setBounds(0, 0, stage.getWidth(), stage.getHeight());
        background.setName("background");
        stage.addActor(background);

        stage.addActor(generate_plant_pane());
        stage.addActor(generate_flower_pane());
        stage.addActor(generate_leaves_pane());
        stage.addActor(generate_roots_pane());
        stage.addActor(generate_buttons_pane());
    }

    @Override
    public void render(float delta) {




        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

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

    private Group generate_plant_pane(){
        Group out = new Group();
        out.setName("plant_pane");

        if(Box.getInstance().getPlant()==null){
            Image background = new Image(atlas.findRegion("plant_empty"));
            background.setPosition(0, 0);
            out.addActor(background);
            return out;
        }


        Image background = new Image(atlas.findRegion("plant_pane"));
        background.setPosition(0, 0);
        out.addActor(background);

        Image day_bar;


        if(Box.getInstance().getPlant().get_percent_day()>10){
            day_bar = new Image(atlas.findRegion("day_0_bar"));
        }else if(Box.getInstance().getPlant().get_percent_day()>=10&&Box.getInstance().getPlant().get_percent_day()<20){
            day_bar = new Image(atlas.findRegion("day_10_bar"));
        }else if(Box.getInstance().getPlant().get_percent_day()>=20&&Box.getInstance().getPlant().get_percent_day()<30){
            day_bar = new Image(atlas.findRegion("day_20_bar"));
        }else if(Box.getInstance().getPlant().get_percent_day()>=30&&Box.getInstance().getPlant().get_percent_day()<40){
            day_bar = new Image(atlas.findRegion("day_30_bar"));
        }else if(Box.getInstance().getPlant().get_percent_day()>=40&&Box.getInstance().getPlant().get_percent_day()<50){
            day_bar = new Image(atlas.findRegion("day_40_bar"));
        }else if(Box.getInstance().getPlant().get_percent_day()>=50&&Box.getInstance().getPlant().get_percent_day()<60){
            day_bar = new Image(atlas.findRegion("day_50_bar"));
        }else if(Box.getInstance().getPlant().get_percent_day()>=60&&Box.getInstance().getPlant().get_percent_day()<70){
            day_bar = new Image(atlas.findRegion("day_60_bar"));
        }else if(Box.getInstance().getPlant().get_percent_day()>=70&&Box.getInstance().getPlant().get_percent_day()<80){
            day_bar = new Image(atlas.findRegion("day_70_bar"));
        }else if(Box.getInstance().getPlant().get_percent_day()>=80&&Box.getInstance().getPlant().get_percent_day()<90){
            day_bar = new Image(atlas.findRegion("day_80_bar"));
        }else if(Box.getInstance().getPlant().get_percent_day()>=90&&Box.getInstance().getPlant().get_percent_day()<100){
            day_bar = new Image(atlas.findRegion("day_90_bar"));
        }else if(Box.getInstance().getPlant().get_percent_day()>=100){
            day_bar = new Image(atlas.findRegion("day_100_bar"));
        }else{
            day_bar = new Image(atlas.findRegion("day_0_bar"));
        }

        day_bar.setName("plant_day_bar");
        day_bar.setPosition(0, 0);
        out.addActor(day_bar);

        Label.LabelStyle seed_stage_style = new Label.LabelStyle();
        seed_stage_style.font = alice_48_000000_stroke_1_000000;
        Label seed_stage_label = new Label(
                Box.getInstance().getPlant().getSeed_remain() + "",
                seed_stage_style
        );
        seed_stage_label.setAlignment(Align.center);
        seed_stage_label.setName("seed_stage_label");
        seed_stage_label.setWrap(true);
        seed_stage_label.setBounds(0, 100, 135, 100);
        out.addActor(seed_stage_label);

        Label.LabelStyle pre_vegetation_stage_style = new Label.LabelStyle();
        pre_vegetation_stage_style.font = alice_48_000000_stroke_1_000000;
        Label pre_vegetation_stage_label = new Label(
                Box.getInstance().getPlant().getPre_vegetation_remain() + "",
                pre_vegetation_stage_style
        );
        pre_vegetation_stage_label.setAlignment(Align.center);
        pre_vegetation_stage_label.setName("pre_vegetation_stage_label");
        pre_vegetation_stage_label.setWrap(true);
        pre_vegetation_stage_label.setBounds(0+(135*1), 100, 135, 100);
        out.addActor(pre_vegetation_stage_label);

        Label.LabelStyle vegetation_stage_style = new Label.LabelStyle();
        vegetation_stage_style.font = alice_48_000000_stroke_1_000000;
        Label vegetation_stage_label = new Label(
                Box.getInstance().getPlant().getVegetation_remain() + "",
                vegetation_stage_style
        );
        vegetation_stage_label.setAlignment(Align.center);
        vegetation_stage_label.setName("vegetation_stage_label");
        vegetation_stage_label.setWrap(true);
        vegetation_stage_label.setBounds(0+(135*2), 100, 135, 100);
        out.addActor(vegetation_stage_label);

        Label.LabelStyle post_vegetation_stage_style = new Label.LabelStyle();
        post_vegetation_stage_style.font = alice_48_000000_stroke_1_000000;
        Label post_vegetation_stage_label = new Label(
                Box.getInstance().getPlant().getPost_vegetation_remain() + "",
                post_vegetation_stage_style
        );
        post_vegetation_stage_label.setAlignment(Align.center);
        post_vegetation_stage_label.setName("post_vegetation_stage_label");
        post_vegetation_stage_label.setWrap(true);
        post_vegetation_stage_label.setBounds(0+(135*3), 100, 135, 100);
        out.addActor(post_vegetation_stage_label);

        Label.LabelStyle pre_bloom_stage_style = new Label.LabelStyle();
        pre_bloom_stage_style.font = alice_48_000000_stroke_1_000000;
        Label pre_bloom_stage_label = new Label(
                Box.getInstance().getPlant().getPre_bloom_remain() + "",
                pre_bloom_stage_style
        );
        pre_bloom_stage_label.setAlignment(Align.center);
        pre_bloom_stage_label.setName("pre_bloom_stage_label");
        pre_bloom_stage_label.setWrap(true);
        pre_bloom_stage_label.setBounds(0+(135*4), 100, 135, 100);
        out.addActor(pre_bloom_stage_label);

        Label.LabelStyle bloom_stage_style = new Label.LabelStyle();
        bloom_stage_style.font = alice_48_000000_stroke_1_000000;
        Label bloom_stage_label = new Label(
                Box.getInstance().getPlant().getBloom_remain() + "",
                bloom_stage_style
        );
        bloom_stage_label.setAlignment(Align.center);
        bloom_stage_label.setName("bloom_stage_label");
        bloom_stage_label.setWrap(true);
        bloom_stage_label.setBounds(0+(135*5), 100, 135, 100);
        out.addActor(bloom_stage_label);

        Label.LabelStyle post_bloom_stage_style = new Label.LabelStyle();
        post_bloom_stage_style.font = alice_48_000000_stroke_1_000000;
        Label post_bloom_stage_label = new Label(
                Box.getInstance().getPlant().getPost_bloom_remain() + "",
                post_bloom_stage_style
        );
        post_bloom_stage_label.setAlignment(Align.center);
        post_bloom_stage_label.setName("post_bloom_stage_label");
        post_bloom_stage_label.setWrap(true);
        post_bloom_stage_label.setBounds(0+(135*6), 100, 135, 100);
        out.addActor(post_bloom_stage_label);


        int all_stages_remain=
                Box.getInstance().getPlant().getSeed_remain()+
                        Box.getInstance().getPlant().getPre_vegetation_remain()+
                        Box.getInstance().getPlant().getVegetation_remain()+
                        Box.getInstance().getPlant().getPost_vegetation_remain()+
                        Box.getInstance().getPlant().getPre_bloom_remain()+
                        Box.getInstance().getPlant().getBloom_remain()+
                        Box.getInstance().getPlant().getPost_bloom_remain();

        int minutes = 0;
        int seconds = 0;

        minutes = all_stages_remain/60;
        seconds = all_stages_remain-(minutes*60);

        Label.LabelStyle all_stages_style = new Label.LabelStyle();
        all_stages_style.font = alice_48_000000_stroke_1_000000;
        Label all_stages_label = new Label(
                 minutes+ ":"+seconds,
                all_stages_style
        );
        all_stages_label.setAlignment(Align.center);
        all_stages_label.setName("all_stages_label");
        all_stages_label.setWrap(true);
        all_stages_label.setBounds(0+(135*7), 100, 135, 100);
        out.addActor(all_stages_label);

        ImageButton kill_button = new ImageButton(skin, "kill_button");
        kill_button.setPosition(15, 15);
        kill_button.setName("kill_button");
        kill_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                kill_button_clicked();
            }
        });
        out.addActor(kill_button);






        return out;
    }

    private void kill_button_clicked(){

    }

}
