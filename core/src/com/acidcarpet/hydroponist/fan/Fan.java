package com.acidcarpet.hydroponist.fan;
import com.acidcarpet.hydroponist.Wrench;
import com.acidcarpet.hydroponist.storage.Storable;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Fan implements Storable {
    private TextureAtlas atlas;

    private Tier tier;
    private TemperatureQuality temperatureQuality;
    private EnergyQuality energyQuality;

    private int air_production;
    private double temperature;
    private int air_current;

    private boolean on;

    public void setOn(boolean on) {
        this.on = on;
    }


    protected Fan(Tier tier, TemperatureQuality temperatureQuality, EnergyQuality energyQuality ) {

        this.tier = tier;
        this.temperatureQuality = temperatureQuality;
        this.energyQuality = energyQuality;

        air_production = (int)
                (Wrench.random_int(tier.minPower, tier.maxPower)
                        *
                        Wrench.random_double(energyQuality.minPercent, energyQuality.maxPercent));

        if (air_production==0) air_production = 1;
        air_current = air_production;

        temperature = (int)
                (Wrench.random_int(tier.minTemperature, tier.maxTemperature)
                        *
                        Wrench.random_double(temperatureQuality.minPercent, temperatureQuality.maxPercent));
        if(temperature == 0) temperature = 1;
    }

    public synchronized boolean consume(double volume){
        if(air_current >=volume){
            air_current -=volume;
            return true;
        }else{
            return false;
        }
    }
    public synchronized void second(){
        air_current = air_production;
    }

    public String get_name(){
        String out;

        out = energyQuality.name+" "+temperatureQuality.name+" "+"вентилятор"+" "+tier.name;

        return out;
    }
    public String get_description(){
        String out;

        out="Вентилятор понижающий температуру на "+temperature+"C и прогоняет в скунду +"+air_production+" литров воздуха";

        return out;
    }
    public Image get_on_image(){
        return new Image(atlas.findRegion("fan_"+tier.name+"_on"));
    }
    public Image get_off_image(){
        return new Image(atlas.findRegion("fan_"+tier.name+"_on"));
    }


    public TemperatureQuality getTemperatureQuality() {
        return temperatureQuality;
    }
    public EnergyQuality getEnergyQuality() {
        return energyQuality;
    }
    public int getEnergy_production() {
        return air_production;
    }
    public double getTemperature() {
        return temperature;
    }
    public int getAir_current() {
        return air_current;
    }
    public boolean isOn() {
        return on;
    }
    public Tier getTier() {
        return tier;
    }
    public int getAir_production() {
        return air_production;
    }


}
