package com.acidcarpet.hydroponist.screen.shop;

import com.acidcarpet.hydroponist.screen.box.BoxScreen;
import com.acidcarpet.hydroponist.storage.Inventory;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class ShopScreen implements Screen {

    long last_update;

    Game game;

    Skin skin;
    TextureAtlas atlas;
    Stage stage;

     BitmapFont alice_150_F6EB86_stroke_5_9A8C0D; // Gold Big
     BitmapFont alice_150_7BEFE6_stroke_5_089086; // Diamond Big

     BitmapFont alice_64_F6EB86_stroke_5_9A8C0D; // Gold Small
     BitmapFont alice_64_7BEFE6_stroke_5_089086; // Diamond Small
     BitmapFont alice_64_AFAFAF_stroke_5_444444; // Grey Small

     BitmapFont alice_48_392200; // Brown Title
     BitmapFont alice_24_392200; // Brown Description

    public ShopScreen(Game game){
        this.game = game;
        last_update = 1;

    }
    @Override
    public void show() {
        stage = new Stage(new ExtendViewport(1080, 1920));

        atlas = ShopResources.getAtlas();
        skin = ShopResources.getSkin();
        Gdx.input.setInputProcessor(stage);

        alice_150_F6EB86_stroke_5_9A8C0D= ShopResources.getAlice_150_F6EB86_stroke_5_9A8C0D();
        alice_150_7BEFE6_stroke_5_089086=ShopResources.getAlice_150_7BEFE6_stroke_5_089086();
        alice_64_F6EB86_stroke_5_9A8C0D=ShopResources.getAlice_64_F6EB86_stroke_5_9A8C0D();
        alice_64_7BEFE6_stroke_5_089086=ShopResources.getAlice_64_7BEFE6_stroke_5_089086();
        alice_64_AFAFAF_stroke_5_444444=ShopResources.getAlice_64_AFAFAF_stroke_5_444444();
        alice_48_392200=ShopResources.getAlice_48_392200();
        alice_24_392200=ShopResources.getAlice_24_392200();

        Image background = new Image(atlas.findRegion("background"));
        background.setBounds(0, 0, stage.getWidth(), stage.getHeight());
        background.setName("background");
        stage.addActor(background);

        stage.addActor(generate_resources_pane());
        stage.addActor(generate_items_pane());
        stage.addActor(generate_buttons_pane());

    }

    @Override
    public void render(float delta) {

        if(last_update!=Inventory.last_update()){

            try{    stage.getRoot().findActor("resources_pane").clearListeners();                }catch (Exception e){ System.out.println(e.getMessage());}
            try{    stage.getRoot().removeActor(stage.getRoot().findActor("resources_pane"));    }catch (Exception e){ System.out.println(e.getMessage());}
            try{    stage.getRoot().findActor("items_pane").clearListeners();                    }catch (Exception e){ System.out.println(e.getMessage());}
            try{    stage.getRoot().removeActor(stage.getRoot().findActor("items_pane"));        }catch (Exception e){ System.out.println(e.getMessage());}
            try{    stage.getRoot().findActor("buttons_pane").clearListeners();                  }catch (Exception e){ System.out.println(e.getMessage());}
            try{    stage.getRoot().removeActor(stage.getRoot().findActor("buttons_pane"));      }catch (Exception e){ System.out.println(e.getMessage());}

            try{    stage.addActor(generate_resources_pane());                                          }catch (Exception e){ System.out.println(e.getMessage());}
            try{    stage.addActor(generate_items_pane());                                              }catch (Exception e){ System.out.println(e.getMessage());}
            try{    stage.addActor(generate_buttons_pane());                                            }catch (Exception e){ System.out.println(e.getMessage());}


            last_update = Inventory.last_update();
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
        stage.dispose();
    }

    public Group generate_resources_pane(){
        Group out = new Group();

        Image background = new Image(atlas.findRegion("resources_background"));
        background.setPosition(0, 0);
        background.setName("resources_background");
        out.addActor(background);

        Image coin_pane = new Image(atlas.findRegion("coin_pane"));
        coin_pane.setPosition(0, 0);
        coin_pane.setName("coin_pane");
        out.addActor(coin_pane);

        Image diamond_pane = new Image(atlas.findRegion("diamond_pane"));
        diamond_pane.setPosition(540, 0);
        diamond_pane.setName("diamond_pane");
        out.addActor(diamond_pane);

        Label.LabelStyle coin_labelStyle = new Label.LabelStyle();
        coin_labelStyle.font = alice_150_F6EB86_stroke_5_9A8C0D;
        Label coin_label = new Label(
                Inventory.getInstance().getGold() + "",
                coin_labelStyle
        );
        coin_label.setAlignment(Align.center);
        coin_label.setName("coin_label");
        coin_label.setWrap(false);
        coin_label.setBounds(0, 0, 540, 150);
        out.addActor(coin_label);

        Label.LabelStyle diamond_labelStyle = new Label.LabelStyle();
        diamond_labelStyle.font = alice_150_7BEFE6_stroke_5_089086;
        Label diamond_label = new Label(
                Inventory.getInstance().getDiamond() + "",
                diamond_labelStyle
        );
        diamond_label.setAlignment(Align.center);
        diamond_label.setName("diamond_label");
        diamond_label.setWrap(false);
        diamond_label.setBounds(540, 0, 540, 150);
        out.addActor(diamond_label);


        out.setPosition(40+0, 1920-150);
        out.setName("resources_pane");

        return out;

    }

    public Group generate_items_pane(){
        Group out = new Group();

        Image background = new Image(atlas.findRegion("items_background"));
        background.setPosition(0, 0);
        background.setName("items_background");
        out.addActor(background);

        Table table = new Table();
        table.defaults().width(1080).height(200);

        for(EquipOffer current_Equip_offer : EquipShop.getInstance().getEquipOffers()){
            table.add(generate_item(current_Equip_offer));
            table.row();
        }

        ScrollPane pane = new ScrollPane(table);
        pane.setScrollingDisabled(true, false);
        pane.setBounds(0 ,0 ,1080 , 1610);
        out.addActor(pane);

        out.setName("items_pane");
        out.setPosition(0+40, 160);

        return out;
    }
    public Group generate_item(final EquipOffer equipOffer){
        Group out = new Group();

        Image background = new Image(atlas.findRegion("item_pane"));
        background.setPosition(0, 0);
        background.setName("item_pane");
        out.addActor(background);



        TextButton.TextButtonStyle coin_buttonStyle = new TextButton.TextButtonStyle();
        coin_buttonStyle.font = alice_64_F6EB86_stroke_5_9A8C0D;
        coin_buttonStyle.up = new TextureRegionDrawable(atlas.findRegion("coin_buy_button_enable"));
        coin_buttonStyle.down = new TextureRegionDrawable(atlas.findRegion("coin_buy_button_pressed"));
        coin_buttonStyle.disabled = new TextureRegionDrawable(atlas.findRegion("coin_buy_button_disable"));
        TextButton coin_buy_button = new TextButton(equipOffer.getCoin_price()+"", coin_buttonStyle);
        coin_buy_button.setBounds(1080-15-200, 200-15-80, 200, 80);
        coin_buy_button.setName("coin_buy_button");
        if(equipOffer.may_buy_coin()){
            coin_buy_button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    coin_buy_button_clicked(equipOffer);
                }
            });
            coin_buy_button.setDisabled(false);
        }else{
            coin_buy_button.setDisabled(true);
        }
        out.addActor(coin_buy_button);

        TextButton.TextButtonStyle diamond_buttonStyle = new TextButton.TextButtonStyle();
        diamond_buttonStyle.font = alice_64_F6EB86_stroke_5_9A8C0D;
        diamond_buttonStyle.up = new TextureRegionDrawable(atlas.findRegion("diamond_buy_button_enable"));
        diamond_buttonStyle.down = new TextureRegionDrawable(atlas.findRegion("diamond_buy_button_pressed"));
        diamond_buttonStyle.disabled = new TextureRegionDrawable(atlas.findRegion("diamond_buy_button_disable"));
        TextButton diamond_buy_button = new TextButton(equipOffer.getDiamond_price()+"",diamond_buttonStyle);
        diamond_buy_button.setBounds(1080-15-200, 15, 200, 80);
        diamond_buy_button.setName("diamond_buy_button");
        if(equipOffer.may_buy_diamond()){
            diamond_buy_button.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    diamond_buy_button_clicked(equipOffer);
                }
            });
            diamond_buy_button.setDisabled(false);
        }else{
            diamond_buy_button.setDisabled(true);
        }
        out.addActor(diamond_buy_button);


        Label.LabelStyle title_labelStyle = new Label.LabelStyle();
        title_labelStyle.font = alice_48_392200;
        Label coin_label = new Label(
                equipOffer.getTitle() + "",
                title_labelStyle
        );
        coin_label.setAlignment(Align.center);
        coin_label.setName("title_label");
        coin_label.setWrap(true);
        coin_label.setBounds(15+170, 200-15-55, 680, 55);
        out.addActor(coin_label);

        Label.LabelStyle description_labelStyle = new Label.LabelStyle();
        description_labelStyle.font = alice_24_392200;
        Label diamond_label = new Label(
                equipOffer.getDescription() + "",
                description_labelStyle
        );
        diamond_label.setAlignment(Align.center);
        diamond_label.setName("title_label");
        diamond_label.setWrap(true);
        diamond_label.setBounds(15+170, 15, 680, 125);
        out.addActor(diamond_label);

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

    public synchronized void coin_buy_button_clicked(EquipOffer equipOffer){
        equipOffer.buy_coin();
    }
    public synchronized void diamond_buy_button_clicked(EquipOffer equipOffer){
        equipOffer.buy_diamond();
    }
    public synchronized void back_button_click(){
        game.setScreen(new BoxScreen(game));
    }
}
