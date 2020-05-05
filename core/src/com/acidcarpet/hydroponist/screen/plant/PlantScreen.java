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
        kill_button.setPosition(0, 200);
        kill_button.setName("kill_button");
        kill_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                kill_button_clicked();
            }
        });
        out.addActor(kill_button);


        ImageButton harvest_button = new ImageButton(skin, "harvest_button");
        harvest_button.setPosition(1080-250, 200);
        harvest_button.setName("harvest_button");
        harvest_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                harvest_button_clicked();
            }
        });

        if(all_stages_remain>0) harvest_button.setDisabled(true);
        else harvest_button.setDisabled(false);

        out.addActor(harvest_button);

        Image hp_bar;
        if(Box.getInstance().getPlant().get_percent_hp()>10){
            hp_bar = new Image(atlas.findRegion("hp_0_bar"));
        }else if(Box.getInstance().getPlant().get_percent_hp()>=10&&Box.getInstance().getPlant().get_percent_hp()<20){
            hp_bar = new Image(atlas.findRegion("hp_10_bar"));
        }else if(Box.getInstance().getPlant().get_percent_hp()>=20&&Box.getInstance().getPlant().get_percent_hp()<30){
            hp_bar = new Image(atlas.findRegion("hp_20_bar"));
        }else if(Box.getInstance().getPlant().get_percent_hp()>=30&&Box.getInstance().getPlant().get_percent_hp()<40){
            hp_bar = new Image(atlas.findRegion("hp_30_bar"));
        }else if(Box.getInstance().getPlant().get_percent_hp()>=40&&Box.getInstance().getPlant().get_percent_hp()<50){
            hp_bar = new Image(atlas.findRegion("hp_40_bar"));
        }else if(Box.getInstance().getPlant().get_percent_hp()>=50&&Box.getInstance().getPlant().get_percent_hp()<60){
            hp_bar = new Image(atlas.findRegion("hp_50_bar"));
        }else if(Box.getInstance().getPlant().get_percent_hp()>=60&&Box.getInstance().getPlant().get_percent_hp()<70){
            hp_bar = new Image(atlas.findRegion("hp_60_bar"));
        }else if(Box.getInstance().getPlant().get_percent_hp()>=70&&Box.getInstance().getPlant().get_percent_hp()<80){
            hp_bar = new Image(atlas.findRegion("hp_70_bar"));
        }else if(Box.getInstance().getPlant().get_percent_hp()>=80&&Box.getInstance().getPlant().get_percent_hp()<90){
            hp_bar = new Image(atlas.findRegion("hp_80_bar"));
        }else if(Box.getInstance().getPlant().get_percent_hp()>=90&&Box.getInstance().getPlant().get_percent_hp()<100){
            hp_bar = new Image(atlas.findRegion("hp_90_bar"));
        }else if(Box.getInstance().getPlant().get_percent_hp()>=100){
            hp_bar = new Image(atlas.findRegion("hp_100_bar"));
        }else{
            hp_bar = new Image(atlas.findRegion("hp_0_bar"));
        }

        day_bar.setName("plant_day_bar");
        day_bar.setPosition(0, 660-100);
        out.addActor(day_bar);

        Image macro_primary;
        Image macro_secondary;
        Image micro_primary;
        Image micro_secondary;

        switch (Box.getInstance().getPlant().current_macro_primary()){
            case N: macro_primary =  new Image(atlas.findRegion("element_N"));
            case P: macro_primary =  new Image(atlas.findRegion("element_P"));
            case K: macro_primary =  new Image(atlas.findRegion("element_K"));
            default: macro_primary =  new Image(atlas.findRegion("element_Empty"));
        }
        switch (Box.getInstance().getPlant().current_macro_secondary()){
            case S: macro_secondary =  new Image(atlas.findRegion("element_S"));
            case Mg: macro_secondary =  new Image(atlas.findRegion("element_Mg"));
            case Ca: macro_secondary =  new Image(atlas.findRegion("element_Ca"));
            default: macro_secondary =  new Image(atlas.findRegion("element_Empty"));
        }
        switch (Box.getInstance().getPlant().current_micro_primary()){
            case B: micro_primary =  new Image(atlas.findRegion("element_B"));
            case Cu: micro_primary =  new Image(atlas.findRegion("element_Cu"));
            case Fe: micro_primary =  new Image(atlas.findRegion("element_Fe"));
            default: micro_primary =  new Image(atlas.findRegion("element_acid"));
        }
        switch (Box.getInstance().getPlant().current_micro_secondary()){
            case Mn: micro_secondary =  new Image(atlas.findRegion("element_Mn"));
            case Mo: micro_secondary =  new Image(atlas.findRegion("element_Mo"));
            case Zn: micro_secondary =  new Image(atlas.findRegion("element_Zn"));
            default: micro_secondary =  new Image(atlas.findRegion("element_alcaline"));
        }

        macro_primary.setPosition((1080/2)-300, 660-100-100);
        macro_secondary.setPosition((1080/2)-150, 660-100-100);
        micro_primary.setPosition((1080/2), 660-100-100);
        micro_secondary.setPosition((1080/2)+150, 660-100-100);

        out.addActor(macro_primary);
        out.addActor(macro_secondary);
        out.addActor(micro_primary);
        out.addActor(micro_secondary);

        Label.LabelStyle name_label_style = new Label.LabelStyle();
        name_label_style.font = alice_96_69AA35_stroke_5_2F5313;
        Label name_label = new Label(
                Box.getInstance().getPlant().get_name(),
                name_label_style
        );
        name_label.setAlignment(Align.center);
        name_label.setName("name_label");
        name_label.setWrap(true);
        name_label.setBounds(0, 280, 1080, 180);
        out.addActor(name_label);


        return out;
    }

    private Group generate_flower_pane(){
        Group out = new Group();
        out.setName("flower_pane");

        if(Box.getInstance().getPlant()==null||Box.getInstance().getPlant().getFlowers().isEmpty()){
            Image background = new Image(atlas.findRegion("flower_empty"));
            background.setPosition(0, 0);
            out.addActor(background);
            return out;
        }

        Image background = new Image(atlas.findRegion("flower_pane"));
        background.setPosition(0, 0);
        out.addActor(background);

        Image type_bar;
        switch (Box.getInstance().getPlant().getFlowersType()){
            case NUT: type_bar = new Image(atlas.findRegion("nut_bar"));
                break;
            case BACA: type_bar = new Image(atlas.findRegion("baca_bar"));
                break;
            case FLOS: type_bar = new Image(atlas.findRegion("flos_bar"));
                break;
            case FRUCTUS: type_bar = new Image(atlas.findRegion("fructus_bar"));
                break;
            case SPINAM: type_bar = new Image(atlas.findRegion("spinam_bar"));
                break;
            default:
               type_bar =  new Image(atlas.findRegion("nut_bar"));
        }
        type_bar.setPosition(0, 0);
        out.addActor(type_bar);

        Image day_bar;
       if(Box.getInstance().getPlant().getFlowersType().getLight_energy_consumption()<10){
           day_bar = new Image(atlas.findRegion("flower_day_0_bar"));
       }else if(Box.getInstance().getPlant().getFlowersType().getLight_energy_consumption()>=10||
               Box.getInstance().getPlant().getFlowersType().getLight_energy_consumption()<20){
           day_bar = new Image(atlas.findRegion("flower_day_10_bar"));
       }else if(Box.getInstance().getPlant().getFlowersType().getLight_energy_consumption()>=20||
               Box.getInstance().getPlant().getFlowersType().getLight_energy_consumption()<30){
           day_bar = new Image(atlas.findRegion("flower_day_20_bar"));
       }else if(Box.getInstance().getPlant().getFlowersType().getLight_energy_consumption()>=30||
               Box.getInstance().getPlant().getFlowersType().getLight_energy_consumption()<40){
           day_bar = new Image(atlas.findRegion("flower_day_30_bar"));
       }else if(Box.getInstance().getPlant().getFlowersType().getLight_energy_consumption()>=40||
               Box.getInstance().getPlant().getFlowersType().getLight_energy_consumption()<50){
           day_bar = new Image(atlas.findRegion("flower_day_40_bar"));
       }else if(Box.getInstance().getPlant().getFlowersType().getLight_energy_consumption()>=50||
               Box.getInstance().getPlant().getFlowersType().getLight_energy_consumption()<60){
           day_bar = new Image(atlas.findRegion("flower_day_50_bar"));
       }else if(Box.getInstance().getPlant().getFlowersType().getLight_energy_consumption()>=60||
               Box.getInstance().getPlant().getFlowersType().getLight_energy_consumption()<70){
           day_bar = new Image(atlas.findRegion("flower_day_60_bar"));
       }else if(Box.getInstance().getPlant().getFlowersType().getLight_energy_consumption()>=70||
               Box.getInstance().getPlant().getFlowersType().getLight_energy_consumption()<80){
           day_bar = new Image(atlas.findRegion("flower_day_70_bar"));
       }else if(Box.getInstance().getPlant().getFlowersType().getLight_energy_consumption()>=80||
               Box.getInstance().getPlant().getFlowersType().getLight_energy_consumption()<90){
           day_bar = new Image(atlas.findRegion("flower_day_80_bar"));
       }else if(Box.getInstance().getPlant().getFlowersType().getLight_energy_consumption()>=90||
               Box.getInstance().getPlant().getFlowersType().getLight_energy_consumption()<100){
           day_bar = new Image(atlas.findRegion("flower_day_90_bar"));
       }else {
           day_bar = new Image(atlas.findRegion("flower_day_100_bar"));
       }
        day_bar.setPosition(1080-300, 500-150);
        out.addActor(day_bar);


        Label.LabelStyle numerus_label_style = new Label.LabelStyle();
        numerus_label_style.font = alice_96_000000_stroke_2_000000;
        Label numerus_label = new Label(
                Box.getInstance().getPlant().flower_numerus()+"",
                numerus_label_style
        );
        numerus_label.setAlignment(Align.center);
        numerus_label.setName("numerus_label");
        numerus_label.setWrap(true);
        numerus_label.setBounds(0, 100, 300, 150);
        out.addActor(numerus_label);

        Label.LabelStyle melius_label_style = new Label.LabelStyle();
        melius_label_style.font = alice_96_000000_stroke_2_000000;
        Label melius_label = new Label(
                Box.getInstance().getPlant().flower_melius()+"",
                melius_label_style
        );
        melius_label.setAlignment(Align.center);
        melius_label.setName("melius_label");
        melius_label.setWrap(true);
        melius_label.setBounds(1080-300, 100, 300, 150);
        out.addActor(melius_label);

        Label.LabelStyle coin_label_style = new Label.LabelStyle();
        coin_label_style.font = alice_96_000000_stroke_2_000000;
        Label coin_label = new Label(
                Box.getInstance().getPlant().flower_coin()+"",
                coin_label_style
        );
        coin_label.setAlignment(Align.center);
        coin_label.setName("coin_label");
        coin_label.setWrap(true);
        coin_label.setBounds(0, 500-150, 150, 150);
        out.addActor(coin_label);

        Label.LabelStyle diamond_label_style = new Label.LabelStyle();
        diamond_label_style.font = alice_96_000000_stroke_2_000000;
        Label diamond_label = new Label(
                Box.getInstance().getPlant().flower_diamond()+"",
                diamond_label_style
        );
        diamond_label.setAlignment(Align.center);
        diamond_label.setName("diamond_label");
        diamond_label.setWrap(true);
        diamond_label.setBounds(150, 500-150, 150, 150);
        out.addActor(diamond_label);

        return out;
    }

    private Group generate_leaves_pane(){
        Group out = new Group();
        out.setName("leave_pane");

        if(Box.getInstance().getPlant()==null||Box.getInstance().getPlant().getLeaves().isEmpty()){
            Image background = new Image(atlas.findRegion("leave_empty"));
            background.setPosition(0, 0);
            out.addActor(background);
            return out;
        }

        Image background = new Image(atlas.findRegion("leave_pane"));
        background.setPosition(0, 0);
        out.addActor(background);

        Label.LabelStyle numerus_label_style = new Label.LabelStyle();
        numerus_label_style.font = alice_96_000000_stroke_2_000000;
        Label numerus_label = new Label(
                Box.getInstance().getPlant().leave_numerus()+"",
                numerus_label_style
        );
        numerus_label.setAlignment(Align.center);
        numerus_label.setName("numerus_label");
        numerus_label.setWrap(true);
        numerus_label.setBounds(0, 100, 300, 150);
        out.addActor(numerus_label);

        Label.LabelStyle regio_label_style = new Label.LabelStyle();
        regio_label_style.font = alice_96_000000_stroke_2_000000;
        Label regio_label = new Label(
                Box.getInstance().getPlant().leave_regio()+"",
                regio_label_style
        );
        regio_label.setAlignment(Align.center);
        regio_label.setName("regio_label");
        regio_label.setWrap(true);
        regio_label.setBounds(1080-300, 100, 300, 150);
        out.addActor(regio_label);

        Label.LabelStyle dark_label_style = new Label.LabelStyle();
        dark_label_style.font = alice_96_000000_stroke_2_000000;
        Label dark_label = new Label(
                Box.getInstance().getPlant().getLeavesType().getDark_energy()+"",
                dark_label_style
        );
        dark_label.setAlignment(Align.center);
        dark_label.setName("dark_label");
        dark_label.setWrap(true);
        dark_label.setBounds(0, 500-150, 150, 150);
        out.addActor(dark_label);

        Label.LabelStyle light_label_style = new Label.LabelStyle();
        light_label_style.font = alice_96_000000_stroke_2_000000;
        Label light_label = new Label(
                Box.getInstance().getPlant().getLeavesType().getLight_energy()+"",
                light_label_style
        );
        light_label.setAlignment(Align.center);
        light_label.setName("light_label");
        light_label.setWrap(true);
        light_label.setBounds(150, 500-150, 150, 150);
        out.addActor(light_label);

        Label.LabelStyle minimum_t_label_style = new Label.LabelStyle();
        minimum_t_label_style.font = alice_96_000000_stroke_2_000000;
        Label minimum_t_label = new Label(
                Box.getInstance().getPlant().getLeavesType().getMin_temperature()+"",
                minimum_t_label_style
        );
        minimum_t_label.setAlignment(Align.center);
        minimum_t_label.setName("minimum_t_label");
        minimum_t_label.setWrap(true);
        minimum_t_label.setBounds(1080-150-150, 500-150, 150, 150);
        out.addActor(minimum_t_label);

        Label.LabelStyle maximum_t_label_style = new Label.LabelStyle();
        maximum_t_label_style.font = alice_96_000000_stroke_2_000000;
        Label maximum_t_label = new Label(
                Box.getInstance().getPlant().getLeavesType().getMax_temperature()+"",
                maximum_t_label_style
        );
        maximum_t_label.setAlignment(Align.center);
        maximum_t_label.setName("maximum_t_label");
        maximum_t_label.setWrap(true);
        maximum_t_label.setBounds(1080-150, 500-150, 150, 150);
        out.addActor(maximum_t_label);

        Image type_bar;

        switch (Box.getInstance().getPlant().getLeavesType()){
            case VERY_HIGH: type_bar = new Image(atlas.findRegion("leave_very_long_bar")); break;
            case HIGH:type_bar = new Image(atlas.findRegion("leave_long_bar")); break;
            case NORMAL:type_bar = new Image(atlas.findRegion("leave_normal_bar")); break;
            case WIDE:type_bar = new Image(atlas.findRegion("leave_wide_bar")); break;
            default:type_bar = new Image(atlas.findRegion("leave_very_wide_bar")); break;
        }

        type_bar.setPosition(0, 0);
        out.addActor(type_bar);

        return out;

    }

    public Group generate_roots_pane(){
        Group out = new Group();
        out.setName("root_pane");

        if(Box.getInstance().getPlant()==null||Box.getInstance().getPlant().getLeaves().isEmpty()){
            Image background = new Image(atlas.findRegion("root_empty"));
            background.setPosition(0, 0);
            out.addActor(background);
            return out;
        }

        Image background = new Image(atlas.findRegion("root_pane"));
        background.setPosition(0, 0);
        out.addActor(background);

        Image type_bar;
        switch (Box.getInstance().getPlant().getRootsType()){
            case PIVOTAL: type_bar = new Image(atlas.findRegion("root_p_0_bar"));
            case P_1:type_bar = new Image(atlas.findRegion("root_p_1_bar"));
            case P_2:type_bar = new Image(atlas.findRegion("root_p_2_bar"));
            case P_3:type_bar = new Image(atlas.findRegion("root_p_3_bar"));
            case P_4:type_bar = new Image(atlas.findRegion("root_p_4_bar"));
            case F_4:type_bar = new Image(atlas.findRegion("root_f_4_bar"));
            case F_3:type_bar = new Image(atlas.findRegion("root_f_3_bar"));
            case F_2:type_bar = new Image(atlas.findRegion("root_f_2_bar"));
            case F_1:type_bar = new Image(atlas.findRegion("root_f_1_bar"));
            default: type_bar = new Image(atlas.findRegion("root_f_0_bar"));
        }
        type_bar.setPosition(0, 0);
        out.addActor(type_bar);

        Label.LabelStyle minimum_ph_label_style = new Label.LabelStyle();
        minimum_ph_label_style.font = alice_96_000000_stroke_2_000000;
        Label minimum_ph_label = new Label(
                Box.getInstance().getPlant().getRootsType().getPh_min()+"",
                minimum_ph_label_style
        );
        minimum_ph_label.setAlignment(Align.center);
        minimum_ph_label.setName("minimum_ph_label");
        minimum_ph_label.setWrap(true);
        minimum_ph_label.setBounds(1080-150-150, 500-150, 150, 150);
        out.addActor(minimum_ph_label);

        Label.LabelStyle maximum_ph_label_style = new Label.LabelStyle();
        maximum_ph_label_style.font = alice_96_000000_stroke_2_000000;
        Label maximum_ph_label = new Label(
                Box.getInstance().getPlant().getRootsType().getPh_max()+"",
                maximum_ph_label_style
        );
        maximum_ph_label.setAlignment(Align.center);
        maximum_ph_label.setName("maximum_ph_label");
        maximum_ph_label.setWrap(true);
        maximum_ph_label.setBounds(1080-150, 500-150, 150, 150);
        out.addActor(maximum_ph_label);


        Label.LabelStyle prima_label_style = new Label.LabelStyle();
        prima_label_style.font = alice_96_000000_stroke_2_000000;
        Label prima_label = new Label(
                Box.getInstance().getPlant().root_prima()+"",
                prima_label_style
        );
        prima_label.setAlignment(Align.center);
        prima_label.setName("prima_label");
        prima_label.setWrap(true);
        prima_label.setBounds(0, 100, 300, 150);
        out.addActor(prima_label);

        Label.LabelStyle latus_label_style = new Label.LabelStyle();
        latus_label_style.font = alice_96_000000_stroke_2_000000;
        Label latus_label = new Label(
                Box.getInstance().getPlant().root_latus()+"",
                latus_label_style
        );
        latus_label.setAlignment(Align.center);
        latus_label.setName("latus_label");
        latus_label.setWrap(true);
        latus_label.setBounds(1080-300, 100, 300, 150);
        out.addActor(latus_label);


        Label.LabelStyle water_label_style = new Label.LabelStyle();
        water_label_style.font = alice_96_000000_stroke_2_000000;
        Label water_label = new Label(
                Box.getInstance().getPlant().root_water()+"",
                water_label_style
        );
        water_label.setAlignment(Align.center);
        water_label.setName("water_label");
        water_label.setWrap(true);
        water_label.setBounds(0, 500-150, 300, 150);
        out.addActor(water_label);

        return out;

    }
    private Group generate_buttons_pane(){
        Group out = new Group();

        Image background = new Image(atlas.findRegion("buttons_background"));
        background.setPosition(0 , 0);
        background.setName("buttons_background");
        out.addActor(background);

        ImageButton back_button = new ImageButton(skin, "back_button");
        back_button.setPosition(1080/2-560/2, 20);
        back_button.setName("back_button");
        back_button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                back_button_click();
            }
        });
        out.addActor(back_button);

        out.setName("buttons_pane");
        out.setPosition(40, 0);
        return out;
    }
    private void kill_button_clicked(){

    }
    private void harvest_button_clicked(){

    }
    private void back_button_click(){
        
    }

}
