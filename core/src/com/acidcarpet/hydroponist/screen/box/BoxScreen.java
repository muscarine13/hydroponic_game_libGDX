package com.acidcarpet.hydroponist.screen.box;

import com.acidcarpet.hydroponist.equipment.Box;
import com.acidcarpet.hydroponist.screen.donat.DonatScreen;
import com.acidcarpet.hydroponist.screen.fan.FanScreen;
import com.acidcarpet.hydroponist.screen.lamp.LampScreen;
import com.acidcarpet.hydroponist.screen.deprecated.plant.PlantScreen;
import com.acidcarpet.hydroponist.screen.plant.PlantScreen;
import com.acidcarpet.hydroponist.screen.pot.PotScreen;
import com.acidcarpet.hydroponist.screen.pump.PumpScreen;
import com.acidcarpet.hydroponist.screen.seedling.SeedlingScreen;
import com.acidcarpet.hydroponist.screen.settings.SettingsScreen;
import com.acidcarpet.hydroponist.screen.shop.ShopScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import java.util.Date;

public class BoxScreen implements Screen {
    Game game;

    long last_update;

    Skin skin;
    TextureAtlas atlas;

    Stage stage;

    public BoxScreen(Game game){
        this.game = game;

        last_update = new Date().getTime();

    }

    @Override
    public void show() {
        stage = new Stage(new ExtendViewport(1080, 1920));

        atlas = BoxResources.getAtlas();
        skin = BoxResources.getSkin();

        Gdx.input.setInputProcessor(stage);

        Image background = new Image(atlas.findRegion("background"));
        background.setName("background");
        background.setBounds(0, 0, stage.getWidth(), stage.getHeight());

        stage.addActor(background);

    }

    @Override
    public void render(float delta) {

        if(last_update!=Box.get_last_update()){


            try {   stage.getRoot().findActor("pump").clearListeners();                         }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().removeActor(stage.getRoot().findActor("pump"));             }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().findActor("plant").clearListeners();                        }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().removeActor(stage.getRoot().findActor("plant"));            }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().findActor("pot").clearListeners();                          }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().removeActor(stage.getRoot().findActor("pot"));              }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().findActor("fan").clearListeners();                          }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().removeActor(stage.getRoot().findActor("fan"));              }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().findActor("lamp").clear();                                  }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().removeActor(stage.getRoot().findActor("lamp"));             }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().findActor("x3_button").clearListeners();                    }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().removeActor(stage.getRoot().findActor("x3_button"));        }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().findActor("shop_button").clearListeners();                  }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().removeActor(stage.getRoot().findActor("shop_button"));      }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().findActor("storage_button").clearListeners();               }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().removeActor(stage.getRoot().findActor("storage_button"));   }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().findActor("donation_button").clearListeners();              }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().removeActor(stage.getRoot().findActor("donation_button"));  }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().findActor("settings_button").clearListeners();              }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().removeActor(stage.getRoot().findActor("settings_button"));  }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().findActor("room_button").clearListeners();                  }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().removeActor(stage.getRoot().findActor("room_button"));      }catch (Exception e){e.printStackTrace();}


            try {   stage.getRoot().addActor( generate_pump());                                        }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().addActor( generate_plant());                                       }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().addActor( generate_pot());                                         }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().addActor( generate_fan());                                         }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().addActor( generate_lamp());                                        }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().addActor(generate_x3_button());                                    }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().addActor(generate_shop_button());                                  }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().addActor(generate_storage_button());                               }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().addActor(generate_donation_button());                              }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().addActor(generate_settings_button());                              }catch (Exception e){e.printStackTrace();}
            try {   stage.getRoot().addActor(generate_room_button());                                  }catch (Exception e){e.printStackTrace();}

            last_update = Box.get_last_update();
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


    //
    private void plant_click(){game.setScreen(new PlantScreen(game));}
    private void fan_click(){game.setScreen(new FanScreen(game));}
    private void pot_click(){game.setScreen(new PotScreen(game));}
    private void compressor_click(){game.setScreen(new PumpScreen(game));}
    private void lamp_click(){game.setScreen(new LampScreen(game));}

    private void x3_button_click(){
        System.out.println("x3_button click!");
    }
    private void shop_button_click(){
        game.setScreen(new ShopScreen(game));
    }
    private void storage_button_click(){
        game.setScreen(new SeedlingScreen(game));
    }
    private void donation_button_click(){
        game.setScreen(new DonatScreen(game));
    }
    private void settings_button_click(){
        game.setScreen(new SettingsScreen(game));
    }
    private void room_button_click(){
        System.out.println("room_button click!");
    }
    //
    public Group generate_lamp(){
        Group out = new Group();

        if(Box.getInstance().getLamp()==null) return out;

        Image current_lamp;
        Image current_light;

       if(Box.getInstance().getLamp().isOn())
            current_lamp = Box.getInstance().getLamp().
            current_lamp.setPosition(140, 1720);
            current_lamp.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    lamp_click();
                }
            });

            current_light = Box.getInstance().getLamp().get_image_light();



        current_light.setBounds(-40, 0, stage.getWidth(), current_light.getHeight());
        current_light.setTouchable(Touchable.disabled);


        out.addActor(current_light);
        out.addActor(current_lamp);

        out.setPosition(0+40,0);
        out.setName("lamp");


        return out;
    }
    public Image generate_fan(){
        Image current_fan;

        if(Box.getInstance().getFan()!=null){
            current_fan = Box.getInstance().getFan().get_image_fan();

        }else{
            current_fan = new Image(atlas.findRegion("fan_empty"));

        }

        current_fan.setPosition(15+40, 1420);
        current_fan.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                fan_click();
            }
        });
        current_fan.setName("fan");

        return current_fan;
    }
    public Image generate_plant(){
        Image current_plant;

        if(Box.getInstance().getPlant()!=null){
            current_plant = Box.getInstance().getPlant().get_image_plant();

        }else{
            current_plant = new Image(atlas.findRegion("plant_empty"));

        }

        current_plant.setPosition(190+40, 500);
        current_plant.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                plant_click();
            }
        });
        current_plant.setName("plant");


        return current_plant;
    }
    public Image generate_pot(){
        Image current_pot;

        if(Box.getInstance().getPot()!=null){
            current_pot = Box.getInstance().getPot().get_image_pot();

        }else{
            current_pot = new Image(atlas.findRegion("pot_empty"));

        }

        current_pot.setPosition(190+40, 0);
        current_pot.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                pot_click();
            }
        });

        current_pot.setName("pot");

        return current_pot;
    }
    public Image generate_pump(){
        Image current_pump;

        if(Box.getInstance().getPump()!=null){
            current_pump = Box.getInstance().getPump().get_image_pump();

        }else{
            current_pump = new Image(atlas.findRegion("compressor_empty"));

        }

        current_pump.setPosition(780+40, 0);
        current_pump.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                compressor_click();
            }
        });

        current_pump.setName("pump");

        return current_pump;
    }
    //
    public ImageButton generate_x3_button(){
        ImageButton out = new ImageButton(skin, "x3_button");

        out.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                x3_button_click();
            }
        });
        out.setPosition(930+40, 1420);
        out.setName("x3_button");

        return out;
    }
    public ImageButton generate_shop_button(){
        ImageButton out = new ImageButton(skin, "shop_button");

        out.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                shop_button_click();
            }
        });
        out.setPosition(930+40, 1260);
        out.setName("shop_button");

        return out;
    }
    public ImageButton generate_storage_button(){
        ImageButton out = new ImageButton(skin, "storage_button");

        out.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                storage_button_click();
            }
        });
        out.setPosition(930+40, 1100);
        out.setName("storage_button");

        return out;
    }
    public ImageButton generate_donation_button(){
        ImageButton out = new ImageButton(skin, "donation_button");

        out.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                donation_button_click();
            }
        });
        out.setPosition(930+40, 940);
        out.setName("donation_button");

        return out;
    }
    public ImageButton generate_settings_button(){
        ImageButton out = new ImageButton(skin, "settings_button");

        out.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                settings_button_click();
            }
        });
        out.setPosition(0+40, 1260);
        out.setName("settings_button");

        return out;
    }
    public ImageButton generate_room_button(){
        ImageButton out = new ImageButton(skin, "room_button");

        out.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                room_button_click();
            }
        });
        out.setPosition(0+40, 1100);
        out.setName("room_button");

        return out;
    }


}
