package com.acidcarpet.hydroponist.ref.lamp;

import com.acidcarpet.hydroponist.Wrench;

public class Lamp {

    private int energy_production;
    private double temperature;
    private int energy_current;
    public boolean consume(double energy){
        if(energy_current>=energy){
            energy_current-=energy;
            return true;
        }else{
            return false;
        }
    }
    public void second(){
        energy_current = energy_production;
    }

    private boolean on;

    private Type type;

    private Tier tier;

    private TemperatureQuality temperatureQuality;
    private EnergyQuality energyQuality;

    public Lamp(Type type, Tier tier, TemperatureQuality temperatureQuality, EnergyQuality energyQuality) {
        this.type = type;
        this.tier = tier;
        this.temperatureQuality = temperatureQuality;
        this.energyQuality = energyQuality;

        energy_production = (int)
                (Wrench.random_int(tier.minPower, tier.maxPower)
                *
                        Wrench.random_double(energyQuality.minPercent, energyQuality.maxPercent));

        energy_current = energy_production;

        temperature =
                (Wrench.random_double(tier.minTemperature, tier.maxTemperature)
                        *
                        Wrench.random_double(temperatureQuality.minPercent, temperatureQuality.maxPercent));
    }

    public String get_name(){
        String out;

        out = temperatureQuality.name+" "+energyQuality+" "+type.name+" "+tier.name;

        return out;
    }
    public String get_description(){
        String out;

        out = "Эта "+type.name+" поднимает темперутру на "+temperature+"C и светит с мощностью "+energy_production+"W";

        return out;
    }

}
