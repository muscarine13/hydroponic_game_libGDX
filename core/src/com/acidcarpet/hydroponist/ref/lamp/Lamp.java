package com.acidcarpet.hydroponist.ref.lamp;

import com.acidcarpet.hydroponist.Wrench;
import com.acidcarpet.hydroponist.storage.TestPack;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Lamp {
    private TextureAtlas atlas;
    private Type type;
    private Tier tier;
    private TemperatureQuality temperatureQuality;
    private EnergyQuality energyQuality;

    private int energy_production;
    private double temperature;
    private int energy_current;

    private boolean on;

    protected Lamp(Type type, Tier tier, TemperatureQuality temperatureQuality, EnergyQuality energyQuality) {
        atlas = TestPack.getInstance().get_atlas();

        this.type = type;
        this.tier = tier;
        this.temperatureQuality = temperatureQuality;
        this.energyQuality = energyQuality;

        energy_production = (int)
                (Wrench.random_int(tier.minPower, tier.maxPower)
                        *
                        Wrench.random_double(energyQuality.minPercent, energyQuality.maxPercent));

        if (energy_production==0) energy_production = 1;
        energy_current = energy_production;

        temperature = (int)
                (Wrench.random_int(tier.minTemperature, tier.maxTemperature)
                        *
                        Wrench.random_double(temperatureQuality.minPercent, temperatureQuality.maxPercent));
        if(temperature == 0) temperature = 1;
    }


    public synchronized boolean consume(double energy){
        if(energy_current>=energy){
            energy_current-=energy;
            return true;
        }else{
            return false;
        }
    }
    public synchronized void second(){
        energy_current = energy_production;
    }

    public String get_name(){
        String out;

        out = temperatureQuality.name+" "+energyQuality.name+" "+type.name+" "+tier.name;

        return out;
    }
    public String get_description(){
        String out;

        out = "Эта "+type.name+" поднимает темперутру на "+temperature+"C и светит с мощностью "+energy_production+"W";
        out+= " ";

        if(type.bloom_multiplier==type.grow_multiplier)
            out+= "Спектр этой лампы одинаково влияет на цветение и рост.";
        else if(type.bloom_multiplier>type.grow_multiplier){
            out+= "Спектр этой лампы способствует цветению.";
        }else{
            out+= "Спектр этой лампы обеспечивает интенсивный рост.";
        }

        return out;
    }
    public Image get_image(){

        TextureAtlas atlas = TestPack.getInstance().get_atlas();
        if(on)
            return new Image(atlas.findRegion(type.id+"_"+tier.name+"_on"));
        else
            return new Image(atlas.findRegion(type.id+"_"+tier.name+"_off"));

    }
}
