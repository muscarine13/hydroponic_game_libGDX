package com.acidcarpet.hydroponist.lamp;

import com.acidcarpet.hydroponist.ContentPack;
import com.acidcarpet.hydroponist.Wrench;
import com.acidcarpet.hydroponist.storage.Storable;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Lamp implements Storable {

    private Type type;
    private Tier tier;
    private TemperatureQuality temperatureQuality;
    private EnergyQuality energyQuality;

    private int energy_production;
    private double temperature;
    private int energy_current;

    private boolean on;

    public void setOn(boolean on) {
        this.on = on;
    }

    protected Lamp(com.acidcarpet.hydroponist.lamp.Type type, Tier tier, com.acidcarpet.hydroponist.lamp.TemperatureQuality temperatureQuality, com.acidcarpet.hydroponist.lamp.EnergyQuality energyQuality) {


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

    public Image get_on_image(){

       return new Image(ContentPack.getAll_atlas().findRegion(type.id+"_"+tier.name+"_on"));



    }
    public Image get_off_image(){
        return new Image(ContentPack.getAll_atlas().findRegion(type.id+"_"+tier.name+"_off"));
    }
    public Image get_light_image(){
        return new Image(ContentPack.getAll_atlas().findRegion(type.id+"_"+tier.name+"_light"));
    }

    public Type getType() {
        return type;
    }
    public Tier getTier() {
        return tier;
    }
    public TemperatureQuality getTemperatureQuality() {
        return temperatureQuality;
    }
    public EnergyQuality getEnergyQuality() {
        return energyQuality;
    }
    public int getEnergy_production() {
        return energy_production;
    }
    public double getTemperature() {
        return temperature;
    }
    public int getEnergy_current() {
        return energy_current;
    }
    public boolean isOn() {
        return on;
    }

    @Override
    public com.acidcarpet.hydroponist.storage.Type getStorableType() {
        return com.acidcarpet.hydroponist.storage.Type.LAMP;
    }
}
